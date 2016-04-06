package org.ngandois.gcd.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Function;

public class ExerciseResolver {

    private final Exercise exercise;
    private final ResultWriter writer;
    private final CaseResolver caseResolver;


    public ExerciseResolver(String fileInput, CaseResolver caseResolver) throws IOException {
        this.caseResolver = caseResolver;
        exercise = ExerciseReader.createExercise(fileInput + ".in.txt", caseResolver.getReader());
        writer = new ResultWriter(exercise.nbCase, fileInput + ".out.txt");
    }


    public void resolve() {
        long b = System.currentTimeMillis();
        exercise.cases.stream().map((c) -> {System.out.println("solving " + c); return caseResolver.apply(c);}).forEach((r) -> writer.write(r.testNumber, r.results));
        System.out.printf("took %dms to solve %d test cases\n", (System.currentTimeMillis() - b), exercise.nbCase);
    }
}
