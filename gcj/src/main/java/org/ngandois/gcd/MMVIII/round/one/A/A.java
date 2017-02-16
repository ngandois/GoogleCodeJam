package org.ngandois.gcd.MMVIII.round.one.A;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-small-practice", solver).resolve();
    }

    public A(){
        super(new SkipOneReadXCaseReader(2, new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult solve(Exercise.TestCase c) {
        List<String> v1 = c.data.get(0);
        List<String> v2 = c.data.get(1);

        Integer[] sorted = v1.stream().map(Integer::parseInt).sorted().toArray(Integer[]::new);
        Integer[] reverse = v2.stream().map(Integer::parseInt).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

        BigInteger m = IntStream.range(0, v1.size())
                .mapToObj(i -> BigInteger.valueOf(sorted[i]).multiply(BigInteger.valueOf(reverse[i])))
                .reduce(BigInteger.ZERO, BigInteger::add);

        return new Exercise.TestResult(c.testNumber, String.valueOf(m));
    }
}
