package models

import play.api.templates.Html

case class Log( entireContent: Html,
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