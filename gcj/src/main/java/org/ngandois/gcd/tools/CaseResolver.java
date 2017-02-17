package org.ngandois.gcd.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public abstract class CaseResolver implements Function<Exercise.TestCase, Exercise.TestResult> {

    private static final Logger log = LogManager.getLogger(CaseResolver.class);
    private final CaseReader reader;

    public CaseResolver(CaseReader reader) {
        this.reader = reader;
    }

    public CaseReader getReader() {
        return reader;
    }


    @Override
    public final Exercise.TestResult apply(Exercise.TestCase testCase) {
        long b = System.currentTimeMillis();
        log.info("solving #{}...", testCase.testNumber);

        Exercise.TestResult result;
        try {
            result = solve(testCase);
            log.info("solved #{} in {}s", testCase.testNumber, MILLISECONDS.toSeconds(System.currentTimeMillis() - b));
        } catch (Throwable t) {
            log.fatal("cannot solve " + testCase, t);
            result = new Exercise.TestResult(testCase.testNumber, "!!ERROR!! : " + t.getLocalizedMessage() + " for data " + testCase);
            result.setInvalid();
        }

        return result;

    }

    public abstract Exercise.TestResult solve(Exercise.TestCase testCase);
}
