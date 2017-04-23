package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;

public class OversizedPancakeFlipper extends CaseResolver {


  public static void main(String[] args) throws IOException {
    CaseResolver solver = new OversizedPancakeFlipper();
    new ExerciseResolver("A-small-practice", solver).resolve();
    new ExerciseResolver("A-large-practice", solver).resolve();
  }

  public OversizedPancakeFlipper() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }

  @Override
  public String solve(List<List<String>> data) {
    StringBuilder pancakes = new StringBuilder(data.get(0).get(0));
    int flipperSize = Integer.parseInt(data.get(0).get(1));

    int i = 0;
    int nbFlip = 0;
    while (true) {

      i = pancakes.indexOf("-", i);
      if (i >= 0 && i + flipperSize <= pancakes.length()) {
        nbFlip++;
        flip(pancakes, i, flipperSize);
      } else
        break;
    }


    return pancakes.indexOf("-", 0) == -1 ? String.valueOf(nbFlip) : "IMPOSSIBLE";
  }

  private void flip(StringBuilder pancakes, int pos, int nbTimes) {
    for (int i = 0; i < nbTimes; i++) {
      char current = pancakes.charAt(pos + i);
      if (current == '-')
        pancakes.setCharAt(pos + i, '+');
      else
        pancakes.setCharAt(pos + i, '-');
    }
  }
}
