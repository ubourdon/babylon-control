package controllers

import play.api.mvc._
import services.LogParser
import log.pattern.LogPattern
import models.{LogBuilder, Log}

object Application extends Controller {

    def index = Action {
        val parser = new LogParser( "public/karaf.log" )

        val log: Log = new LogBuilder()
            .withEntireContent( parser.prettyAll )
            .withDate( parser.retrieveValueFromPattern( LogPattern.DATE ).getOrElse( "none" ) )
            .withDuration( parser.retrieveValueFromPattern( LogPattern.BATCH_DURATION ).getOrElse( "none" ) )
            .withRetrieve( parser.retrieveValueFromPattern( LogPattern.RETRIEVE_EVENTS ).getOrElse( "none" ) )
            .withCallback( parser.retrieveValueFromPattern( LogPattern.CALLBACK_EVENTS ).getOrElse( "none" ) )
            .withAccountUploaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_UPLOAD ).getOrElse( "none" ) )
            .withContactUploaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_UPLOAD ).getOrElse( "none" ) )
            .withOpportunityUploaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_UPLOAD ).getOrElse( "none" ) )
            .withAccountDownloaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_DOWNLOAD ).getOrElse( "none" ) )
            .withContactDownloaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_DOWNLOAD ).getOrElse( "none" ) )
            .withOpportunityDownloaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_DOWNLOAD ).getOrElse( "none" ) )
            .toLog

        Ok( views.html.loaderEvents( "batch loader du 25 mai 2012", log ) )
    }
}