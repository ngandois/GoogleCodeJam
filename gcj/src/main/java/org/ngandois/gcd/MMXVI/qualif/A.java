package org.ngandois.gcd.MMXVI.qualif;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class A extends CaseResolver {

  public static void main(String[] args) throws IOException {
    A solver = new A();
    new ExerciseResolver("A-large", solver).resolve();
  }

  private A() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }


  @Override
  public String solve(List<List<String>> data) {
    Set<Character> seen = new HashSet<>();
    int i = 0;
    long N = Long.parseLong(data.get(0).get(0));
    long current = 0;
    long previous = -1;

    while (seen.size() < 10) {

      if (previous == current || current < 0)
        return "INSOMNIA";

      previous = current;

      current = N * (1 + i++);
      char[] chars = String.valueOf(current).toCharArray();
      for (char aChar : chars) seen.add(aChar);
    }

    return String.valueOf(current);
  }
}
