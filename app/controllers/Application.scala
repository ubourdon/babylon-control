package controllers

import play.api.mvc._
import models.Log
import services.LogParser
import log.pattern.LogPattern

object Application extends Controller {

    def index = Action {
        val parser = new LogParser( "public/karaf.log.test" )

        val log: Log = Log( parser.retrieveValueFromPattern( LogPattern.DATE ),
                            parser.retrieveValueFromPattern( LogPattern.BATCH_DURATION )
        )

        Ok( views.html.loaderEvents( "batch loader du 25 mai 2012", log ) )
    }
}