# API Docs

## Overview
The initial version of the CATCH-A API supported the basic [Storage and Search API](http://docs.annotatorjs.org/en/v1.2.x/storage.html) specification provided by 
annotatorjs. The current version adds support for a few more 
features to the Storage and Search APIs and we continue to extend the API to support even more features. If you 
have any requests for new functionality please add an issue to our [GitHub Issue tracker](https://github.com/annotationsatharvard/catcha/issues).


### Generate a token
```
curl -i -X GET 
-H "Content-Type: application/json"  
"http://localhost:8080/catch/annotator/token?apiKey=eeb20ec0-b8dd-40ae-b3de-14870aff92c6&username=jmiranda&ttl=86400"
```

### Search 
```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6Ijc1MmRjOWM3LWRlOTYtNGU2OC05NzM5LTlmOTVlNWM2MTVhOSIsImlzc3VlZEF0IjoiMjAxNS0wNC0xMFQxMDoyNjozMS0wNDAwIiwidXNlcklkIjpudWxsLCJqdGkiOiI1Zjc4MTc2Yi02NThjLTRiMmMtYjFlNC04NmE5MmE3NjNlOTciLCJ0dGwiOm51bGwsImlhdCI6MTQyODY3NTk5MX0.O0KxIrXzxMWqagqvotTzEkpL2OZ_h3rkB5w9nmW0ufY" 
http://localhost:8080/catch/annotator/search 
```

```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6ImVlYjIwZWMwLWI4ZGQtNDBhZS1iM2RlLTE0ODcwYWZmOTJjNiIsImlzc3VlZEF0IjoiMjAxNS0wNC0xMVQwMTo1MDo0OS0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiIxMWE0MTUzMi0xOWJiLTRmMTctYWY1Zi1jNzg3Y2E0YzhhNjAiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0Mjg3NzQ2NDl9.naoxEc6QIRUuxUGZpLtmvgVfPsBkLISRGLohqBiyCjU" 
http://localhost:8080/catch/annotator/search 
```

```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE0MzA3NzExNjAsImQiOnsiaXNzdWVkQXQiOiIyMDE1LTA1LTA0VDIwOjI2OjAwLjA1MzA4OCswOjAwIiwiY29uc3VtZXJLZXkiOiJhZjE3ZmNiNi1hZTE2LTQyYjctOTdmNi1iMmQxYjJkNjYyMjYiLCJ1aWQiOiJ0ZXN0QG1pcmFkb3Iub3JnIiwidHRsIjoxNzI4MDB9LCJ2IjowfQ.fjNmf-PbC0YInfU0ddHPmMJ4P3ccciMLdOjvQ8E3r9A" 
"http://54.148.223.225:8080/catch/annotator/search?uri=1_Summer/BMo101/2013_Spring_2"
```

```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjllYTJlZGUwLTQ2OTMtNGJlYy05MDk0LWIxZTNlN2E2YTM1NiIsImlzc3VlZEF0IjoiMjAxNS0wNS0wOFQwNzowNToxMCswMDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiI3ZmU0YWM5OS1kMDE2LTQ0YTgtOTNmZi0yNTQ5NDU0OTg5NjkiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzExMTE5MTB9.sSPsSJkJPXTXmShdws2_8c-obeMWnFuaysZnFcAVMe4" "
http://54.148.223.225:8080/catch/annotator/search?limit=10"
```

```
curl -i -X GET 
-H "Content-Type: application/json" 
-H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjllYTJlZGUwLTQ2OTMtNGJlYy05MDk0LWIxZTNlN2E2YTM1NiIsImlzc3VlZEF0IjoiMjAxNS0wNS0wOFQwODoxMjoxOCswMDAwIiwidXNlcklkIjoiYWRtaW4iLCJqdGkiOiJiMjgxYzNmMy00YTg1LTQ3OWQtYWZlMS1mNTVmOTgyOGVmOWIiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzExMTU5Mzh9.AduJJX_VijIEKUQ5WO_Ofu6tCURQZ67mf-_72LcJmU8" 
"http://54.148.223.225/catch/annotator/search?limit=10"
```
