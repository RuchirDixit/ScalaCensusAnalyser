package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.CensusAnalyzer

/**
 * Created on 11/30/2020.
 * Class: CSVDriver.scala
 * Author: Rajat G.L.
 */
object CSVDriver {
  def main(args: Array[String]): Unit = {
    val indiaStateCensusDataPath = "asset/IndiaStateCensusData.csv"
    val indiaStateCodePath = "asset/IndiaStateCode.csv"
    val censusAnalyserObject = new CensusAnalyzer()
    censusAnalyserObject.loadIndiaStateCensusData(indiaStateCensusDataPath)
    censusAnalyserObject.loadIndiaStateCodeData(indiaStateCodePath)
  }
}
