package org.ngandois.gcd.MMXVI.round.one.A;

import org.ngandois.gcd.tools.*;

import java.io.IOException;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-large-practice", solver).resolve();
    }

    public A(){
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult solve(Exercise.TestCase c) {
        char[] chars = c.data.get(0).get(0).toCharArray();

        StringBuilder buf = new StringBuilder(chars.length);
        buf.append(chars[0]);

        for (int i = 1; i < chars.length; i++) {
            if(chars[i] >= buf.charAt(0))
                buf.insert(0, chars[i]);
            else
                buf.append(chars[i]);
        }

        return new Exercise.TestResult(c.testNumber, buf.toString());
    }
}
