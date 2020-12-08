package com.bridgelabz.censusanalyser

import java.nio.file.{Files, Paths}
import java.util

import com.bridgelabz.censusanalyser.CSVBuilderFactory.createCSVBuilder
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue

import scala.io.Source

/**
 * Created on 11/30/2020.
 * Class: CensusAnalyzer.scala
 * Author: Rajat G.L.
 */
object CensusLoader {
  @throws[CensusAnalyzerException]
  @Deprecated
  def loadCSVData(filePath: String, headers: Array[String]): util.ArrayList[util.ArrayList[String]] = {
    try {
      val table = new util.ArrayList[util.ArrayList[String]]()
      if (!filePath.endsWith(".csv")) {
        throw new CensusAnalyzerException(Issue.INCORRECT_FILE)
      }
      val FileReader = Source.fromFile(filePath)
      var rowsCounted = 0
      for (line <- FileReader.getLines()) {
        val column = line.split(",").map(_.trim)
        if (column.length != headers.length) {
          throw new CensusAnalyzerException(Issue.INVALID_DELIMITER)
        }
        if (rowsCounted == 0) {
          for (headerIndex <- headers.indices)
            if (column(headerIndex).toLowerCase != headers(headerIndex)) {
              throw new CensusAnalyzerException(Issue.INVALID_FIELDS)
            }
        }
        val colsArray: util.ArrayList[String] = new util.ArrayList()
        for(stringAdd <- column){
          colsArray.add(stringAdd)
        }
        table.add(colsArray)
        rowsCounted += 1
      }
      FileReader.close()
      table
    }
    catch {
      case _: java.io.FileNotFoundException =>
        throw new CensusAnalyzerException(Issue.PATH_INCORRECT)
      case e =>throw e
    }
  }
}
