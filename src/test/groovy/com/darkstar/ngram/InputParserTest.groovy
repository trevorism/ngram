package com.darkstar.ngram

import org.junit.Test

import java.nio.file.Path
import java.nio.file.Paths

/**
 * @author tbrooks
 */
class InputParserTest {

    @Test
    public void "a file can be found by the InputParser"(){
        Path path = Paths.get("sampleFile.txt")
        String pathAsString = path.toAbsolutePath().toString()

        InputParser parser = new InputParser()
        String content = parser.parseTextFromFilePath(pathAsString)

        assert "a good puzzle is a fun puzzle" == content
    }

    @Test
    public void "a valid M value works"(){
        InputParser parser = new InputParser()
        assert 5 == parser.parseInteger("5")
    }

    @Test(expected=IllegalArgumentException)
    public void "an invalid M value throws an IllegalArgumentException"(){
        InputParser parser = new InputParser()
        parser.parseInteger("-5")
    }

    @Test(expected=IllegalArgumentException)
    public void "an invalid path throws an IllegalArgumentException"(){
        InputParser parser = new InputParser()
        parser.parseTextFromFilePath("asdf")
    }

}
