package org.ngandois.gcd.tools;

import java.io.IOException;
import java.util.function.Function;

public class ExerciseResolver {

    private final Function<Exercise.TestCase, Exercise.TestResult> solver;
    private final Exercise exercise;
    private final ResultWriter writer;

    public ExerciseResolver(String fileInput, Function<Exercise.TestCase, Exercise.TestResult> solver, CaseReader caseReader) throws IOException {
        this.solver = solver;

        exercise = ExerciseReader.createExercise(fileInput + ".in.txt", caseReader);

        String[] inputs = fileInput.split("/"); // reuse the file name only
        writer = new ResultWriter(exercise.nbCase, inputs[inputs.length - 1] + ".out.txt");
    }


    public void resolve() {
        long b = System.currentTimeMillis();
        exercise.cases.stream().map(solver).forEach((r) -> writer.write(r.testNumber, r.results));
        System.out.printf("took %dms to solve %d test cases\n", (System.currentTimeMillis() - b), exercise.nbCase);
    }
}
