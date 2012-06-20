package models

import play.api.templates.Html

case class Log( entireContent: Html, date: String, duration: String, callback: String )