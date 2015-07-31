package com.darkstar.ngram

import com.darkstar.ngram.model.NGramWithFrequency

/**
 * Computes Ngrams for the input, and prints out the sorted results.
 * @author tbrooks
 */
class Main {
    public static String NGRAM_DELIMITER = " "


    public static void main(String [] args){
        validateInput(args)

        List<NGramWithFrequency> ngrams = computeNGramsFromInput(args)
        Collections.sort(ngrams, new NGramWithFrequencyComparator())

        ngrams.each {
            println it
        }
    }

    private static List<NGramWithFrequency> computeNGramsFromInput(String[] args) {
        InputParser inputParser = new InputParser()
        String text = inputParser.parseTextFromFilePath(args[0])
        int mValue = inputParser.parseInteger(args[1])

        ComputeNGrams computeNGrams = new ComputeNGrams();
        return computeNGrams.computeNgrams(text, mValue)
    }

    private static validateInput(String[] args) {
        if (args.length < 2) {
            println "Please supply the fileName, and an integer value for the max length of Ngrams as parameters"
            throw new IllegalArgumentException("Invalid parameters")
        }
    }
}
