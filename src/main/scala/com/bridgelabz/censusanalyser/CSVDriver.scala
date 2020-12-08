package com.bridgelabz.censusanalyser

import java.util

import com.bridgelabz.censusanalyser.IndiaStateCensusDataAnalyser.{loadIndiaStateCensusData, printStateCensusData, sortStateCensusDataByPopulation, sortStateCensusDataByStateName, table}
import com.bridgelabz.censusanalyser.IndiaStateCodeAnalyser.{loadIndiaStateCode, printStateCode, sortStateCodeByStateName}
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

      sortStateCensusDataByStateName()
      printStateCensusData()

      sortStateCodeByStateName()
      printStateCode()

      sortStateCensusDataByPopulation()
      printStateCensusData()
    }
    catch{
      case e: CensusAnalyzerException => e.printStackTrace()
    }
  }
}
