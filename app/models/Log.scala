package models

import play.api.templates.Html

case class Log( entireContent: Html,
                prettyContent: Html, 
                date: String,
                duration: String,
                retrieve: String,
                callback: String,
                accountUploaded: String,
                contactUploaded: String, 
                opportunityUploaded: String, 
                accountDownloaded: String,
                contactDownloaded: String,
                opportunityDownloaded: String
)

class LogBuilder {

    var entireContent: Html = _
    var prettyContent: Html = _
    var date: String = _
    var duration: String = _
    var retrieve: String = _
    var callback: String = _
    var accountUploaded: String = _
    var contactUploaded: String = _
    var opportunityUploaded: String = _
    var accountDownloaded: String = _
    var contactDownloaded: String = _
    var opportunityDownloaded: String = _

    def toLog: Log = Log( entireContent, prettyContent, date, duration, retrieve, callback, accountUploaded, contactUploaded, opportunityUploaded, accountDownloaded, contactDownloaded, opportunityDownloaded )
    
    def withEntireContent( entireContent: Html ): LogBuilder = {
        this.entireContent = entireContent
        this
    }

    def withPrettyContent( prettyContent: Html ): LogBuilder = {
        this.prettyContent = prettyContent
        this
    }
    
    def withDate( date: String ): LogBuilder = {
        this.date = date
        this
    }

    def withDuration( duration: String ): LogBuilder = {
        this.duration = duration
        this
    }

    def withRetrieve( retrieve: String ): LogBuilder = {
        this.retrieve = retrieve
        this
    }

    def withCallback( callback: String ): LogBuilder = {
        this.callback = callback
        this
    }

    def withAccountUploaded( accountUploaded: String ): LogBuilder = {
        this.accountUploaded = accountUploaded
        this
    }

    def withContactUploaded( contactUploaded: String ): LogBuilder = {
        this.contactUploaded = contactUploaded
        this
    }

    def withOpportunityUploaded( opportunityUploaded: String ): LogBuilder = {
        this.opportunityUploaded = opportunityUploaded
        this
    }

    def withAccountDownloaded( accountDownloaded: String ): LogBuilder = {
        this.accountDownloaded = accountDownloaded
        this
    }

    def withContactDownloaded( contactDownloaded: String ): LogBuilder = {
        this.contactDownloaded = contactDownloaded
        this
    }

    def withOpportunityDownloaded( opportunityDownloaded: String ): LogBuilder = {
        this.opportunityDownloaded = opportunityDownloaded
        this
    }
}