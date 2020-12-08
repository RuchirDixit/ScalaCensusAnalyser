package com.bridgelabz.censusanalyser

import java.nio.file.{Files, Paths}
import java.util

import com.bridgelabz.censusanalyser.CSVBuilderFactory.createCSVBuilder

/**
 * Created on 12/7/2020.
 * Class: USCensusDataAnalyser.scala
 * Author: Rajat G.L.
 */
object USCensusDataAnalyser {

  var table: util.List[USCensusData] = new util.ArrayList()

  def loadUSCensusData(path: String = "asset/USCensusData.csv"): Int = {

    val readerStateCensus = Files.newBufferedReader(Paths.get(path))
    table = createCSVBuilder().fetchList(readerStateCensus, classOf[USCensusData])
    table.size() - 1
  }

  def sortUSCensusDataByColumnIndex(column: Int): Unit = {
    util.Collections.sort(table, (o1: USCensusData, o2: USCensusData) => {
      try {
        val o1Int = o1.get(column).asInstanceOf[Double]
        val o2Int = o2.get(column).asInstanceOf[Double]
        o1Int.compareTo(o2Int)
      }
      catch{
        case _:Exception =>
          o1.get(column).asInstanceOf[String].compareTo(o2.get(column).asInstanceOf[String])
      }
    })
  }

  def sortUSCensusDataByStateName(): Unit ={
    sortUSCensusDataByColumnIndex(1)
  }

  def printUSCensusData(): Unit ={
    for(index <- 0 until table.size()){
      println(table.get(index))
    }
  }
}
