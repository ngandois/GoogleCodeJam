package org.ngandois.gcd;

import org.junit.Test;
import org.ngandois.gcd.MMXV.qualif.A.A;
import org.ngandois.gcd.tools.CaseReader;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class OneTestByLineTest {

    @Test
    public void executeAndCheckOutput() throws IOException {
        A solver = new A();
        CaseReader reader = new LineByLineCaseReader(new InputSpaceParsing());
        new ExerciseResolver("src/test/resources/OneTestByLineTest", solver, reader).resolve();

        File refFile = new File("src/test/resources/OneTestByLineTest.out-reference.txt");
        File expectedFile = new File("exercise-output/OneTestByLineTest.out.txt");
        assertThat(refFile).hasSameContentAs(expectedFile);
    }
}

