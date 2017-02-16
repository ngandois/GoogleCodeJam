package org.ngandois.gcd.MMXVI.qualif;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-large", solver).resolve();
    }

    private A() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult solve(Exercise.TestCase c) {
        Set<Character> seen = new HashSet<>();
        int i = 0;
        long N = Long.parseLong(c.data.get(0).get(0));
        long current = 0;
        long previous = -1;

        while (seen.size() < 10) {

            if (previous == current || current < 0)
                return new Exercise.TestResult(c.testNumber, "INSOMNIA");

            previous = current;

            current = N * (1 + i++);
            char[] chars = String.valueOf(current).toCharArray();
            for (char aChar : chars) seen.add(aChar);
        }

        return new Exercise.TestResult(c.testNumber, String.valueOf(current));
    }
}
