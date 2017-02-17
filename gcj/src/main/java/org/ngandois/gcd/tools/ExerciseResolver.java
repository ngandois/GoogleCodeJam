package org.ngandois.gcd.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ExerciseResolver {

    private static final Logger log = LogManager.getLogger(ExerciseResolver.class);

    private final Exercise exercise;
    private final ResultWriter writer;
    private final CaseResolver caseResolver;


    public ExerciseResolver(String fileInput, CaseResolver caseResolver) throws IOException {
        this.caseResolver = caseResolver;
        exercise = ExerciseReader.createExercise(fileInput + ".in.txt", caseResolver.getReader());
        writer = new ResultWriter(exercise.getNbCases(), fileInput + ".out.txt");
    }


    public void resolve() {
        long b = System.currentTimeMillis();
        exercise.cases.parallelStream().map(caseResolver).forEach(writer);

        if (writer.hasReceivedError())
            log.fatal("!!! error(s) received, check logs and/or output file !!!");
        else
            log.info("took {}s to solve {} test cases", MILLISECONDS.toSeconds(System.currentTimeMillis() - b), exercise.getNbCases());
    }
}
