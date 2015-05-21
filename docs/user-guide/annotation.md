## Annotation Format
According to the [annotatorjs documentation](http://docs.annotatorjs.org/en/v1.2.x/annotation-format.html)

> An annotation is a JSON document that contains a number of fields describing the position and content of an annotation
> within a specified document:
```
{
    "id": "39fc339cf058bd22176771b3e3187329", # unique id (added by backend)
    "annotator_schema_version": "v1.0", # schema version: default v1.0
    "created": "2011-05-24T18:52:08.036814", # created datetime in iso8601 format (added by backend)
    "updated": "2011-05-26T12:17:05.012544", # updated datetime in iso8601 format (added by backend)
    "text": "A note I wrote", # content of annotation
    "quote": "the text that was annotated", # the annotated text (added by frontend)
    "uri": "http://example.com", # URI of annotated document (added by frontend)
    "ranges": [ # list of ranges covered by annotation (usually only one entry)
        {
        "start": "/p[69]/span/span", # (relative) XPath to start element
        "end": "/p[70]/span/span", # (relative) XPath to end element
        "startOffset": 0, # character offset within start element
        "endOffset": 120 # character offset within end element
        }
    ],
    "user": "alice", # user id of annotation owner (can also be an object with an 'id' property)
    "consumer": "annotateit", # consumer key of backend
    "tags": [ "review", "error" ], # list of tags (from Tags plugin)
    "permissions": { # annotation permissions (from Permissions/AnnotateItPermissions plugin)
        "read": ["group:__world__"],
        "admin": [],
        "update": [],
        "delete": []
    }
}
```