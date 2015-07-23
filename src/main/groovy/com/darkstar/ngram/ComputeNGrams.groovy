package com.darkstar.ngram

import com.darkstar.ngram.model.NGramWithFrequency

/**
 * Computes nGrams for the given input.
 * @author tbrooks
 */
class ComputeNGrams {

    public List<NGramWithFrequency> computeNgrams(String inputText, int maxNGramLength){
        Map<String, Integer> foundNGrams = [:]
        String [] words = inputText.split(" ")

        for(int i=0; i < maxNGramLength; i++){
            int nGramLength = i+1;
            findNGramsOfLength(foundNGrams, words, nGramLength)
        }
        return foundNGrams.collect {k,v -> new NGramWithFrequency(nGram: k, frequency: v)}
    }

    private static void findNGramsOfLength(Map<String, Integer> foundNGrams, String[] words, int nGramLength) {
        for (int i = 0; i < words.length; i++) {
            String ngram = buildNGram(nGramLength, i, words)
            if (ngram) {
                addNgramToMap(foundNGrams, ngram)
            }
        }
    }

    private static buildNGram(int nGramLength, int currentIndex, String[] words) {
        String ngram = "";
        for (int i = 0; i < nGramLength; i++) {
            if (currentIndex + i >= words.length) {
                ngram = "";
                break;
            }
            ngram += (" " + words[currentIndex + i])
            ngram = ngram.trim()
        }
        return ngram
    }

    private static addNgramToMap(Map<String, Integer> foundNGrams, String ngram) {
        if (foundNGrams.containsKey(ngram)) {
            foundNGrams[ngram] = foundNGrams[ngram] + 1;
        } else {
            foundNGrams[ngram] = 1
        }
    }
}
