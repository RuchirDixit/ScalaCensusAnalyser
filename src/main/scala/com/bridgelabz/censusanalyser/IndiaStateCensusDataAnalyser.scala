package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.CensusAnalyzer.loadCSVData
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException

object IndiaStateCensusDataAnalyser {
  @throws[CensusAnalyzerException]
  def loadIndiaStateCensusData(path: String = "asset/IndiaStateCensusData.csv"): Int = {
    val indiaStateCensusDataPath = path
    loadCSVData(indiaStateCensusDataPath, Array("state", "population", "areainsqkm", "densitypersqkm"))
  }
}
