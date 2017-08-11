package org.ngandois.gcd;

import org.junit.Test;
import org.ngandois.gcd.problem.BadHorse;
import org.ngandois.gcd.tools.ExerciseResolver;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiLinesInputTest {

  @Test
  public void executeAndCheckOutput() throws IOException {
    new ExerciseResolver("MultiLinesInputTest", new BadHorse()).resolve();

    File refFile = new File("src/test/resources/MultiLinesInputTest.out-reference.txt");
    File expectedFile = new File("exercise-output/MultiLinesInputTest.out.txt");
    assertThat(refFile).hasSameContentAs(expectedFile);
  }
}


