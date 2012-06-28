package services

import play.api.templates.{Html, HtmlFormat}
import io.{Codec, Source}
import ParseOption._


class LogParser( fileName: String )( implicit basePath: String ) {

    private val END_PATTERN = "]"
    private val VALUE_SEPARATOR = "="
    
    private val fileContent = Source.fromFile( basePath + "/" + fileName ).mkString

    def retrieveValueFromPattern( pattern: String, parseOption: ParseOption = NONE ): Option[String] = {

        val firstIndex: Int = if( parseOption == ADVERTISER ) fileContent.indexOf( pattern ) else 0
        val startIndex: Int = fileContent.indexOf( pattern, firstIndex + 1 )

        if( startIndex >= 0 ) {
            Some( fileContent
                .substring( startIndex, fileContent.indexOf( END_PATTERN, startIndex ) )
                .split( VALUE_SEPARATOR )(1)
            )
        } else None
    }

    def all: Html = {
        val source = Source.fromFile( basePath + "/" + fileName )( Codec.UTF8 )
        val buffer = new StringBuffer()

        source.getLines().foreach ( line => buffer.append( line ).append( "<br/>" ) )

        source.close()

        HtmlFormat.raw( buffer.toString )
    }

    def prettyAll: Html = {
        val separator = "=============================="
        val separator2 = "_____________________________"

        val source = Source.fromFile( basePath + "/" + fileName )( Codec.UTF8 )

        var target = "nego"

        val prettyLog = source.getLines().map (
            line => {
                var pLine = line
                val split = line.split( "\\|" )

                pLine = if( split.length == 6 ) new StringBuilder().append( split( 1 ) ).append( "|" ).append( split( 5 ) ).toString else pLine
                pLine = if( split.length == 5 ) new StringBuilder().toString else pLine

                pLine = if( pLine.contains( separator ) || pLine.contains( "starting loading" )  ) {
                    new StringBuilder()
                        .append( "<span style=\"color: blue;font-weight: bold;\">" )
                        .append( pLine )
                        .append( "</span>" ).toString
                } else pLine

                pLine = if( !pLine.contains( "INFO" ) && !pLine.contains( "WARN" ) && !pLine.contains( separator2 ) && !pLine.contains( "ext_id" ) ) {
                    new StringBuilder()
                        .append( "<span style=\"color: red;\">" )
                        .append( pLine )
                        .append( "</span>" ).toString
                } else pLine
                
                pLine = if( pLine.contains( "LANCEMENT DU BATCH" ) || pLine.contains( "FIN DU BATCH" ) || ( pLine.contains( "INFO" ) && pLine.contains( "========" ) ) ) {
                    new StringBuilder()
                        .append( "<span style=\"color: green;font-weight: bold;\">" )
                        .append( pLine.split( "\\|" )( 1 ) )
                        .append( "</span>" ).toString
                } else pLine

                pLine = if( pLine.contains( "ext_id" ) ) {
                    new StringBuilder()
                        .append( "<span style=\"color: yellow;font-weight: bold;\">" )
                        .append( pLine )
                        .append( "</span>" ).toString
                } else pLine

                pLine = if( pLine.contains( "starting loading Account" ) && target.equals( "advertiser" ) ) {
                    new StringBuilder()
                        .append( "<a name=\"startAccount\">" )
                        .append( pLine )
                        .append( "</a>" ).toString
                } else pLine

                pLine = if( pLine.contains( "starting loading Contact" ) && target.equals( "advertiser" ) ) {
                    new StringBuilder()
                        .append( "<a name=\"startContact\">" )
                        .append( pLine )
                        .append( "</a>" ).toString
                } else pLine

                pLine = if( pLine.contains( "starting loading Opportunity" ) && target.equals( "advertiser" ) ) {
                    new StringBuilder()
                        .append( "<a name=\"startOpportunity\">" )
                        .append( pLine )
                        .append( "</a>" ).toString
                } else pLine

                if( pLine.contains( "starting loading Opportunity" ) ) target = "advertiser"
                
                pLine = if( pLine.contains( "negociator" ) || pLine.contains( "advertiser" ) ) {
                    new StringBuilder()
                        .append( "<span style=\"color: orange;font-weight: bold;\">" )
                        .append( pLine )
                        .append( "</span>" ).toString
                } else pLine
                
                pLine = new StringBuilder().append( pLine ).append( "<br/>" ).toString

                pLine
            }
        ).mkString
        
        source.close()

        HtmlFormat.raw( prettyLog )
    }
}