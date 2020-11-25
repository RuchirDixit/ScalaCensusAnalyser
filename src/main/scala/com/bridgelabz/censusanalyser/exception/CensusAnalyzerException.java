package com.bridgelabz.censusanalyser.exception;

public class CensusAnalyzerException extends Exception {
    public static enum Issue{
        INCORRECT_FILE, PATH_INCORRECT, INVALID_DELIMITER, INVALID_FIELDS
    }
}
