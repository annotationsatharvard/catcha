package org.mindinformatics.ann.framework.module.converter

import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mindinformatics.ann.framework.module.converter.AnnotationConverter;
import org.mindinformatics.ann.framework.module.persistence.Annotation

import java.text.SimpleDateFormat

import static org.junit.Assert.assertEquals
import static org.junit.Assert.fail

/**
 *
 */
class ConversionServiceTests {

    def conversionService

    @Before
    void setUp() {
        // Setup logic here
    }

    @After
    void tearDown() {
        // Tear down logic here
    }

    @Test
    void converter_shouldReturnAnnotationClone() {
        def annotation = new Annotation(id: 1, uri: "this-uri", json: "{'id':1, 'uri':'this-uri'}")
        def converter = new AnnotationConverter()
        def annotationConverted = converter.convert(annotation)
        assertEquals annotation.id, annotationConverted.id
    }

    @Test
    void conversionService_shouldReturnAnnotationClone() {
        def annotation = new Annotation(id: 1, uri: "this-uri", json: "{'id':1, 'uri':'this-uri'}")
        def converter = new AnnotationConverter()
        def annotationConverted = conversionService.convert(annotation, Annotation.class)
        assertEquals annotationConverted.id, annotation.id
    }

}
