package dao

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import java.io.File

class LogDaoTest extends FunSuite with ShouldMatchers {

    implicit val pathToLog: String = "test/resources"
    
    test( "should list all files in directory" ) {
        val logDao = new LogDao()
        val fileList: List[String] = logDao.list

        fileList should have size 1
        fileList.foreach( fileName => fileName should be ("karaf.log.test") )
    }
}