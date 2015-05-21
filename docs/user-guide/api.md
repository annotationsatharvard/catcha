# API Docs

## Overview
The initial version of the CATCH-A API supported the basic [Storage and Search API](http://docs.annotatorjs.org/en/v1.2.x/storage.html) specification provided by 
annotatorjs. The current version adds support for a few more 
features to the Storage and Search APIs and we continue to extend the API to support even more features. If you 
have any requests for new functionality please add an issue to our [GitHub Issue tracker](https://github.com/annotationsatharvard/catcha/issues).

<!--
## Generate a token
### Request
```
curl -i -X GET \
-H "Content-Type: application/json" \
"http://localhost:8080/catch/annotator/token?apiKey=eeb20ec0-b8dd-40ae-b3de-14870aff92c6&username=jmiranda&ttl=86400"
```
### Response
```
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Type: text/html;charset=utf-8
Content-Length: 356
Date: Thu, 21 May 2015 19:31:32 GMT

eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6ImVlYjIwZWMwLWI4ZGQtNDBhZS1iM2RlLTE0ODcwYWZmOTJjNiIsImlzc3VlZEF0IjoiMjAxNS0wNS0yMVQwMzozMTozMi0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiJjNmNmOWU0NC1kZDMwLTQ0MDktOGNlZS02OTVmODRhODQxOTQiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzIyMzY2OTJ9.94AasywloTR-vR55uFtXc_AGeLeZIUu_ErMLS8_XsR8
```
-->

## Search API
### Request
```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6Ijc1MmRjOWM3LWRlOTYtNGU2OC05NzM5LTlmOTVlNWM2MTVhOSIsImlzc3VlZEF0IjoiMjAxNS0wNC0xMFQxMDoyNjozMS0wNDAwIiwidXNlcklkIjpudWxsLCJqdGkiOiI1Zjc4MTc2Yi02NThjLTRiMmMtYjFlNC04NmE5MmE3NjNlOTciLCJ0dGwiOm51bGwsImlhdCI6MTQyODY3NTk5MX0.O0KxIrXzxMWqagqvotTzEkpL2OZ_h3rkB5w9nmW0ufY" 
http://localhost:8080/catch/annotator/search 
```
### Response
```
```

### Request
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6ImVlYjIwZWMwLWI4ZGQtNDBhZS1iM2RlLTE0ODcwYWZmOTJjNiIsImlzc3VlZEF0IjoiMjAxNS0wNC0xMVQwMTo1MDo0OS0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiIxMWE0MTUzMi0xOWJiLTRmMTctYWY1Zi1jNzg3Y2E0YzhhNjAiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0Mjg3NzQ2NDl9.naoxEc6QIRUuxUGZpLtmvgVfPsBkLISRGLohqBiyCjU"\ 
"http://localhost:8080/catch/annotator/search"
```
### Response
```
```

### Request
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE0MzA3NzExNjAsImQiOnsiaXNzdWVkQXQiOiIyMDE1LTA1LTA0VDIwOjI2OjAwLjA1MzA4OCswOjAwIiwiY29uc3VtZXJLZXkiOiJhZjE3ZmNiNi1hZTE2LTQyYjctOTdmNi1iMmQxYjJkNjYyMjYiLCJ1aWQiOiJ0ZXN0QG1pcmFkb3Iub3JnIiwidHRsIjoxNzI4MDB9LCJ2IjowfQ.fjNmf-PbC0YInfU0ddHPmMJ4P3ccciMLdOjvQ8E3r9A" \
"http://localhost:8080/catch/annotator/search?uri=1_Summer/BMo101/2013_Spring_2"
```
### Response
```

```

### Request
```
curl -i -X GET \
-H "Content-Type: application/json" \
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjllYTJlZGUwLTQ2OTMtNGJlYy05MDk0LWIxZTNlN2E2YTM1NiIsImlzc3VlZEF0IjoiMjAxNS0wNS0wOFQwNzowNToxMCswMDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiI3ZmU0YWM5OS1kMDE2LTQ0YTgtOTNmZi0yNTQ5NDU0OTg5NjkiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzExMTE5MTB9.sSPsSJkJPXTXmShdws2_8c-obeMWnFuaysZnFcAVMe4" \
"http://localhost:8080/catch/annotator/search?limit=10"
```
### Response
```
```







