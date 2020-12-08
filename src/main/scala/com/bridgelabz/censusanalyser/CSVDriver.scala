package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.censusutils.IndiaStateCensusDataAnalyser.{loadIndiaStateCensusData, printStateCensusData, sortStateCensusDataByArea, sortStateCensusDataByPopulation, sortStateCensusDataByStateName, table}
import com.bridgelabz.censusanalyser.censusutils.IndiaStateCodeAnalyser.{loadIndiaStateCode, printStateCode, sortStateCodeByStateName}
import com.bridgelabz.censusanalyser.censusutils.USCensusDataAnalyser.{loadUSCensusData, printUSCensusData, sortUSCensusDataByPopulation, sortUSCensusDataByStateName}
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

      println("1. Sort by State Name [India-Census Database]\n2. Sort by State Size [India-Census Database]\n3. Sort by Population [India-Census Database]\n4. Sort by State Name [India-State-Code Database]\n5. Sort by State Name [US-State-Census Database]\n6. Sort by Population [US-State-Census Database]");
      try{
        val choice = scala.io.StdIn.readInt()
        choice match {
          case 1 =>
            sortStateCensusDataByStateName()
            printStateCensusData()
          case 2 =>
            sortStateCensusDataByArea()
            printStateCensusData()
          case 3 =>
            sortStateCensusDataByPopulation()
            printStateCensusData()
          case 4 =>
            sortStateCodeByStateName()
            printStateCode()
          case 5 =>
            sortUSCensusDataByStateName()
            printUSCensusData()
          case 6 =>
            sortUSCensusDataByPopulation()
            printUSCensusData()
        }
      }
    }
    catch{
      case e: CensusAnalyzerException => e.printStackTrace()
    }
  }
}
