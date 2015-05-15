# Authentication

The current version of the CATCH-A API (v0.5.4) adopts the JSON Web Token standard 


## Json Web Token 
We are using JWT for authentication because that was the adopted standard used by the [annotatorjs library](http://annotatorjs.org/).
* http://docs.annotatorjs.org/en/v1.2.x/plugins/auth.html
* http://docs.annotatorjs.org/en/v1.2.x/authentication.html

.. note::   It seems that the authentication may have changed as of v2.0 of annotatorjs (or at least it 
            seems they now leave the choice up to the API consumer and provider to negotiate). For now, we will continue to 
            use JWT until a more suitable alternative is available. Recommendations are welcome ... please add a ticket
            to [GitHub Issues](https://github.com/annotationsatharvard/catcha/issues) to request support for additional authentication
            mechanisms.

### API Key & Secret Key

### Expected format 



### Example



## Additional Resources 
* [http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html](http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html)
* [https://scotch.io/tutorials/the-anatomy-of-a-json-web-token](https://scotch.io/tutorials/the-anatomy-of-a-json-web-token)
* [http://jwt.io](http://jwt.io)


