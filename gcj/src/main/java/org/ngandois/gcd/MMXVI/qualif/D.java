package org.ngandois.gcd.MMXVI.qualif;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class D extends CaseResolver {

    public static void main(String[] args) throws IOException {
        D solver = new D();
        new ExerciseResolver("D-large", solver).resolve();
    }

    private D() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult apply(Exercise.TestCase c) {
        long N = Long.parseLong(c.data.get(0).get(0));

        return new Exercise.TestResult(c.testNumber, String.valueOf(N));
    }
}
