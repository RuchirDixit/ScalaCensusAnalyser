package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue

import scala.io.Source

/**
 * Created on 11/30/2020.
 * Class: CensusAnalyzer.scala
 * Author: Rajat G.L.
 */
class CensusAnalyzer {
  def loadIndiaStateCensusData(filePath: String): Int = {
    try {
      if (!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(Issue.INCORRECT_FILE)
      }
      val FileReader = Source.fromFile(filePath)
      var rowsCounted = 0
      for (line <- FileReader.getLines()) {
        val column = line.split(",").map(_.trim)
        if (column.length != 4) {
          throw new CensusAnalyzerException(Issue.INVALID_DELIMITER)
        }
        if (rowsCounted == 0) {
          if (column(0).toLowerCase != "state" || column(1).toLowerCase != "population" ||
            column(2).toLowerCase != "areainsqkm" || column(3).toLowerCase != "densitypersqkm") {
            throw new CensusAnalyzerException(Issue.INVALID_FIELDS)
          }
        }
        rowsCounted += 1
      }
      FileReader.close()
      rowsCounted - 1
    }
    catch {
      case _: java.io.FileNotFoundException =>
        throw new CensusAnalyzerException(Issue.PATH_INCORRECT)
    }
  }

  def loadIndiaStateCodeData(filePath: String): Int = {
    try {
      if (!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(Issue.INCORRECT_FILE)
      }
      val fileReader = Source.fromFile(filePath)
      var rowCount = 0
      for (line <- fileReader.getLines()) {
        val columns = line.split(",").map(_.trim)

        if (columns.length != 4) {
          throw new CensusAnalyzerException(Issue.INVALID_DELIMITER)
        }
        if (rowCount == 0) {
          if (columns(1) != "State Name" || columns(2) != "TIN" || columns(3) != "StateCode") {
            throw new CensusAnalyzerException(Issue.INVALID_FIELDS)
          }
        }
        rowCount += 1
      }
      rowCount - 1
    }
    catch {
      case _: java.io.FileNotFoundException =>
        throw new CensusAnalyzerException(Issue.PATH_INCORRECT)
    }
  }

}
