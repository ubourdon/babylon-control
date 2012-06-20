package services

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class LogParserTest extends FunSuite with ShouldMatchers {

    test( "should retrieve duration value in log file" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.retrieveValueFromPattern( "[duree=" ) should be ( "250" )
    }
}