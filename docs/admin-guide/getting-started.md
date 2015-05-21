## Assumptions
* You have successfully deployed the CATCH-A web application to a cloud service of your choosing (AWS EC2, AWS EBS, DigitalOcean, RimuHosting, etc).

## Create an API Client 
Currently, there's no way for developers to request or manage their client API key, so the owner of this API instance needs to manually create all API keys for external developers. 

To create a new client API key you need to log into CATCH-A as an administrator. 

### Login as an admin
* URL: http://localhost:8080/catch
* Username: admin
* Password: password

### Administrative dashboard
1. Navigate your browser to the [CATCH-A Admin Dashboard](http://localhost:8080/catch/dashboard/index)

### List all existing systems
* Click the List Systems link in the leftnav to view existing systems

### Create a new system
* Click the Create System link in the leftnav
* Enter a descriptive name (e.g."Justin's Demo Client API")
* Enter a short code ("JUSTIN-DEMO").
* Enter the client URL (and the client developer's email address) in the description field so that we can contact the client developer in case of an issue.
* Click the Save System button.
* Copy the API key from the subsequent page (we'll use it in the client's token generation code below).

### Add AnnotatorJs client code to your page
See the annotator.js documentation for [](http://docs.annotatorjs.org/en/latest/).  Your client code will connect to the annotator.js API you installed in the [Installation](/admin-guide/installation) instructions (e.g. http://localhost:8080/catch/annotator).

#### Example client code

	<html>
	<head>
	<body>
		<div id="content">
			Hello World!
		</div>

		<script type="text/javascript" src="http://assets.annotateit.org/annotator/v1.2.5/annotator-full.min.js"/>
		<script type="text/javascript" src="http://assets.annotateit.org/annotator/v1.2.5/annotator.min.css"/>

		<script>
		    $(function () {

			var content = $('#content').annotator();

			// Generate a token for each request (token generator should be accessible via a relative URL)
			content.annotator('addPlugin', 'Auth', {
			    tokenUrl: '<url-for-token-generator>'   // for example /client/auth/token
			});


			// Connect to your annotation store
			content.annotator('addPlugin', 'Store', {
			    // The endpoint of the store on your server (can be relative or absolute)
			    // Examples:
			    //    prefix: '/store/endpoint',
			    //    prefix: 'http://afstore.aws.af.cm/annotator',
			    prefix: 'http://localhost:8080/catch/annotator',

			    // Attach the uri of the current page to all annotations to allow search.
			    annotationData: {
				'uri': 'http://www.client.com/page-to-be-annotated'
			    },
			    urls: {
				// These are the default URLs.
				create:  '/create',
				read:    '/read/:id',
				update:  '/update/:id',
				destroy: '/destroy/:id',
				search:  '/search'
			    },
			    // This will perform a "search" action rather than "read" when the plugin
			    // loads. Will request the last 20 annotations for the current url.
			    // eg. /store/endpoint/search?limit=20&uri=http://this/document/only
			    loadFromSearch: {
				'limit': 20,
				'uri': '${createLink(action: action, controller: controller, id: id, absolute:true)}'
			    }
			});

			// Optional plugins
			content.annotator('addPlugin', 'Tags');
			content.annotator('addPlugin', 'Filter', {
			    filters: [
				{
				    label: 'Quote',
				    property: 'quote'
				}
			    ]});
			//content.annotator('addPlugin', 'Markdown');
			//content.annotator('addPlugin', 'Permissions', {
			//    user: 'jmiranda'
			//});

		    });
		</script>
	</body>
	</html>



## Generate a token
Using your favorite programming language (PHP, Python, Java) and its associated JWT library you need to write code that will allow you to generate a token that can be used by your client (see `Auth` plugin documentation in AnnotatorJs documentation for more details). 


### Resources
* http://docs.annotatorjs.org/en/latest/plugins/auth.html
* http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html

### Example Code (Java) 
This code was written in Groovy using the Nimbus JOSE JWT library (https://bitbucket.org/connect2id/nimbus-jose-jwt/wiki/Home).  In addition to the token generation code, you need to expose an HTTP endpoint that renders the generated token to the HTTP response (http://docs.annotatorjs.org/en/latest/authentication.html).  For example, I wrote a quick demo application that ran at http://localhost:8081/afdemo/index.html.  The demo app included the client code above (rendered as an HTML page) and a token generation endpoint at http://localhost:8081/afdemo/token/auth that simply rendered the token generated below.


	public String generateToken() { 
		JWTClaimsSet jwtClaims = new JWTClaimsSet();
		jwtClaims.setIssueTime(new Date());
		jwtClaims.setJWTID(UUID.randomUUID().toString());

		// Each request should include the authenticated username (optional)
		jwtClaims.setCustomClaim("userId", "jmiranda");						

		// Corresponds to the API key above
		jwtClaims.setCustomClaim("consumerKey", "b94a3109-e4a5-49a5-9503-05579bea69ff");

		// Time to live (optional) 	
		jwtClaims.setCustomClaim("ttl", 86400);

		// Time token was issued (ex: 2013-08-30T22:23:30+00:00)		
		jwtClaims.setCustomClaim("issuedAt", new Date().format("yyyy-MM-dd'T'hh:mm:ssZ")); 

		// Create JWS header with HS256 algorithm
		JWSHeader header = new JWSHeader(JWSAlgorithm.HS256);
		header.setContentType("text/plain");
		header.setType(JOSEObjectType.JWS)

		// Create JWS object
		JWSObject jwsObject = new JWSObject(header, new Payload(jwtClaims.toJSONObject()));

		// Create HMAC signer
		JWSSigner signer = new MACSigner(SHARED_KEY.getBytes());

		try {
		    jwsObject.sign(signer);
		} catch(com.nimbusds.jose.JOSEException e) {
		    System.err.println("Error signing JWT: " + e.getMessage());
		    return;
		}

		// Serialise to JWT compact form
		return jwsObject.serialize();
	}

### Example Code (Python)
 
	import datetime
	import jwt
	
	# Replace these with your details
	CONSUMER_KEY = 'yourconsumerkey'
	CONSUMER_SECRET = 'yourconsumersecret'
	
	# Only change this if you're sure you know what you're doing
	CONSUMER_TTL = 86400
	
	def generate_token(user_id):
		return jwt.encode({
			'consumerKey': CONSUMER_KEY,
			'userId': user_id,
			'issuedAt': _now().isoformat() + 'Z',
			'ttl': CONSUMER_TTL
		}, CONSUMER_SECRET)
	
	def _now():
		return datetime.datetime.utcnow().replace(microsecond=0)
