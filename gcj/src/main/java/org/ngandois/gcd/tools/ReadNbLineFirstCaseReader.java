package org.ngandois.gcd.tools;

public class ReadNbLineFirstCaseReader implements CaseReader {

    private int nbLineTarget;
    private int nbLineCurrent;

    private InputParser inputParser;

    public ReadNbLineFirstCaseReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public String[] read(String inputLine) {
        if (nbLineTarget <= 0) { // just read the number of lines to retrieve then
            nbLineTarget = Integer.parseInt(inputLine);
            return new String[0];
        }

        ++nbLineCurrent;
        return inputParser.parse(inputLine);
    }

    @Override
    public boolean accumulate() {
        if (nbLineCurrent >= nbLineTarget) {
            nbLineCurrent = nbLineTarget = 0;
            return false;
        }
        return true;
    }
}
