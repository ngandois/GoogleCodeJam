package org.ngandois.gcd.tools;

public class SkipOneReadXCaseReader implements CaseReader {

    private int nbRowToRead;
    private int nbLineCurrent;

    private InputParser inputParser;

    public SkipOneReadXCaseReader(int nbRowToRead, InputParser inputParser) {
        this.nbRowToRead = nbRowToRead;
        this.inputParser = inputParser;
    }

    @Override
    public String[] read(String inputLine) {
        ++nbLineCurrent;

        if (nbLineCurrent == 1) { // skip the first one
            return new String[0];
        }


        return inputParser.parse(inputLine);
    }

    @Override
    public boolean accumulate() {
        if (nbLineCurrent > nbRowToRead) {
            nbLineCurrent = 0;
            return false;
        }
        return true;
    }
}
