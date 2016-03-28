package org.ngandois.gcd.tools;

import java.io.IOException;
import java.util.function.Function;

public class ExerciseResolver {

    private final Function<Exercise.TestCase, Exercise.TestResult> solver;
    private final Exercise exercise;
    private final ResultWriter writer;

    public ExerciseResolver(String caseName, boolean isSmallInput, Function<Exercise.TestCase, Exercise.TestResult> solver, CaseReader caseReader) throws IOException {
        this(caseName, isSmallInput, "", solver, caseReader);
    }

    public ExerciseResolver(String caseName, boolean isSmallInput, String caseSuffix, Function<Exercise.TestCase, Exercise.TestResult> solver, CaseReader caseReader) throws IOException {
        this.solver = solver;

        String exerciseType = isSmallInput ? "small" : "large";
        exercise = ExerciseReader.createExercise(caseName + "-" + exerciseType + "-practice" + caseSuffix + ".in.txt", caseReader);
        writer = new ResultWriter(exercise.nbCase, caseName + "-" + exerciseType + "-practice" + caseSuffix + ".out.txt");
    }

    public void resolve() {
        long b = System.currentTimeMillis();
        exercise.cases.stream().map(solver).forEach((r) -> writer.write(r.testNumber, r.results));
        System.out.printf("took %dms to solve %d test cases\n", (System.currentTimeMillis() - b), exercise.nbCase);
    }
}
