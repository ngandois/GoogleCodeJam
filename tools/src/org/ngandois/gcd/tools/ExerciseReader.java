package org.ngandois.gcd.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseReader {


    public static Exercise createExercise(String year, String fileName, CaseReader caseReader) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(year + "/resources", fileName));

        String sNbTest = lines.remove(0);
        int testCount = 1;

        List<Exercise.TestCase> testCases = new LinkedList<>();

        ArrayList<ArrayList<String>> data = new ArrayList<>();
        for (String line : lines) {
            String[] d = caseReader.read(line);
            if (d.length == 0)
                continue;

            data.add(translate(d));

            if (!caseReader.accumulate()) {
                testCases.add(new Exercise.TestCase(testCount++, data));
                data = new ArrayList<>();
            }
        }

        return new Exercise(Integer.parseInt(sNbTest), testCases);
    }


    private static ArrayList<String> translate(String[] d) {
        @SuppressWarnings("unchecked") ArrayList<String> t = new ArrayList(d.length);
        Arrays.stream(d).collect(Collectors.toCollection(() -> t));
        return t;
    }
}
