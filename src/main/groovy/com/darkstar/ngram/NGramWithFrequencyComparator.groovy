package com.darkstar.ngram

import com.darkstar.ngram.model.NGramWithFrequency

/**
 * Sorts NGrams based on requirements.
 * @author tbrooks
 */
class NGramWithFrequencyComparator implements Comparator<NGramWithFrequency>{

    @Override
    int compare(NGramWithFrequency ngram1, NGramWithFrequency ngram2) {
        int initialSort = countSpaces(ngram1) <=> countSpaces(ngram2)
        if(initialSort == 0){
            return ngram1.nGram <=> ngram2.nGram
        }
        return initialSort
    }

    private static int countSpaces(NGramWithFrequency nGramWithFrequency) {
        nGramWithFrequency.nGram.split(Main.NGRAM_DELIMITER).length

    }
}
