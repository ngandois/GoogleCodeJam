package org.ngandois.gcd.tools;

import java.util.List;

public class Exercise {
  public final List<TestCase> cases;

  public Exercise(List<TestCase> cases) {
    this.cases = cases;
  }

  public int getNbCases() {
    return cases.size();
  }


  public static class TestCase {

    public final int testNumber;
    public final List<List<String>> data;

    public TestCase(int testNumber, List<List<String>> data) {
      this.testNumber = testNumber;
      this.data = data;
    }

    @Override
    public String toString() {
      return "#" + testNumber + ": " + data;
    }
  }

  public static class TestResult {

    public final int testNumber;
    public final String[] results;
    private boolean invalid;

    public TestResult(int testNumber, String... results) {
      this.testNumber = testNumber;
      this.results = results;
    }

    public void setInvalid() {
      invalid = true;
    }

    public boolean isInvalid() {
      return invalid;
    }

  }
}
