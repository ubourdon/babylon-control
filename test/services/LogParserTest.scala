package services

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import io.{Codec, Source}

class LogParserTest extends FunSuite with ShouldMatchers {

    implicit val basePath: String = "test/resources/"
    val parser = new LogParser( "karaf.log.test" )

    test( "parser should retrieve duration value in log file" ) {
        parser.retrieveValueFromPattern( "[duree=" ).get should be ( "250" )
    }

    test( "parser should retrieve entire text in log file" ) {
        parser.all.toString() should be ( "blabla | INFO | bloulou | toto | titi | [duree=250]<br/>" )
    }
    
    test( "paserser should retrieve entire text in log in a pretty display mode" ) {
        parser.prettyAll.toString() should be ( " INFO | [duree=250]<br/>" )
    }
}