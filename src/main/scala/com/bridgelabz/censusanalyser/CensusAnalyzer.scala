package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue

/**
 * Created on 11/20/2020.
 * Class: CensusAnalyzer.scala
 * Author: Rajat G.L.
 */
class CensusAnalyzer {
  def loadCSVInfo(filePath: String): Int = {
    try {
      if(!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(Issue.INCORRECT_FILE)
      }
      val FileReader = io.Source.fromFile(filePath)
      var rowsCounted = 0
      for(line <- FileReader.getLines()) {
        val cols = line.split(",").map(_.trim)
        if(cols.length != 4) {
          throw new CensusAnalyzerException(Issue.INVALID_DELIMITER)
        }
        if(rowsCounted == 0){
          if(cols(0).toLowerCase != "state" || cols(1).toLowerCase != "population" ||
            cols(2).toLowerCase != "areainsqkm" || cols(3).toLowerCase != "densitypersqkm" ) {
            throw new CensusAnalyzerException(Issue.INVALID_FIELDS)
          }
        }
        rowsCounted += 1
      }
      FileReader.close()
      rowsCounted - 1
    }
    catch {
      case _:java.io.FileNotFoundException =>
        throw new CensusAnalyzerException(Issue.PATH_INCORRECT)
    }
  }
}
