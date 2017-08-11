package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;


public class TheLastWord extends CaseResolver {

  public static void main(String[] args) throws IOException {
    TheLastWord solver = new TheLastWord();
    new ExerciseResolver("A-large-practice", solver).resolve();
  }

  public TheLastWord() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }


  @Override
  public String solve(List<List<String>> data) {
    char[] chars = data.get(0).get(0).toCharArray();

    StringBuilder buf = new StringBuilder(chars.length);
    buf.append(chars[0]);

    for (int i = 1; i < chars.length; i++) {
      if (chars[i] >= buf.charAt(0))
        buf.insert(0, chars[i]);
      else
        buf.append(chars[i]);
    }

    return buf.toString();
  }
}
