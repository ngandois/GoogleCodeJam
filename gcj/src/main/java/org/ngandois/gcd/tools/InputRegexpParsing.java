package org.ngandois.gcd.tools;

public class InputRegexpParsing implements InputParser
{
    private final String regexp;

    public InputRegexpParsing(String regexp){
        this.regexp = regexp;
    }

    @Override
    public String[] parse(String line) {
        return line.split(regexp);
    }
}
