package com.bridgelabz.censusanalyser

import com.bridgelabz.censusanalyser.CensusAnalyzer.loadCSVData

/**
 * Created on 12/3/2020.
 * Class: IndiaStateCodeAnalyser.scala
 * Author: Rajat G.L.
 */
object IndiaStateCodeAnalyser {
  def loadIndiaStateCode(path: String = "asset/IndiaStateCode.csv"): Int = {
    val indiaStateCodePath = path
    loadCSVData(indiaStateCodePath, Array("srno", "state name", "tin", "statecode"))
  }
}