package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.DoubleFormat;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;


public class CaptainHammer extends CaseResolver {

  public static void main(String[] args) throws IOException {
    CaptainHammer solver = new CaptainHammer();
    new ExerciseResolver("B-small-practice", solver).resolve();
  }

  public CaptainHammer() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }

  @Override
  // https://fr.wikipedia.org/wiki/Balistique
  public String solve(List<List<String>> data) {
    double v = Double.parseDouble(data.get(0).get(0));
    double d = Double.parseDouble(data.get(0).get(1));


    double a = (d * 9.8) / (v * v);

    // as said by Google all inputs are valid, so having to perform asin > 1 means a double precision issue (so cap at 1)
    //if (a > 1) a = 1;

    double degrees = Math.toDegrees(0.5 * Math.asin(a));

    return DoubleFormat.format(degrees);
  }


}
