package services

import io.Source

class LogParser( filePath: String ) {

    private val END_PATTERN = "]"
    private val VALUE_SEPARATOR = "="
    
    private val fileContent: String = Source.fromFile( filePath ).mkString
    
    def retrieveValueFromPattern( pattern: String ): String = {
        val startIndex: Int = fileContent.indexOf( pattern )
        fileContent.substring( startIndex, fileContent.indexOf( END_PATTERN, startIndex ) ).split( VALUE_SEPARATOR )(1)
    }
}