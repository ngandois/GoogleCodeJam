package org.ngandois.gcd.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ExerciseReader {

    private static final String resourcesPath = "src/main/resources/";
    private static final String testResourcesPath = "src/test/resources/";

    public static Exercise createExercise(String fileName, CaseReader caseReader) throws IOException {
        Path p = Paths.get(resourcesPath, fileName);
        if(!Files.exists(p))
            p = Paths.get(testResourcesPath, fileName);

        List<String> lines = Files.readAllLines(p);

        lines.remove(0); // nb tests
        int testCount = 1;

        List<Exercise.TestCase> testCases = new LinkedList<>();

        List<List<String>> data = new ArrayList<>();
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

        return new Exercise(testCases);
    }


    private static List<String> translate(String[] d) {
        return Arrays.stream(d).collect(Collectors.toList());
    }
}
