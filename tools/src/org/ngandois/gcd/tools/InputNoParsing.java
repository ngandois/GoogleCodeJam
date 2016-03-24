package org.ngandois.gcd.tools;

public class InputNoParsing implements InputParser
{
    @Override
    public String[] parse(String line) {
        return new String[]{line};
    }
}
