package controllers

import play.api.mvc._
import models.Log
import services.LogParser
import log.pattern.LogPattern

object Application extends Controller {

    def index = Action {
        val parser = new LogParser( "public/karaf.log" )

        val log: Log = Log( parser.all,
                            parser.retrieveValueFromPattern( LogPattern.DATE ).getOrElse( "none" ),
                            parser.retrieveValueFromPattern( LogPattern.BATCH_DURATION ).getOrElse( "none" ),
                            parser.retrieveValueFromPattern( LogPattern.CALLBACK_EVENTS ).getOrElse( "None" )
        )

        Ok( views.html.loaderEvents( "batch loader du 25 mai 2012", log ) )
    }
}