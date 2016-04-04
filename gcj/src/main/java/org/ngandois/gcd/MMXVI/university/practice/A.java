package org.ngandois.gcd.MMXVI.university.practice;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;


public class A extends CaseResolver {

    public static void main(String[] args) throws IOException {
        A solver = new A();
        new ExerciseResolver("A-small-practice-1", solver).resolve();
        new ExerciseResolver("A-small-practice-2", solver).resolve();
    }

    private static final String[] yes = new String[]{"Yes"};
    private static final String[] no = new String[]{"No"};

    public A(){
        super(new ReadNbLineFirstCaseReader(new InputSpaceParsing()));
    }

    @Override
    public Exercise.TestResult apply(Exercise.TestCase c) {
        Map<String, Set<String>> m = new HashMap<>();

         for( ArrayList<String> d : c.data) {
            String p1 = d.get(0);
            String p2 = d.get(1);

             Set<String> p1s = getSet(m, p1);

         }

        return new Exercise.TestResult(c.testNumber, yes);
    }

    private  static Set<String> getSet(Map<String, Set<String>> m, String k){
        Set<String> s = m.get(k);
        if (s == null) {
            s = new HashSet<>();
            m.put(k, s);
        }
        return s;
    }
}
