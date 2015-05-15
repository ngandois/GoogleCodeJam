package org.ngandois.gcd.qualif.A;

import org.ngandois.gcd.tools.Exercise;
import org.ngandois.gcd.tools.ExerciseResolver;

import java.io.File;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by ngandois on 19/04/15.
 */
public class A implements Function<Exercise.TestCase, Exercise.TestResult>{

    public static void main(String[] args) throws IOException {

        A solver = new A();
        new ExerciseResolver("2015", "A", true, solver).resolve();
        new ExerciseResolver("2015", "A", false, solver).resolve();
    }

    @Override
    public Exercise.TestResult apply(Exercise.TestCase c) {
        int nbStandUp = 0;
        int nbToInvite = 0;

        int maxShyness = Integer.parseInt(c.data.substring(0, c.data.indexOf(" ")));
        char[] people =  c.data.substring(c.data.indexOf(" ") + 1, c.data.length()).toCharArray();

        for (int shynessCursor = 0; shynessCursor < people.length && nbStandUp < maxShyness; shynessCursor++) {
            int nextNbStandUp = quickParse(people[shynessCursor]);

            if (nbStandUp + nbToInvite < shynessCursor){
                nbToInvite+= shynessCursor - (nbStandUp + nbToInvite);
            }

            nbStandUp += nextNbStandUp;
        }

        return new Exercise.TestResult(c.testNumber, new String[]{String.valueOf(nbToInvite)});
    }


    private static int quickParse(char c){
        switch (c){
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
        }
        return -1;

    }
}
