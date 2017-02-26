package org.ngandois.gcd.MMXV.qualif;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.LineByLineCaseReader;

import java.io.IOException;
import java.util.List;


public class A extends CaseResolver {

  public static void main(String[] args) throws IOException {
    A solver = new A();
    new ExerciseResolver("A-small-practice", solver).resolve();
    new ExerciseResolver("A-large-practice", solver).resolve();
  }

  public A() {
    super(new LineByLineCaseReader(new InputSpaceParsing()));
  }


  @Override
  public String solve(List<List<String>> data) {
    int nbStandUp = 0;
    int nbToInvite = 0;

    List<String> d = data.get(0);

    int maxShyness = Integer.parseInt(d.get(0));
    char[] people = d.get(1).toCharArray();

    for (int shynessCursor = 0; (shynessCursor < people.length) && (nbStandUp + nbToInvite < maxShyness); shynessCursor++) {
      int nextNbStandUp = Character.getNumericValue(people[shynessCursor]);

      if (nbStandUp + nbToInvite < shynessCursor) {
        nbToInvite += shynessCursor - (nbStandUp + nbToInvite);
      }

      nbStandUp += nextNbStandUp;
    }

    return String.valueOf(nbToInvite);
  }
}
