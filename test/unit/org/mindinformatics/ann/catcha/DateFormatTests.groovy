package org.mindinformatics.ann.catcha

import org.joda.time.format.DateTimeFormatter
import org.joda.time.format.ISODateTimeFormat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mindinformatics.ann.framework.module.converter.AnnotationConverter
import org.mindinformatics.ann.framework.module.persistence.Annotation

import java.text.SimpleDateFormat

import static org.junit.Assert.assertEquals

/**
 *
 */
class DateFormatTests {

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
    void testJavaDateFormat() {
        def stringDate = "2013-08-23T02:24:15.427+00:00"
        def isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S")
        def javaDate = isoFormat.parse(stringDate)
        println javaDate;

    }

    @Test
    void testJodaDateFormat() {
        def stringDate = "2013-08-23T02:24:15.427+00:00"
        DateTimeFormatter fmt = ISODateTimeFormat.dateTime().withOffsetParsed();
        def jodaDate = fmt.parseDateTime(stringDate)
        println jodaDate


    }

}
