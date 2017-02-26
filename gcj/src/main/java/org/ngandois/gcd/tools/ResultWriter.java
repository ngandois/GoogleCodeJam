package org.ngandois.gcd.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ResultWriter implements Consumer<Exercise.TestResult> {

  private static final Logger log = LogManager.getLogger(ResultWriter.class);


  private final String[] results;
  private final AtomicInteger currentNbResults = new AtomicInteger(0);
  private final AtomicBoolean hasError = new AtomicBoolean(false);
  private final String fileName;

  public ResultWriter(int nbCases, String fileName) {
    this.fileName = String.join("/", "exercise-output", fileName);
    results = new String[nbCases];
  }

  public boolean hasReceivedError() {
    return hasError.get();
  }

  /**
   * The thread writing the latest test case result will flush the content on the disk
   */
  public void accept(Exercise.TestResult result) {
    if (result.isInvalid())
      hasError.set(true);

    StringJoiner joiner = new StringJoiner(" ", "Case #" + result.testNumber + ": ", "\n");
    for (String r : result.results) {
      joiner.add(r);
    }

    this.results[result.testNumber - 1] = joiner.toString();

    if (currentNbResults.incrementAndGet() == this.results.length) {
      log.info("all results received");
      flush();
    } else {
      log.info("still {} cases to solve", this.results.length - currentNbResults.get());
    }
  }


  private synchronized void flush() {
    try {
      FileWriter w = new FileWriter(fileName);

      for (String result : results) {
        w.write(result);
      }
      w.flush();

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }
}
