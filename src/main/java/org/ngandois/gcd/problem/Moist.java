package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputNoParsing;
import org.ngandois.gcd.tools.ReadNbLineFirstCaseReader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Moist extends CaseResolver {

  public static void main(String[] args) throws IOException {
    Moist solver = new Moist();
    new ExerciseResolver("C-small-practice-1", solver).resolve();
    new ExerciseResolver("C-small-practice-2", solver).resolve();
  }

  public Moist() {
    super(new ReadNbLineFirstCaseReader(new InputNoParsing()));
  }

  @Override
  public String solve(List<List<String>> data) {
    List<String> cards = data.stream().map(l -> l.get(0)).collect(Collectors.toList());


    int cost = 0;
    String higherName = cards.get(0);
    for (int i = 1; i < cards.size(); i++) {
      if (higherName.compareTo(cards.get(i)) < 0)
        higherName = cards.get(i);
      else
        cost++;

    }


    return String.valueOf(cost);
  }


}
