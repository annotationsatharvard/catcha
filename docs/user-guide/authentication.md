# Overview
The current version of the CATCH API (v0.5.4) adopts the JSON Web Token (JWT) standard.

## Json Web Token 
We are using Json Web Token (JWT) for authentication because that was the adopted standard used by the [annotatorjs library](http://annotatorjs.org/).


## Token Usage 
In order for an API consumer to make a request of the CATCH API, it needs to include an `x-annotator-auth-token` 
request header. The examples below show a valid token vs invalid token. 

### Valid Token
```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjM1NjI0NjEzLTcxOGUtNGI2My1hZTk5LTdiZTZkZjkwMThjZiIsImlzc3VlZEF0IjoiMjAxNS0wNS0xNVQwMjozNDo0MS0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiJmYTczNmM0Ni1iZTRlLTQzZDItODlmOC1iNTRlZjA4YjU4MTYiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzE3MTQ4ODF9.tVMoHE5frPT_nDzXgU3jB6eAN97aDL0yBdExlm0hKEs" 
"http://localhost:8080/catch/annotator/search?limit=10"
```

### Invalid token
```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token: INVALID-TOKEN" 
"http://localhost:8080/catch/annotator/search?limit=10"
```


### Note
```
It seems that the authentication may have changed as of annotatorjs v2.0 (or at least it 
seems they now leave the auth mechanism choice up to the API consumer and provider to negotiate). For now, we will continue to 
use JWT until a more suitable alternative is available. Recommendations are welcome. Please add a ticket
to [GitHub Issues](https://github.com/annotationsatharvard/catcha/issues) if you'd like to request support for additional authentication
mechanisms.
```

## API Key & Secret Key

### API Key 
The API key is generated when a new API system is created in the backend. Each CATCH API consumer is required to 
register with their API provider before they can gain access to the API. The API key (also known as 
the API consumer key) is used by the CATCH API consumer to identify itself to the provider for authentication purposes.
The API key is passed around in cleartext so it should not be considered sensitive. A malicious user would need the 
API key and secret key in order to access a CATCH API provider.

### Secret Key
The secret key is a secret UUID shared between the API provider and consumer that is used by the consumer to sign each 
JWT for each request made. It is generated on the API provider-side when a new API consumer is registered and can be used 
as long as the secret has not been compromised. It is very important to keep this secret key out of the hands of malicious 
users. If you suspect that your secret key has been compromised (e.g. you shared it with somebody) you can easily request
a new secret key from your API provider.

## Token formats 
There are various token formats available for use by the CATCH API. The term "format" is used loosely here, but essentially 
the format describes the payload (specifically, the custom claims) of the JWT that is used by the API provider to determine whether the token 
(and subsequently, the consumer) is valid.

### AnnotatorJS 
The first format we supposed was the one provided by AnnotatorJS. According to the 
[AnnotatorJS documentation](http://docs.annotatorjs.org/en/v1.2.x/authentication.html#technical-specification), the
required contents of the token payload are:

#### Custom Claims
+-------------------+----------------------------------------------------------------------------------+------------------------------------------+
| name              | description                                                                      | example                                  |
+-------------------+----------------------------------------------------------------------------------+--------------------------------------------+
| ``consumerKey``   | the consumer key issued by the backend store                                     | ``"602368a0e905492fae87697edad14c3a"``   |
| ``userId``        | the consumer's **unique** identifier for the user to whom the token was issued   | ``"alice"``                              |
| ``issuedAt``      | the ISO8601 time at which the token was issued                                   | ``"2012-03-23T10:51:18Z"``               |
| ``ttl``           | the number of seconds after ``issuedAt`` for which the token is valid            | ``86400``                                |
+-------------------+----------------------------------------------------------------------------------+------------------------------------------+

#### Example Token
```
eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjM1NjI0NjEzLTcxOGUtNGI2My1hZTk5LTdiZTZkZjkwMThjZiIsImlzc3VlZEF0IjoiMjAxNS0wNS0xNVQwMjozNDo0MS0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiJmYTczNmM0Ni1iZTRlLTQzZDItODlmOC1iNTRlZjA4YjU4MTYiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzE3MTQ4ODF9.tVMoHE5frPT_nDzXgU3jB6eAN97aDL0yBdExlm0hKEs
```
#### Header
```
{
  "alg": "HS256",
  "cty": "text/plain",
  "typ": "JWS"
}
```
#### Payload
```
{
  "consumerKey": "35624613-718e-4b63-ae99-7be6df9018cf",
  "issuedAt": "2015-05-15T02:34:41-0400",
  "userId": "jmiranda",
  "jti": "fa736c46-be4e-43d2-89f8-b54ef08b5816",
  "ttl": 86400,
  "iat": 1431714881
}
```
#### Additional Reading
* http://docs.annotatorjs.org/en/v1.2.x/authentication.html
* http://docs.annotatorjs.org/en/v1.2.x/plugins/auth.html



### Firebase
The claims used with the [Firebase JSON Web Token](https://www.firebase.com/docs/rest/guide/user-auth.html#section-rest-tokens-without-helpers) 
are the same as those used by the AnnotatorJS token. The only difference is that the Firebase tokens add an addition l
ayer in the payload (see Payload section below).

#### Custom Claims
+-------------------+----------------------------------------------------------------------------------+------------------------------------------+
| name              | description                                                                      | example                                  |
+-------------------+----------------------------------------------------------------------------------+------------------------------------------+
| ``consumerKey``   | the consumer key issued by the backend store                                     | ``"602368a0e905492fae87697edad14c3a"``   |
| ``userId``        | the consumer's **unique** identifier for the user to whom the token was issued   | ``"jmiranda"``                           |
| ``issuedAt``      | the ISO8601 time at which the token was issued                                   | ``"2012-03-23T10:51:18Z"``               |
| ``ttl``           | the number of seconds after ``issuedAt`` for which the token is valid            | ``86400``                                |
+-------------------+----------------------------------------------------------------------------------+------------------------------------------+

#### Token 
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE0MzE2MzUzMjIsImQiOnsiaXNzdWVkQXQiOiIyMDE1LTA1LTE0VDIwOjI4OjQyLjA4NDQyMSswOjAwIiwiY29uc3VtZXJLZXkiOiJhZjE3ZmNiNi1hZTE2LTQyYjctOTdmNi1iMmQxYjJkNjYyMjYiLCJ1aWQiOiI3NmU5YzU0ZDA2YTI4NzE3YTgzN2VhNzc5NDYwMTVkOCIsInR0bCI6MTcyODAwfSwidiI6MH0.zdam8VmR6IR7ELBDpZlZ-E6Z923KY5Jc2B8VoT-oJhQ
```

#### Header 
```
{
  "alg": "HS256",
  "typ": "JWT"
}
```
#### Payload
```
{
  "d": {
      "iat": 1431635322,
    "issuedAt": "2015-05-14T20:28:42.084421+0:00",
    "consumerKey": "af17fcb6-ae16-42b7-97f6-b2d1b2d66226",
    "uid": "76e9c54d06a28717a837ea77946015d8",
    "ttl": 172800
  },
  "v": 0
}
```

### Standard
We are not currently supporting any of the standard format (e.g. custom claims), but I wanted to include these since they 
are part of the JWT standard and probably should be used instead of our custom claims.

#### Custom Claims
+-------------------+----------------------------------------------------------------------------------+--------------------------------------------+
|  key              | description                                                                      | example                                    |
+-------------------+----------------------------------------------------------------------------------+--------------------------------------------+
| ``iss``           | The issuer of the token                                                          | ``"602368a0e905492fae87697edad14c3a"``     |
| ``sub``           | The subject of the token (email, API key)                                        | ``"35624613-718e-4b63-ae99-7be6df9018cf"`` |
| ``aud``           | The audience of the token                                                        | ``"2012-03-23T10:51:18Z"``                 |
| ``exp``           | This will probably be the registered claim most often used. This will define the expiration in NumericDate value. The expiration MUST be before the current date/time.            | ``86400``   |
| ``nbf``           | Defines the time before which the JWT MUST NOT be accepted for processing        | ``86400``                                  |
| ``iat``           | The time the JWT was issued. Can be used to determine the age of the JWT         | ``1416929061``                             |
| ``jti``           | Unique identifier for the JWT. Can be used to prevent the JWT from being replayed. This is helpful for a one time use token.  | ``802057ff9b5b4eb7fbb8856b6eb2cc5b``                                |
+-------------------+----------------------------------------------------------------------------------+--------------------------------------------+

#### Token
```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIzNTYyNDYxMy03MThlLTRiNjMtYWU5OS03YmU2ZGY5MDE4Y2YiLCJqdGkiOiJmYTczNmM0Ni1iZTRlLTQzZDItODlmOC1iNTRlZjA4YjU4MTYiLCJpYXQiOjE0MzE3MTQ4ODF9.OuO2MHeqHFaU0sOuqmSeaPfgInLjJIM0aiqR3nvnQns
```
#### Header
```
{
  "alg": "HS256",
  "typ": "JWT"
}
```
#### Payload
```
{
  "sub": "35624613-718e-4b63-ae99-7be6df9018cf",
  "jti": "fa736c46-be4e-43d2-89f8-b54ef08b5816",
  "iat": 1431714881,
}
```

## Additional Reading 
* [http://tools.ietf.org/html/draft-ietf-oauth-json-web-token-06](http://tools.ietf.org/html/draft-ietf-oauth-json-web-token-06)
* [http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html](http://self-issued.info/docs/draft-ietf-oauth-json-web-token.html)
* [https://scotch.io/tutorials/the-anatomy-of-a-json-web-token](https://scotch.io/tutorials/the-anatomy-of-a-json-web-token)
* [http://jwt.io](http://jwt.io)

