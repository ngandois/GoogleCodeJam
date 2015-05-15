package org.ngandois.gcd.tools;

import java.util.List;

/**
 * Created by ngandois on 19/04/15.
 */
public class Exercise {
    public final int nbCase;
    public final List<TestCase> cases;

    public Exercise(int nbCase, List<TestCase> cases) {
        this.nbCase = nbCase;
        this.cases = cases;
    }


    public static class TestCase{

        public final int testNumber;
        public final String data;

        public TestCase(int testNumber, String data){
            this.testNumber = testNumber;
            this.data = data;
        }

    }

    public static class TestResult{

        public final int testNumber;
        public final String[] results;

        public TestResult(int testNumber, String[] results){
            this.testNumber = testNumber;
            this.results = results;
        }

    }
}
