package com.darkstar.ngram

import com.darkstar.ngram.model.NGramWithFrequency
import org.junit.Test

/**
 * @author tbrooks
 */
class NGramWithFrequencyComparatorTest {

    @Test
    void "compares different ngram with same number of spaces"() {
        NGramWithFrequencyComparator comparator = new NGramWithFrequencyComparator()

        NGramWithFrequency nGramWithFrequency1 = new NGramWithFrequency(nGram: "a", frequency: 30)
        NGramWithFrequency nGramWithFrequency2 = new NGramWithFrequency(nGram: "b", frequency: 10)

        assert -1 == comparator.compare(nGramWithFrequency1, nGramWithFrequency2)
        assert 1 == comparator.compare(nGramWithFrequency2, nGramWithFrequency1)
    }

    @Test
    void "compares different number of spaces"() {
        NGramWithFrequencyComparator comparator = new NGramWithFrequencyComparator()

        NGramWithFrequency nGramWithFrequency1 = new NGramWithFrequency(nGram: "a", frequency: 30)
        NGramWithFrequency nGramWithFrequency2 = new NGramWithFrequency(nGram: "a a", frequency: 10)

        assert -1 == comparator.compare(nGramWithFrequency1, nGramWithFrequency2)
        assert 1 == comparator.compare(nGramWithFrequency2, nGramWithFrequency1)
    }

    @Test
    void "compares exact same ngram"() {
        NGramWithFrequencyComparator comparator = new NGramWithFrequencyComparator()

        NGramWithFrequency nGramWithFrequency1 = new NGramWithFrequency(nGram: "a", frequency: 30)
        NGramWithFrequency nGramWithFrequency2 = new NGramWithFrequency(nGram: "a", frequency: 10)

        assert 0 == comparator.compare(nGramWithFrequency1, nGramWithFrequency2)
    }


}
