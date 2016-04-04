package org.ngandois.gcd.tools;

import java.util.function.Function;

public abstract class CaseResolver implements Function<Exercise.TestCase, Exercise.TestResult> {

    private final CaseReader reader;

    public CaseResolver(CaseReader reader){
        this.reader = reader;
    }

    public CaseReader getReader() {
        return reader;
    }
}
