package com.bridgelabz.censusanalyser.csvutils

/**
 * Created on 12/5/2020.
 * Class: CSVBuilderFactory.scala
 * Author: Rajat G.L.
 */
object CSVBuilderFactory {
  def createCSVBuilder(): CSVBuilderTrait = {
    new OpenCSVBuilder()
  }
}
