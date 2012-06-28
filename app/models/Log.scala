package models

import play.api.templates.Html

case class Log( entireContent: Html,
                prettyContent: Html, 
                date: String,
                duration: String,
                retrieve: Int,
                callback: Int,
                accountUploaded: Int,
                contactUploaded: Int,
                opportunityUploaded: Int,
                accountDownloaded: Int,
                contactDownloaded: Int,
                opportunityDownloaded: Int,
                negoAccountUploaded: Int,
                negoContactUploaded: Int,
                negoAccountDownloaded: Int,
                negoContactDownloaded: Int
)

class LogBuilder {

    var entireContent: Html = _
    var prettyContent: Html = _
    var date: String = _
    var duration: String = _
    var retrieve: Int = _
    var callback: Int = _
    var accountUploaded: Int = _
    var contactUploaded: Int = _
    var opportunityUploaded: Int = _
    var accountDownloaded: Int = _
    var contactDownloaded: Int = _
    var opportunityDownloaded: Int = _
    var negoAccountUploaded: Int = _
    var negoContactUploaded: Int = _
    var negoAccountDownloaded: Int = _
    var negoContactDownloaded: Int = _

    def toLog: Log = Log( entireContent, prettyContent,
                          date, duration, retrieve, callback,
                          accountUploaded, contactUploaded, opportunityUploaded,
                          accountDownloaded, contactDownloaded, opportunityDownloaded,
                          negoAccountUploaded, negoContactUploaded, negoAccountDownloaded, negoContactDownloaded
    )
    
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

    def withRetrieve( retrieve: Int ): LogBuilder = {
        this.retrieve = retrieve
        this
    }

    def withCallback( callback: Int ): LogBuilder = {
        this.callback = callback
        this
    }

    def withAccountUploaded( accountUploaded: Int ): LogBuilder = {
        this.accountUploaded = accountUploaded
        this
    }

    def withContactUploaded( contactUploaded: Int ): LogBuilder = {
        this.contactUploaded = contactUploaded
        this
    }

    def withOpportunityUploaded( opportunityUploaded: Int ): LogBuilder = {
        this.opportunityUploaded = opportunityUploaded
        this
    }

    def withAccountDownloaded( accountDownloaded: Int ): LogBuilder = {
        this.accountDownloaded = accountDownloaded
        this
    }

    def withContactDownloaded( contactDownloaded: Int ): LogBuilder = {
        this.contactDownloaded = contactDownloaded
        this
    }

    def withOpportunityDownloaded( opportunityDownloaded: Int ): LogBuilder = {
        this.opportunityDownloaded = opportunityDownloaded
        this
    }


    def withNegoAccountUploaded( accountUploaded: Int ): LogBuilder = {
        this.negoAccountUploaded = accountUploaded
        this
    }

    def withNegoContactUploaded( contactUploaded: Int ): LogBuilder = {
        this.negoContactUploaded = contactUploaded
        this
    }

    def withNegoAccountDownloaded( accountDownloaded: Int ): LogBuilder = {
        this.negoAccountDownloaded = accountDownloaded
        this
    }

    def withNegoContactDownloaded( contactDownloaded: Int ): LogBuilder = {
        this.negoContactDownloaded = contactDownloaded
        this
    }
}