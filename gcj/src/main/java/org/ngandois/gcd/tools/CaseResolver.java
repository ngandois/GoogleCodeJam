package org.ngandois.gcd.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
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
      String r = solve(testCase.data);
      long end = System.currentTimeMillis() - b;
      log.info("solved #{} in {}ms ({}s)", testCase.testNumber, end, MILLISECONDS.toSeconds(end));
      result = new Exercise.TestResult(testCase.testNumber, r);
    } catch (Throwable t) {
      log.fatal("cannot solve " + testCase, t);
      result = new Exercise.TestResult(testCase.testNumber, "!!ERROR!! : " + t.getLocalizedMessage() + " for data " + testCase);
      result.setInvalid();
    }

    return result;

  }

  public abstract String solve(List<List<String>> data);
}
