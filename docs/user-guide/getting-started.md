# Getting Started

## Generate Token
```
eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6ImRlNWYwNmRkLWVhZGYtNGQ2NS05ODg1LWMwMzBjZDJmOGUwNyIsImlzc3VlZEF0IjoiMjAxNS0wNS0yMVQxMjo0MzoyNC0wNDAwIiwidXNlcklkIjoiYWRtaW4iLCJqdGkiOiIyMzk0ZGE5ZC1hY2U1LTRjOTQtYWYzZC1hOWY4Yjk1OGVjNTEiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzIyMjY2MDR9.RfJlIwAoRaIXi5a2KKvJ_6xJUlzM3FMXekp-Iky1uCU
```

NOTE: You can verify the token by copying the value above and pasting it in the token field on jwt.io

curl -i -X GET -H "Content-Type: application/json" -H "x-annotator-auth-token:eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6ImRlNWYwNmRkLWVhZGYtNGQ2NS05ODg1LWMwMzBjZDJmOGUwNyIsImlzc3VlZEF0IjoiMjAxNS0wNS0yMVQxMjo0MzoyNC0wNDAwIiwidXNlcklkIjoiYWRtaW4iLCJqdGkiOiIyMzk0ZGE5ZC1hY2U1LTRjOTQtYWYzZC1hOWY4Yjk1OGVjNTEiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MzIyMjY2MDR9.RfJlIwAoRaIXi5a2KKvJ_6xJUlzM3FMXekp-Iky1uCU" "http://localhost:8080/catch/annotator/search?limit=10"

NOTE: To change the base URL in the above cURL command, you need to add the following property to your catch-config.properties file.
grails.serverURL = http://www.example.com
