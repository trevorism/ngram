package com.darkstar.ngram

import com.darkstar.ngram.model.NGramWithFrequency
import org.junit.Test

/**
 * @author tbrooks
 */
class ComputeNGramsTest {


    @Test
    void testComputeNgrams() {
        ComputeNGrams computeNGrams = new ComputeNGrams()
        Set<NGramWithFrequency> ngrams = computeNGrams.computeNgrams("a good puzzle is a fun puzzle", 2);

        assert ngrams
        assert ngrams.size() == 11

        assert contains(ngrams, "a", 2)
        assert contains(ngrams, "fun", 1)
        assert contains(ngrams, "good", 1)
        assert contains(ngrams, "is", 1)
        assert contains(ngrams, "puzzle", 2)
        assert contains(ngrams, "a fun", 1)
        assert contains(ngrams, "a good", 1)
        assert contains(ngrams, "fun puzzle", 1)
        assert contains(ngrams, "good puzzle", 1)
        assert contains(ngrams, "is a", 1)
        assert contains(ngrams, "puzzle is", 1)

    }

    @Test
    void testComputeNgramsWithBigM() {
        ComputeNGrams computeNGrams = new ComputeNGrams()
        Set<NGramWithFrequency> ngrams = computeNGrams.computeNgrams("a b c", 8);

        assert contains(ngrams, "a", 1)
        assert contains(ngrams, "b", 1)
        assert contains(ngrams, "c", 1)
        assert contains(ngrams, "a b", 1)
        assert contains(ngrams, "b c", 1)
        assert contains(ngrams, "a b c", 1)

    }

    @Test
    void testComputeNgramsWithRepeatedValues() {
        ComputeNGrams computeNGrams = new ComputeNGrams()
        Set<NGramWithFrequency> ngrams = computeNGrams.computeNgrams("a b a b", 2);

        assert contains(ngrams, "a", 2)
        assert contains(ngrams, "b", 2)
        assert contains(ngrams, "a b", 2)
        assert contains(ngrams, "b a", 1)
    }

    private static boolean contains(Set<NGramWithFrequency> nGramWithFrequencies, String text, int frequency) {
        NGramWithFrequency nGramWithFrequency = new NGramWithFrequency(nGram: text, frequency: frequency)
        return nGramWithFrequencies.contains(nGramWithFrequency)
    }
}
