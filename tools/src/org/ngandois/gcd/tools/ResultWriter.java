package org.ngandois.gcd.tools;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LongSummaryStatistics;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;

/**
 * Created by ngandois on 18/04/15.
 */
public class ResultWriter {

    private final String[] results;
    private AtomicInteger currentNbResults = new AtomicInteger(0);
    private String fileName;


    public ResultWriter(int nbCases, String year, String fileName) {
        this.fileName = String.join("/", year, "output", fileName);
        results = new String[nbCases];
    }

    /**
     * The thread writing the latest test case result will flush the content on the disk
     *
     * @param caseNb  The test case number
     * @param results The results to write (will be separated by a space)
     */
    public void write(int caseNb, String... results) {
        StringBuilder tmp = new StringBuilder(20);
        tmp.append("Case #").append(String.valueOf(caseNb + 1)).append(": ");
        for (int i = 0; i < results.length; i++) {
            tmp.append(results[i]).append(" ");
        }
        tmp.setLength(tmp.length() - 1);
        tmp.append("\n");
        this.results[caseNb] = tmp.toString();

        if (currentNbResults.addAndGet(1) == this.results.length) {
            flush();
        }
    }


    private void flush() {
        try {
            FileWriter w = new FileWriter(fileName);

            for (int i = 0; i < results.length; i++) {
                w.write(results[i]);
            }
            w.flush();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
