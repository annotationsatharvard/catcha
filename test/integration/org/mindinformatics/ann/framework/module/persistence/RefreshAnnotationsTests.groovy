package org.mindinformatics.ann.framework.module.persistence

import grails.converters.JSON
import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

import javax.script.ScriptEngine
import javax.script.ScriptEngineManager

//@TestFor(AnnotatorService)
//@Mock([Annotation,Tag])
class RefreshAnnotationsTests extends GroovyTestCase {

    def annotatorService

    @Before
    void setUp() {

    }

    @After
    void tearDown() {
        // Tear down logic here
    }


    @Test
    void testRefreshAnnotations() {
        annotatorService.refreshAnnotations([max:1000])
        annotatorService.refreshAnnotations([max:2000])
        annotatorService.refreshAnnotations([max:5000])
        annotatorService.refreshAnnotations([max:10000])
        annotatorService.refreshAnnotations([max:30000])
    }


    @Ignore
    void testSomething() {
        println "Testing something"

        /*
        def annotations = Annotation.list()
        assert annotations != null
        assert annotations.size() == 1
        annotations.each {
            println new URL(it.uri).getText()
        }
        */

//        def localPath = "edx.html"
//        def remoteUrl = "https://courses.edx.org/courses/HarvardX/AI12.2x/2013_SOND/courseware/fe939c73594e454da10d734884e54db2/016f704dd546408998ab2c2545878d89/"
//        def user = "jcm62%40columbia.edu"
//        def passwd = "password"
//        new File(localPath).withOutputStream { out ->
//            def url = new URL(remoteUrl).openConnection()
//            def remoteAuth = "Basic " + "${user}:${passwd}".getBytes().encodeBase64().toString()
//            url.setRequestProperty("Authorization", remoteAuth);
//            out << url.getInputStream()
//        }

        def remoteUrl       = "https://courses.edx.org/courses/HarvardX/AI12.2x/2013_SOND/courseware/fe939c73594e454da10d734884e54db2/016f704dd546408998ab2c2545878d89/"
        remoteUrl += ";sessionid=9acd66a84226f27f0c8ec4aee026e836"
        //def authString = "jcm62%40columbia.edu:password".getBytes().encodeBase64().toString()

        def conn = remoteUrl.toURL().openConnection()
        //conn.setRequestProperty( "Authorization", "Basic ${authString}" )
        if( conn.responseCode == 200 ) {
            def feed = conn.content.text
            println feed
            // Work with the xml document

        } else {
            println "Something bad happened."
            println "${conn.responseCode}: ${conn.responseMessage}"
        }

    }


    @Ignore
    void testMe() {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        println "hello world (" + engine.toString() + ")";

    }

    @Ignore
    void testSomethingElse() {
        def annotations = Annotation.list([max: 10, sort: "dateCreated", order: "desc"])
        println annotations.size()

        def dir = '/home/jmiranda/Desktop/poetry/:2'
        def map = [1:[],2:[],3:[]]
        def list = []
        new File(dir).eachFileRecurse{ list<< it }
        list.each {
            if (it.isFile()) {
                println "* " + it.absolutePath
                def index = (it.absolutePath - dir).substring(2,3)
                println " >> " + index
                try {
                    String content = new File(it.absolutePath).text
                    if (content) {
                        def rootNode = new XmlSlurper().parseText(content)
                        println rootNode

                        def fileList = map[index]
                        if (!fileList) {
                            fileList = []
                        }
                        fileList << content
                        map[index] = fileList
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace()
                } catch (Exception e) {
                    e.printStackTrace()
                }
            }
        }
        def found = [:]
        annotations.each { annotation ->
            //"ranges":[{"endOffset":60,"start":"/annotatable[1]/p[8]/font[1]","end":"/annotatable[1]/p[9]/font[1]","startOffset":0}]
            //println annotation.json
            def jsonObject = JSON.parse(annotation.json)
            def start = jsonObject.ranges.start
            def end = jsonObject.ranges.end
            def startOffset = jsonObject.ranges.startOffset
            def endOffset = jsonObject.ranges.endOffset

            println "Ranges:" + start + ":" + end + ":" + endOffset + ":" + startOffset

            //println "annotation: " + annotation.id + " " + annotation.uri
            map.each {k,v->
                //println "key " + k
                v.each { contents ->
                    //println "v: " + contents.size()
                    if (annotation.quote) {
                        //println "check for quote " + annotation.quote
                        if (contents.indexOf(annotation.quote)) {
                            //println "Found one! " + k + " " + k.class
                            if (!found[k]) {
                                found[k] = 0
                            }
                            found[k]++
                        }
                    }

                }

            }
        }
        println found


    }

}
