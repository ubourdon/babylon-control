package services

import play.api.templates.{Html, HtmlFormat}
import io.{Codec, Source}


class LogParser( filePath: String ) {

    private val END_PATTERN = "]"
    private val VALUE_SEPARATOR = "="
    
    private val fileContent = Source.fromFile( filePath ).mkString

    def retrieveValueFromPattern( pattern: String ): Option[String] = {
        val startIndex: Int = fileContent.indexOf( pattern )

        if( startIndex >= 0 ) {
            Some( fileContent
                .substring( startIndex, fileContent.indexOf( END_PATTERN, startIndex ) )
                .split( VALUE_SEPARATOR )(1)
            )
        } else None
    }

    def all: Html = {
        val source = Source.fromFile( filePath )( Codec.UTF8 )
        val buffer = new StringBuffer()

        source.getLines().foreach( line => buffer.append( line ).append( "<br/>" ) )

        source.close()

        HtmlFormat.raw( buffer.toString )
    }
}