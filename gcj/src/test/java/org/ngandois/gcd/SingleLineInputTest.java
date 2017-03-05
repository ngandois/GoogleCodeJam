package org.ngandois.gcd;

import org.junit.Test;
import org.ngandois.gcd.problem.StandingOvation;
import org.ngandois.gcd.tools.ExerciseResolver;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleLineInputTest {

  @Test
  public void executeAndCheckOutput() throws IOException {
    new ExerciseResolver("SingleLineInputTest", new StandingOvation()).resolve();

    File refFile = new File("src/test/resources/SingleLineInputTest.out-reference.txt");
    File expectedFile = new File("exercise-output/SingleLineInputTest.out.txt");
    assertThat(refFile).hasSameContentAs(expectedFile);
  }
}


