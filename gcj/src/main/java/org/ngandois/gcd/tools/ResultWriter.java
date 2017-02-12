package org.ngandois.gcd.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class ResultWriter {

    private final String[] results;
    private AtomicInteger currentNbResults = new AtomicInteger(0);
    private String fileName;

    public ResultWriter(int nbCases, String fileName) throws IOException {
        this.fileName = String.join("/", "exercise-output", fileName);
        results = new String[nbCases];
    }

    /**
     * The thread writing the latest test case result will flush the content on the disk
     */
    public void write(Exercise.TestResult result) {
        StringBuilder tmp = new StringBuilder(20);
        tmp.append("Case #").append(String.valueOf(result.testNumber)).append(": ");

        for (String r : result.results) {
            tmp.append(r).append(" ");
        }
        tmp.setLength(tmp.length() - 1);

        if (result.testNumber != this.results.length)
            tmp.append("\n"); // no carriage return for the latest result


        this.results[result.testNumber - 1] = tmp.toString();

        if (currentNbResults.incrementAndGet() == this.results.length) {
            flush();
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
