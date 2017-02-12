package org.ngandois.gcd.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ExerciseResolver {

    private static final Logger log = LogManager.getLogger(ExerciseResolver.class);

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
        }).forEach(writer::write);
        log.info("took {}s to solve {} test cases", SECONDS.convert(System.currentTimeMillis() - b, MILLISECONDS), exercise.nbCase);
    }
}
