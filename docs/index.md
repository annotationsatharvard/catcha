## Overview 

This software was created for the [Harvard Library Labs CATCH project](https://osc.hul.harvard.edu/liblab/proj/catch) awarded to Phil Desenne, Martin Schreiner and Paolo Ciccarese.

![Screenshot](/img/hub-architecture.png)
<p style="text-align:center">Annotation Hub</p>


## Details

### Storage API
The AnnotatorJS Store API actions allow clients to perform CRUD operations (create, read, update,
delete) for annotations they want to store in the CATCH backend. Storing the annotations in a
remote backend allows clients to ignore the complexity of building their own backend. In addition,
the CATCH API provides other services such as Security and Search which enables the clients to
focus on making their applications more user-friendly and not on complex backend logic. The
CATCH API also implements actions from the Harvard Annotation API Draft Spec (including
archive and destroy).

### Search API
The AnnotatorJS Search API is a basic search mechanism that allows clients to retrieve annotations
by source, target, annotation text, and other attributes. The current Search API relies on a relational
data model to pull out attributes that are available for searching. In other words, we store the JSON
annotation document in a large text column and index on attributes that we want to expose to the
search API. Therefore, we can only search on fields that we have indexed. In a future release, we
will be moving to a document store which will allow us to provide a more flexible search API.

### Security (Authentication / Authorization)
The CATCH API provides basic security using the JSON Web Token draft standard. The client is responsible for
generating an auth token on every request. This is one of the more complicated pieces for clientside
developers as it requires the developer to build their own token generator in the language of
their choice. The auth token is basically a payload with authentication data (consumer public key,
time-to-live, issued-at) signed with a secret shared between the client and server.   On every request
made by the client, the server checks for an auth token and verifies that the token has not expired.
This provides minimal security between the software, but obviously does not handle user
authorization and whether a particular user should have access to an annotation. At the moment,
the CATCH API does not restrict access to annotations -- all annotations are public. However, the
Permissions spec for AnnotatorJS allows clients to provide filtering on the client-side. In the future,
the CATCH API will improve on the authorization mechanism and only allow authenticated users
with proper permission to access annotations from the API.

## Future Plans
The next phase of the CATCH project contemplates the implementation of a document-oriented
database designed for ease of development and scaling, coupled with a distributed restful search and
analytics engine that is schema free. For this we are considering open source solutions such as
[MongoDb](http://www.mongodb.org/) and [ElasticSearch](http://www.elasticsearch.org). On the
client-side we will extend and refine the usability of the Annotation Grid Display to accommodate
multiple tool-independent annotation scenarios.

Furthermore, we will continue testing the implementations of the AH and Annotation Grid Display
inside the edX platform and define APIs to connect the Library resources from the DRS inside the
edX annotation modules. 

## Project Team

* Paolo Ciccarese - Lead Technical Architect and Data Model Design
* Phil Desenne - Lead Application Design and Instructional Technology
* Martin Schreiner - Library Integration and Quality Assurance
* Justin Miranda - Back-end Database Development
* Daniel Cebrian - Front-end UI Development
* Mark Soper - Front-end UI Development
* Lynn Sayers - Project Budget and Finances