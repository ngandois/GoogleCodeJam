package org.ngandois.gcd.MMXVI.qualif;

import org.ngandois.gcd.tools.*;

import java.io.IOException;


public class B extends CaseResolver {

    public static void main(String[] args) throws IOException {
        B solver = new B();
        new ExerciseResolver("B-large", solver).resolve();
    }

    private B() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult solve(Exercise.TestCase c) {
        char[] chars = c.data.get(0).get(0).toCharArray();

        long step = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                step++;
                for (int j = 0; j <= i; j++)
                    chars[j] = chars[i + 1];
            }
        }

        if(chars[0] == '-') // we finished with all the stack on the wrong side: flip it
            step++;

        return new Exercise.TestResult(c.testNumber, String.valueOf(step));
    }
}