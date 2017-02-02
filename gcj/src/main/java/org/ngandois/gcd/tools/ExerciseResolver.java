package org.ngandois.gcd.tools;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ngandois.gcd.MMXVI.university.practice.A;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExerciseResolver {

    private static final Logger log = LogManager.getLogger(A.class);

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
        exercise.cases.stream().map((c) -> {
            log.info("solving #{}", c.testNumber);
            return caseResolver.apply(c);
        }).forEach((r) -> writer.write(r.testNumber, r.results));
        log.info("took {}s to solve {} test cases", SECONDS.convert(System.currentTimeMillis() - b, MILLISECONDS), exercise.nbCase);
    }
}
