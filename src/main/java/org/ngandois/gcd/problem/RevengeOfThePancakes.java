package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;


public class RevengeOfThePancakes extends CaseResolver {

  public static void main(String[] args) throws IOException {
    RevengeOfThePancakes solver = new RevengeOfThePancakes();
    new ExerciseResolver("B-large", solver).resolve();
  }

  private RevengeOfThePancakes() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }


  @Override
  public String solve(List<List<String>> data) {
    char[] chars = data.get(0).get(0).toCharArray();

    long step = 0;
    for (int i = 0; i < chars.length - 1; i++) {
      if (chars[i] != chars[i + 1]) {
        step++;
        for (int j = 0; j <= i; j++)
          chars[j] = chars[i + 1];
      }
    }

    if (chars[0] == '-') // we finished with all the stack on the wrong side: flip it
      step++;

    return String.valueOf(step);
  }
}