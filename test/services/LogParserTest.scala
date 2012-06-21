package services

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import io.{Codec, Source}

class LogParserTest extends FunSuite with ShouldMatchers {

    test( "parser should retrieve duration value in log file" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.retrieveValueFromPattern( "[duree=" ).get should be ( "250" )
    }

    test( "parser should retrieve entire text in log file" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.all.toString() should be ( "blabla | INFO | bloulou | toto | titi | [duree=250]<br/>" )
    }
    
    test( "paserser should retrieve entire text in log in a pretty display mode" ) {
        val parser = new LogParser( "test/karaf.log.test" )
        parser.prettyAll.toString() should be ( " INFO | [duree=250]<br/>" )
    }
}