package controllers

import play.api.mvc._
import log.pattern.LogPattern
import models.{LogBuilder, Log}
import dao.LogDao
import services.ParseOption._
import services.LogParser

object Application extends Controller {

    implicit val pathToLog: String = "public/logs"

    val logDao: LogDao = new LogDao()
    
    def index = Action {
        Ok( views.html.index( "babylon-control!" ) )
    }

    def logEvents( fileName: String ) = Action {
        val parser = new LogParser( fileName )

        val log: Log = new LogBuilder()       // TODO LogPattern => Enum
            .withEntireContent( parser.all )
            .withPrettyContent( parser.prettyAll )

            .withDate( parser.retrieveValueFromPattern( LogPattern.DATE ).getOrElse( "none" ) )
            .withDuration( parser.retrieveValueFromPattern( LogPattern.BATCH_DURATION ).getOrElse( "none" ) )
            .withRetrieve( parser.retrieveValueFromPattern( LogPattern.RETRIEVE_EVENTS )    .getOrElse( "0" ).toInt )
            .withCallback( parser.retrieveValueFromPattern( LogPattern.CALLBACK_EVENTS ).getOrElse( "0" ).toInt )

            .withAccountUploaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_UPLOAD, ADVERTISER ).getOrElse( "0" ).toInt )
            .withContactUploaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_UPLOAD, ADVERTISER ).getOrElse( "0" ).toInt )
            .withOpportunityUploaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_UPLOAD, ADVERTISER ).getOrElse( "0" ).toInt )

            .withAccountDownloaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_DOWNLOAD, ADVERTISER ).getOrElse( "0" ).toInt )
            .withContactDownloaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_DOWNLOAD, ADVERTISER ).getOrElse( "0" ).toInt )
            .withOpportunityDownloaded( parser.retrieveValueFromPattern( LogPattern.OPPORTUNITY_DOWNLOAD, ADVERTISER ).getOrElse( "0" ).toInt )

            .withNegoAccountUploaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_UPLOAD ).getOrElse( "0" ).toInt )
            .withNegoContactUploaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_UPLOAD ).getOrElse( "0" ).toInt )
            .withNegoAccountDownloaded( parser.retrieveValueFromPattern( LogPattern.ACCOUNT_DOWNLOAD ).getOrElse( "0" ).toInt )
            .withNegoContactDownloaded( parser.retrieveValueFromPattern( LogPattern.CONTACT_DOWNLOAD ).getOrElse( "0" ).toInt )

            .toLog

        Ok( views.html.loaderEvents( "batch loader" + fileName, log ) )
    }
    
    def listLogFile = Action {
        Ok( logDao.list.mkString("#") )
    }
}
