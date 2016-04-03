package org.ngandois.gcd.MMXV.qualif.A;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;


public class A implements Function<Exercise.TestCase, Exercise.TestResult>{

    public static void main(String[] args) throws IOException {

        A solver = new A();
        CaseReader reader = new LineByLineCaseReader(new InputSpaceParsing());
        new ExerciseResolver("src/main/resources/A-small-practice", solver, reader).resolve();
        new ExerciseResolver("src/main/resources/A-large-practice", solver, reader).resolve();
    }


    @Override
    public Exercise.TestResult apply(Exercise.TestCase c) {
        int nbStandUp = 0;
        int nbToInvite = 0;

        ArrayList<String> data = c.data.get(0);

        int maxShyness = Integer.parseInt(data.get(0));
        char[] people =  data.get(1).toCharArray();

        for (int shynessCursor = 0; (shynessCursor < people.length) && (nbStandUp + nbToInvite < maxShyness); shynessCursor++) {
            int nextNbStandUp = Character.getNumericValue(people[shynessCursor]);

            if (nbStandUp + nbToInvite < shynessCursor){
                nbToInvite += shynessCursor - (nbStandUp + nbToInvite);
            }

            nbStandUp += nextNbStandUp;
        }

        return new Exercise.TestResult(c.testNumber, new String[]{String.valueOf(nbToInvite)});
    }
}
