package org.ngandois.gcd.MMXVI.university.practice;

import org.ngandois.gcd.tools.*;

import java.io.IOException;


public class B_CaptainHammer extends CaseResolver {

    public static void main(String[] args) throws IOException {
        B_CaptainHammer solver = new B_CaptainHammer();
        new ExerciseResolver("B-small-practice", solver).resolve();
    }

    public B_CaptainHammer() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }

    @Override
    // https://fr.wikipedia.org/wiki/Balistique
    public Exercise.TestResult solve(Exercise.TestCase aCase) {
        double v = Double.parseDouble(aCase.data.get(0).get(0));
        double d = Double.parseDouble(aCase.data.get(0).get(1));


        double a = (d * 9.8) / (v * v);

        // as said by Google all inputs are valid, so having to perform asin > 1 means a double precision issue (so cap at 1)
        //if (a > 1) a = 1;

        double degrees = Math.toDegrees(0.5 * Math.asin(a));

        return new Exercise.TestResult(aCase.testNumber, DoubleFormat.format(degrees));
    }


}
