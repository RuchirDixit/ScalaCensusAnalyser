package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.IndiaStateCensusDataAnalyser.{loadIndiaStateCensusData, printStateCensusData, sortStateCensusDataByPopulation, sortStateCensusDataByStateName, table}
import com.bridgelabz.censusanalyser.IndiaStateCodeAnalyser.{loadIndiaStateCode, printStateCode, sortStateCodeByStateName}
import com.bridgelabz.censusanalyser.USCensusDataAnalyser.{loadUSCensusData, printUSCensusData, sortUSCensusDataByStateName}
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
      loadUSCensusData()

      println("1. Sort by State Name [India-Census Database]\n2. Sort by Population [India-Census Database]\n3. Sort by State Name [India-State-Code Database]\n4. Sort by State Name [US-State-Census Database]");
      try{
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 =>
            sortStateCensusDataByStateName()
            printStateCensusData()
          case 2 =>
            sortStateCensusDataByPopulation()
            printStateCensusData()
          case 3 =>
            sortStateCodeByStateName()
            printStateCode()
          case 4 =>
            sortUSCensusDataByStateName()
            printUSCensusData()
        }
      }
    }
    catch{
      case e: CensusAnalyzerException => e.printStackTrace()
    }
  }
}
