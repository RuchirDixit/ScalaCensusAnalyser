package com.bridgelabz.censusanalysertest

import com.bridgelabz.censusanalyser.CensusAnalyzer
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue
import org.scalatest.FunSuite

class CensusAnalyserTest extends FunSuite {
  val indiaStateCensusDataPath = "asset/IndiaStateCensusData.csv"
  val wrongFilePathForIndiaStateCensusData = "./IndiaStateCensusData.csv"
  val wrongTypeOfIndiaStateCensusData = "asset/IndiaStateCensusData.pdf"
  val wrongHeaderIndiaStateCensusPath = "asset/IndiaStateCode.csv"
  val CensusAnalyzerObj = new CensusAnalyzer()
  test("givenIndianCensusCSVFileShouldReturnCorrectNumberOfRecords") {
    assert(CensusAnalyzerObj.loadCSVData(indiaStateCensusDataPath) === 29)
  }
  test("givenIndianCensusDataCSVFileIfWrongFilePathShouldThrowException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVData(wrongFilePathForIndiaStateCensusData)
    }
    assert(thrown.getMessage === Issue.PATH_INCORRECT.toString)
  }
  test("givenIndianCensusDataFileIfWrongTypeShouldThrowException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVData(wrongTypeOfIndiaStateCensusData)
    }
    assert(thrown.getMessage === Issue.INCORRECT_FILE.toString)
  }
  test("givenIndianCensusDataFileIfWrongHeaderShouldThrowException") {
    val thrown = intercept[Exception] {
      CensusAnalyzerObj.loadCSVData(wrongHeaderIndiaStateCensusPath)
    }
    assert(thrown.getMessage === Issue.INVALID_FIELDS.toString)
  }
}