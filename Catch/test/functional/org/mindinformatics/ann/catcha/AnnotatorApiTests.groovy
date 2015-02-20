package org.mindinformatics.ann.catcha

//import com.grailsrocks.functionaltest.APITestCase
//import com.grailsrocks.functionaltest.BrowserTestCase
import functionaltestplugin.FunctionalTestCase
import grails.converters.JSON

class AnnotatorApiTests extends FunctionalTestCase {

    def validToken = 'eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIiwidHlwIjoiSldTIn0.eyJjb25zdW1lcktleSI6IjBjYmZhMzcwLWI3M2MtNGUzYS1hZTQ2LTU4MmRmMjg0YjdjMyIsImlzc3VlZEF0IjoiMjAxNC0wOC0yOFQwMzoyNToyOC0wNDAwIiwidXNlcklkIjoiam1pcmFuZGEiLCJqdGkiOiI5ZWVkNjdhZC04ZmExLTRiYTItOWExOS1jOGY3YTBhZDUzNTAiLCJ0dGwiOjg2NDAwLCJpYXQiOjE0MDkyNTM5Mjh9.LOoRN_xJeV4QEL22puG3eA65wX5qsTHmb_a7RKnmJEA'

    void testGenerateToken() {
        get('/annotator/token') {
            headers['x-annotator-auth-token'] = validToken
            //headers['Content-Type'] = 'application/json'
        }
        assertStatus 200
        println "RESPONSE: " + page
        //assertContentType("application/json")
        //def json = JSON.parse(page.inputStream.text)
        //println "RESPONSE: " + json
        //assert json.data.connection != null
        //assert json.data.connection.id == 2
    }

    void testCreateAnnotation() {
        post('/annotator/create') {
            headers['x-annotator-auth-token'] = validToken
            headers['Content-Type'] = 'application/json'
            body {
                """
                   {"tags":["longs"],"citation":"Wu, Jingzi, 1701-1754. The Scholars. [Translated by Yang Hsien-yi and Gladys Yang. Author's port. and illus. by Cheng Shih-fa] Peking, Foreign Languages Press, 1957. Pages 49-51","text":"","created":"2014-06-29T07:25:07.498Z","updated":"2014-06-29T07:25:07.498Z","quote":"Xia","ranges":[{"endOffset":346,"start":"/textannotation[1]/p[10]","end":"/textannotation[1]/p[10]","startOffset":343}],"permissions":{"update":["micazorla@yahoo.es"],"admin":["micazorla@yahoo.es"],"delete":["micazorla@yahoo.es"],"read":[]},"parent":"0","uri":"https://courses.edx.org/courses/HarvardX/SW12.6x/2T2014/courseware/f9ec9c0c7bb8498d814684358b6e8b0f/0134825cf0f34fd68516ff4018d3ead4/1","media":"text","user":{"id":"micazorla@yahoo.es","name":"Mila1969"}}
                """
            }
        }
    }


    void testReadAnnotation() {
        get('/annotator/read/1') {
            headers['x-annotator-auth-token'] = validToken
            headers['Content-Type'] = 'application/json'
        }
        assertStatus 200
        assertContentType("application/json")
        def json = JSON.parse(page.inputStream.text)
        println "RESPONSE: " + json
        //assert json.data.connection != null
        //assert json.data.connection.id == 2
    }

    void testUpdateAnnotation() {
        post('/annotator/update/1') {
            headers['x-annotator-auth-token'] = validToken
            headers['Content-Type'] = 'application/json'
            body {
                """
                   {"id":1, "tags":["longs"],"citation":"Wu, Jingzi, 1701-1754. The Scholars. [Translated by Yang Hsien-yi and Gladys Yang. Author's port. and illus. by Cheng Shih-fa] Peking, Foreign Languages Press, 1957. Pages 49-51","text":"","created":"2014-06-29T07:25:07.498Z","updated":"2014-06-29T07:25:07.498Z","quote":"Xia","ranges":[{"endOffset":346,"start":"/textannotation[1]/p[10]","end":"/textannotation[1]/p[10]","startOffset":343}],"permissions":{"update":["micazorla@yahoo.es"],"admin":["micazorla@yahoo.es"],"delete":["micazorla@yahoo.es"],"read":[]},"parent":"0","uri":"https://courses.edx.org/courses/HarvardX/SW12.6x/2T2014/courseware/f9ec9c0c7bb8498d814684358b6e8b0f/0134825cf0f34fd68516ff4018d3ead4/1","media":"text","user":{"id":"micazorla@yahoo.es","name":"Mila1969"}}
                """
            }
        }
    }

    void testUpdateAnnotationWithoutId() {
        post('/annotator/update/1') {
            headers['x-annotator-auth-token'] = validToken
            headers['Content-Type'] = 'application/json'
            body {
                """
                   {"tags":["longs"],"citation":"Wu, Jingzi, 1701-1754. The Scholars. [Translated by Yang Hsien-yi and Gladys Yang. Author's port. and illus. by Cheng Shih-fa] Peking, Foreign Languages Press, 1957. Pages 49-51","text":"","created":"2014-06-29T07:25:07.498Z","updated":"2014-06-29T07:25:07.498Z","quote":"Xia","ranges":[{"endOffset":346,"start":"/textannotation[1]/p[10]","end":"/textannotation[1]/p[10]","startOffset":343}],"permissions":{"update":["micazorla@yahoo.es"],"admin":["micazorla@yahoo.es"],"delete":["micazorla@yahoo.es"],"read":[]},"parent":"0","uri":"https://courses.edx.org/courses/HarvardX/SW12.6x/2T2014/courseware/f9ec9c0c7bb8498d814684358b6e8b0f/0134825cf0f34fd68516ff4018d3ead4/1","media":"text","user":{"id":"micazorla@yahoo.es","name":"Mila1969"}}
                """
            }
        }
    }


}
