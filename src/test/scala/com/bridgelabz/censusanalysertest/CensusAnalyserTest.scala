package com.bridgelabz.censusanalysertest

import com.bridgelabz.censusanalyser.CensusAnalyzer
import org.scalatest.FunSuite
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue

class CensusAnalyserTest extends FunSuite {
  val indiaStateCensusDataPath = "asset/IndiaStateCensusData.csv"
  val wrongFilePathForIndiaStateCensusData = "./IndiaStateCensusData.csv"
  val CensusAnalyzerObj = new CensusAnalyzer()
  test("givenIndianCensusCSVFileShouldReturnCorrectNumberOfRecords") {
    assert(CensusAnalyzerObj.loadCSVData(indiaStateCensusDataPath) === 29)
  }
  test("givenIndianCensusDataCSVFileIfWrongFilePathShouldThrowException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVData( wrongFilePathForIndiaStateCensusData)
    }
    assert(thrown.getMessage === Issue.PATH_INCORRECT.toString)
  }

}