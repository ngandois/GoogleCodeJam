package org.ngandois.gcd.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * Created by ngandois on 19/04/15.
 */
public class ExerciseReader {


    public static Exercise retrieveData(String year, String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(year +"/resources", fileName));

        String sNbTest = lines.remove(0);
        final AtomicInteger i = new AtomicInteger(-1);
        List<Exercise.TestCase> cases = lines.stream().map(l -> new Exercise.TestCase(i.incrementAndGet(), l)).collect(Collectors.toList());
        return new Exercise(Integer.parseInt(sNbTest), cases);
    }
}
