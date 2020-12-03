package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.IndiaStateCensusDataAnalyser.loadIndiaStateCensusData
import com.bridgelabz.censusanalyser.IndiaStateCodeAnalyser.loadIndiaStateCode
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException

/**
 * Created on 11/30/2020.
 * Class: CSVDriver.scala
 * Author: Rajat G.L.
 */
object CSVDriver {
  def main(args: Array[String]): Unit = {
    try {
      loadIndiaStateCensusData()
      loadIndiaStateCode()
    }
    catch{
      case e: CensusAnalyzerException => e.printStackTrace()
    }
  }
}
