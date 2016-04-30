package org.ngandois.gcd.MMXVI.round.one.B;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.*;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-large-practice", solver).resolve();
    }

    public A() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    private static final Collection<Character> zero = Arrays.asList('Z', 'E', 'R', 'O');
    private static final Collection<Character> one = Arrays.asList('O', 'N', 'E');
    private static final Collection<Character> two = Arrays.asList('T', 'W', 'O');
    private static final Collection<Character> three = Arrays.asList('T', 'H', 'R', 'E', 'E');
    private static final Collection<Character> four = Arrays.asList('F', 'O', 'U', 'R');
    private static final Collection<Character> five = Arrays.asList('F', 'I', 'V', 'E');
    private static final Collection<Character> six = Arrays.asList('S', 'I', 'X');
    private static final Collection<Character> seven = Arrays.asList('S', 'E', 'V', 'E', 'N');
    private static final Collection<Character> eight = Arrays.asList('E', 'I', 'G', 'H', 'T');
    private static final Collection<Character> nine = Arrays.asList('N', 'I', 'N', 'E');


    @Override
    public Exercise.TestResult apply(Exercise.TestCase c) {
        Collection<Character> chars = new LinkedList<>();

        char[] toCharArray = c.data.get(0).get(0).toCharArray();
        for (char c1 : toCharArray) {
            chars.add(c1);
        }

        List<Character> digits = new LinkedList<>();
        digits.addAll(check(chars, zero, '0'));
        digits.addAll(check(chars, two, '2'));
        digits.addAll(check(chars, six, '6'));
        digits.addAll(check(chars, eight, '8'));
        digits.addAll(check(chars, seven, '7'));
        digits.addAll(check(chars, three, '3'));
        digits.addAll(check(chars, five, '5'));
        digits.addAll(check(chars, nine, '9'));
        digits.addAll(check(chars, four, '4'));
        digits.addAll(check(chars, one, '1'));

        Collections.sort(digits);
        StringBuilder r = new StringBuilder(digits.size());
        digits.forEach(r::append);
        return new Exercise.TestResult(c.testNumber, r.toString());
    }

    private Collection<Character> check(Collection<Character> chars, Collection<Character> number, Character digit) {
        Collection<Character> digits = new LinkedList<>();
        while (chars.containsAll(number)) {
            number.forEach(chars::remove);
            digits.add(digit);
        }
        return digits;
    }
}
