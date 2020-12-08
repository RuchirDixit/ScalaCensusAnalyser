package com.bridgelabz.censusanalyser

import java.nio.file.{Files, Paths}
import java.util

import com.bridgelabz.censusanalyser.CSVBuilderFactory.createCSVBuilder
import com.bridgelabz.censusanalyser.CensusLoader.{checkFileProperties, loadCSVData}
import com.bridgelabz.censusanalyser.exception.CensusAnalyzerException

object IndiaStateCensusDataAnalyser {

  var table: util.List[IndiaStateCensus] = new util.ArrayList()

  @throws[CensusAnalyzerException]
  def loadIndiaStateCensusData(path: String = "asset/IndiaStateCensusData.csv"): Int = {

    checkFileProperties(path, Array[String]("State","Population","AreaInSqKm","DensityPerSqKm"))

    val readerStateCensus = Files.newBufferedReader(Paths.get(path))
    table = createCSVBuilder().fetchList(readerStateCensus, classOf[IndiaStateCensus])
    table.size()
  }

  def sortStateCensusDataByColumnIndex(column: Int): Unit = {
    util.Collections.sort(table, (o1: IndiaStateCensus, o2: IndiaStateCensus) => {
      try {
        val o1Int = o1.get(column).asInstanceOf[Integer]
        val o2Int = o2.get(column).asInstanceOf[Integer]
        o1Int.compareTo(o2Int)
      }
      catch{
        case e:Exception =>
          o1.get(column).asInstanceOf[String].compareTo(o2.get(column).asInstanceOf[String])
      }
    })
  }

  def sortStateCensusDataByStateName(): Unit ={
    sortStateCensusDataByColumnIndex(0)
  }

  def sortStateCensusDataByPopulation():Unit = {
    sortStateCensusDataByColumnIndex(1)
  }

  def printStateCensusData(): Unit ={
    for(index <- 0 until table.size()){
      println(table.get(index))
    }
  }
}
