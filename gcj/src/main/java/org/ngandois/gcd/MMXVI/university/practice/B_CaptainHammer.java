package org.ngandois.gcd.MMXVI.university.practice;

import org.ngandois.gcd.tools.*;

import java.io.IOException;


// !!! failed due to rounding/precision !!!
public class B_CaptainHammer extends CaseResolver {

    public static void main(String[] args) throws IOException {
        B_CaptainHammer solver = new B_CaptainHammer();
        new ExerciseResolver("B-small-practice", solver).resolve();
    }

    public B_CaptainHammer() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }

    @Override
    public Exercise.TestResult solve(Exercise.TestCase aCase) {
        double v = Double.parseDouble(aCase.data.get(0).get(0));
        double d = Double.parseDouble(aCase.data.get(0).get(1));

        // https://fr.wikipedia.org/wiki/Balistique
        double degrees = Math.toDegrees(0.5 * Math.asin((d * 9.8) / (v * v)));

        return new Exercise.TestResult(aCase.testNumber, DoubleFormat.format(degrees));
    }


}
