package dao

import java.io.File

class LogDao( implicit pathToLog: String ) {
    def list: List[String] = new File( pathToLog ).list().toList
}