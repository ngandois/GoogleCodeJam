package org.ngandois.gcd.tools;

@SuppressWarnings("unused")
public class ReadNbLineFirstCaseReader implements CaseReader {

    private int nbLineTarget;
    private int nbLineCurrent;

    private int factor = 1;
    private int offset = 0;
    private final InputParser inputParser;

    public ReadNbLineFirstCaseReader(int factor, int offset, InputParser inputParser) {
        this.factor = factor;
        this.offset = offset;
        this.inputParser = inputParser;
    }

    public ReadNbLineFirstCaseReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public String[] read(String inputLine) {
        if (nbLineTarget <= 0) { // just read the number of lines to retrieve then
            nbLineTarget = Integer.parseInt(inputLine) * factor + offset;
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
