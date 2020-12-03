package com.bridgelabz.censusanalysertest

import com.bridgelabz.censusanalyser.IndiaStateCensusDataAnalyser.loadIndiaStateCensusData
import com.bridgelabz.censusanalyser.IndiaStateCodeAnalyser.loadIndiaStateCode
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException.Issue
import org.scalatest.FunSuite

class CensusAnalyserTest extends FunSuite {
  //path variables for IndiaStateCensusData
  val indiaStateCensusDataPath = "asset/IndiaStateCensusData.csv"
  val wrongFilePathForIndiaStateCensusData = "./IndiaStateCensusData.csv"
  val wrongTypeOfIndiaStateCensusData = "asset/IndiaStateCensusData.pdf"
  val wrongHeaderIndiaStateCensusPath = "asset/IndiaStateCensusDataWrongHeader.csv"
  //path variables for IndiaStateCode
  val indiaStateCodeDataPath = "asset/IndiaStateCode.csv"
  val wrongIndiaStateCodeFilePath = "./IndiaStateCode.csv"
  val wrongFileTypeIndiaStateCodePath = "asset/IndiaStateCode.pdf"
  val wrongHeaderIndiaStateCodePath = "asset/IndiaStateCodeWrongHeader.csv"

  test("givenIndianCensusCSVFileShouldReturnCorrectNumberOfRecords") {
    assert(loadIndiaStateCensusData(indiaStateCensusDataPath) === 29)
  }
  test("givenIndianCensusDataCSVFileIfWrongFilePathShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
      loadIndiaStateCensusData(wrongFilePathForIndiaStateCensusData)
    }
    assert(thrown.error === Issue.PATH_INCORRECT)
  }
  test("givenIndianCensusDataFileIfWrongTypeShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
     loadIndiaStateCensusData(wrongTypeOfIndiaStateCensusData)
    }
    assert(thrown.error === Issue.INCORRECT_FILE)
  }
  test("givenIndianCensusDataFileIfWrongHeaderShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
      loadIndiaStateCensusData(wrongHeaderIndiaStateCensusPath)
    }
    assert(thrown.error === Issue.INVALID_FIELDS)
  }

  test("givenIndiaStateCodeCSVFileShouldReturnCorrectNumberOfRecords") {
    assert(loadIndiaStateCode(indiaStateCodeDataPath) === 37)
  }
  test("givenIndiaStateCodeCSVFileIfWrongFilePathShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
      loadIndiaStateCode(wrongIndiaStateCodeFilePath)
    }
    assert(thrown.error === Issue.PATH_INCORRECT)
  }
  test("givenIndiaStateCodeFileIfWrongTypeShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
      loadIndiaStateCode(wrongFileTypeIndiaStateCodePath)
    }
    assert(thrown.error === Issue.INCORRECT_FILE)
  }
  test("givenIndiaStateCodeFileIfWrongHeaderShouldThrowException") {
    val thrown = intercept[CensusAnalyzerException] {
      loadIndiaStateCode(wrongHeaderIndiaStateCodePath)
    }
    assert(thrown.error === Issue.INVALID_FIELDS)
  }

}