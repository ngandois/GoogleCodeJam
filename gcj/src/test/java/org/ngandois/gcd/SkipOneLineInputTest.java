package org.ngandois.gcd;

import org.junit.Test;
import org.ngandois.gcd.MMVIII.round.one.A.A;
import org.ngandois.gcd.tools.ExerciseResolver;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class SkipOneLineInputTest {

  @Test
  public void executeAndCheckOutput() throws IOException {
    new ExerciseResolver("SkipOneLineInputTest", new A()).resolve();

    File refFile = new File("src/test/resources/SkipOneLineInputTest.out-reference.txt");
    File expectedFile = new File("exercise-output/SkipOneLineInputTest.out.txt");
    assertThat(refFile).hasSameContentAs(expectedFile);
  }
}


