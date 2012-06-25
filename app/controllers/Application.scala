package controllers

import play.api.mvc._
import services.LogParser
import log.pattern.LogPattern
import models.{LogBuilder, Log}
import dao.LogDao

object Application extends Controller {

    implicit val pathToLog: String = "public/logs"

    val logDao: LogDao = new LogDao()
    
    def index = Action {
        Ok( views.html.index( "babylon-control!" ) )
    }

    def logEvents( fileName: String ) = Action {
        val parser = new LogParser( fileName )

        val log: Log = new LogBuilder()
            .withEntireContent( parser.all )
            .withPrettyContent( parser.prettyAll )

            .withDate( parser.retrieveValueFromPattern( LogPattern.DATE ).getOrElse( "none" ) )
            .withDuration( parser.retrieveValueFromPattern( LogPattern.BATCH_DURATION ).getOrElse( "none" ) )
            .withRetrieve( parser.retrieveValueFromPattern( LogPattern.RETRIEVE_EVENTS ).getOrElse( "none" ).toInt )
            .withCallback( parser.retrieveValueFromPattern( LogPattern.CALLBACK_EVENTS ).getOrElse( "none" ).toInt )

            .withAccountUploaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_UPLOAD ).getOrElse( "none" ).toInt )
            .withContactUploaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_UPLOAD ).getOrElse( "none" ).toInt )
            .withOpportunityUploaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_UPLOAD ).getOrElse( "none" ).toInt )

            .withAccountDownloaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_DOWNLOAD ).getOrElse( "none" ).toInt )
            .withContactDownloaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_DOWNLOAD ).getOrElse( "none" ).toInt )
            .withOpportunityDownloaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_DOWNLOAD ).getOrElse( "none" ).toInt )
            .toLog

        Ok( views.html.loaderEvents( "batch loader" + fileName, log ) )
    }
    
    def listLogFile = Action {
        Ok( logDao.list.mkString("#") )
    }
}
