package org.ngandois.gcd.MMXV.qualif.A;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Function;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-small-practice", solver).resolve();
        new ExerciseResolver("A-large-practice", solver).resolve();
    }

    public A(){
        super(new LineByLineCaseReader(new InputSpaceParsing()));
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
