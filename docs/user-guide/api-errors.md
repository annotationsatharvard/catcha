## Invalid token

### Request 
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:invalid-token" \
"http://localhost:8080/catch/annotator/search?limit=10"
```
### Response
```
HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Content-Length: 0
Date: Thu, 21 May 2015 19:51:53 GMT

```

## Missing token

### Request 
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:" \
"http://localhost:8080/catch/annotator/search?limit=10"
```
### Response
```
HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=utf-8
Content-Length: 234
Date: Thu, 21 May 2015 19:52:35 GMT

You are not authorized to access annotations without a valid token. Please include an 'x-annotator-auth-token' request header. See AnnotatorJs documentation for more details (http://docs.annotatorjs.org/en/latest/authentication.html).
```

## System API with key <api-key> is currently disabled
If you encounter this error, ask your system administrator to enable your API key. 
![Screenshot](/img/disabled-api-key.png)

### Request
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjllYTJlZGUwLTQ2OTMtNGJlYy05MDk0LWIxZTNlN2E2YTM1NiIsImlzc3VlZEF0IjoiMjAxNS0wNS0wOFQwODoxMjoxOCswMDAwIiwidXNlcklkIjoiYWRtaW4iLCJqdGkiOiJiMjgxYzNmMy00YTg1LTQ3OWQtYWZlMS1mNTVmOTgyOGVmOWIiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzExMTU5Mzh9.AduJJX_VijIEKUQ5WO_Ofu6tCURQZ67mf-_72LcJmU8" \
"http://localhost:8080/catch/annotator/search?limit=10"
```
### Response
```
HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=utf-8
Content-Length: 125
Date: Thu, 21 May 2015 19:34:19 GMT

You are not authorized to access annotations: System API with key 9ea2ede0-4693-4bec-9094-b1e3e7a6a356 is currently disabled.
```

## The shared secret must not be null
If this encounter this error, ask your system administrator to generate your secret key. 

![Screenshot](/img/secret-key-cannot-be-null.png)

### Request 
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjllYTJlZGUwLTQ2OTMtNGJlYy05MDk0LWIxZTNlN2E2YTM1NiIsImlzc3VlZEF0IjoiMjAxNS0wNS0wOFQwODoxMjoxOCswMDAwIiwidXNlcklkIjoiYWRtaW4iLCJqdGkiOiJiMjgxYzNmMy00YTg1LTQ3OWQtYWZlMS1mNTVmOTgyOGVmOWIiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzExMTU5Mzh9.AduJJX_VijIEKUQ5WO_Ofu6tCURQZ67mf-_72LcJmU8" \
"http://localhost:8080/catch/annotator/search?limit=10"

```

### Response
```
HTTP/1.1 401 Unauthorized
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=utf-8
Content-Length: 80
Date: Thu, 21 May 2015 19:35:48 GMT

You are not authorized to access annotations: The shared secret must not be null
```

