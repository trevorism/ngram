package com.darkstar.ngram.model

import groovy.transform.EqualsAndHashCode

/**
 * Holds the n gram and the frequency.
 * @author tbrooks
 */
@EqualsAndHashCode()
final class NGramWithFrequency {
    String nGram
    int frequency

    @Override
    public String toString(){
        return "${nGram} ${frequency}"
    }
}
