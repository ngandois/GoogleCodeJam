package org.ngandois.gcd.problem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.SkipOneReadXCaseReader;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class SenateEvacuation extends CaseResolver {

  private static final Logger log = LogManager.getLogger(SenateEvacuation.class);


  public static void main(String[] args) throws IOException {
    CaseResolver solver = new SenateEvacuation();
    new ExerciseResolver("A-small-practice", solver).resolve();
    new ExerciseResolver("A-large-practice", solver).resolve();
  }

  public SenateEvacuation() {
    super(new SkipOneReadXCaseReader(1, new InputSpaceParsing()));
  }

  @Override
  public String solve(List<List<String>> data) {
    List<String> rawData = data.get(0);

    List<String> parties = new LinkedList<>();
    for (int i = 0; i < rawData.size(); i++) {
      int nb = Integer.parseInt(rawData.get(i));
      int a = 'A';
      int cInt = a + i;
      char c = (char) cInt;

      StringBuilder tmp = new StringBuilder();
      for (int j = 0; j < nb; j++) {
        tmp.append(c);
      }

      parties.add(tmp.toString());
    }

    StringJoiner joiner = new StringJoiner(" ");

    // we know that all test cases are correct so at the beginning there is no majority
    // and at the end it will not too (so can escape all the remaining)

    while (parties.size() > 2) { // escape one by one the most representative party until only two remains
      parties.sort(Comparator.comparingInt(String::length));
      String party = parties.remove(parties.size() - 1);
      joiner.add(String.valueOf(party.charAt(0)));
      String p = party.substring(1);
      if (p.length() != 0)
        parties.add(p);
    }

    if (parties.size() == 2) { // only two parties remains escape one of each each time
      String party1 = parties.remove(0);
      String senator1 = party1.substring(0, 1);
      String senator2 = parties.remove(0).substring(0, 1);

      for (int i = 0; i < party1.length(); i++) {
        joiner.add(senator1 + senator2);
      }
    }


    if (parties.size() == 1) { // only one remains escape all of them
      joiner.add(parties.remove(0));
    }

    return joiner.toString();
  }
}
