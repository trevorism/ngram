package com.darkstar.ngram

/**
 * Parses parameter input
 * @author tbrooks
 */
class InputParser {

    public String parseTextFromFilePath(String filepath){
        try {
            return parsePath(filepath)
        }catch (Exception e){
            throw new IllegalArgumentException("Unable to parse file path: ${filepath}")
        }
    }

    public int parseInteger(String m){
        try{
            return parseIntegerValue(m)
        }catch(Exception e){
            throw new IllegalArgumentException("Unable to parse n-gram length. ${m} is not a valid number")
        }
    }

    private static parseIntegerValue(String m) {
        int mValue = Integer.parseInt(m);
        if (mValue <= 0) {
            throw new RuntimeException()
        }
        return mValue;
    }

    private static parsePath(String filepath) {
        String text = new File(filepath)?.text
        if (!text) {
            throw new RuntimeException()
        }
        return text
    }
}
