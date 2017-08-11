package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;

public class TidyNumbers extends CaseResolver {


  public static void main(String[] args) throws IOException {
    CaseResolver solver = new TidyNumbers();
    new ExerciseResolver("B-small-practice", solver).resolve();
    new ExerciseResolver("B-large-practice", solver).resolve();
  }

  public TidyNumbers() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }

  @Override
  public String solve(List<List<String>> data) {
    StringBuilder number = new StringBuilder(data.get(0).get(0));

    while (true) {
      int pos = notTidyPosition(number);

      if (pos >= 0) {
        pos = substract(number, pos);
        fill(number, pos);
      } else
        break;
    }


    return number.toString();
  }

  private int notTidyPosition(StringBuilder n) {
    for (int i = 0; i < n.length() - 1; i++) {
      if (n.charAt(i) > n.charAt(i + 1))
        return i;
    }

    return -1;
  }

  private int substract(StringBuilder number, int pos) {
    char c = number.charAt(pos);

    if (pos == 0 && c == '1') {
      number.deleteCharAt(0);
      return pos;
    } else {
      number.setCharAt(pos, (char) (c - 1));
      return pos + 1;
    }
  }

  private void fill(StringBuilder number, int pos) {
    for (int i = pos; i < number.length(); i++)
      number.setCharAt(i, '9');
  }

}
