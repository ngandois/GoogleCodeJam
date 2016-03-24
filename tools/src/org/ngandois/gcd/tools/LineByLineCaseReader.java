package org.ngandois.gcd.tools;

public class LineByLineCaseReader implements CaseReader {

    private InputParser inputParser;

    public LineByLineCaseReader(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    @Override
    public String[] read(String inputLine) {
        return inputParser.parse(inputLine);
    }

    @Override
    public boolean accumulate() {
        return false;
    }
}
