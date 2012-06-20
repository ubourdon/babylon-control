package services

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import io.Source
import play.api.templates.HtmlFormat

class LogParserTest extends FunSuite with ShouldMatchers {

    test( "parser should retrieve duration value in log file" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.retrieveValueFromPattern( "[duree=" ).get should be ( "250" )
    }

    test( "parser should retrieve entire text in log file" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.all.toString() should be ( "[duree=250]<br/>" )
    }
}