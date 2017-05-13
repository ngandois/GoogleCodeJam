package org.ngandois.gcd.problem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.ReadNbLineFirstCaseReader;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RankAndFile extends CaseResolver {

  private static final Logger log = LogManager.getLogger(CaseResolver.class);


  public static void main(String[] args) throws IOException {
    RankAndFile solver = new RankAndFile();
    new ExerciseResolver("B-small-practice", solver).resolve();
    new ExerciseResolver("B-large-practice", solver).resolve();
  }

  public RankAndFile() {
    super(new ReadNbLineFirstCaseReader(2, -1, new InputSpaceParsing()));
  }

  @Override
  public String solve(List<List<String>> data) {
    // as a number will be in a row and a column we must have it % 2 times
    // else it's a missing number
    // keep them and sort them
    StringJoiner joiner = new StringJoiner(" ");
    data
      .stream()
      .flatMap(Collection::stream)
      .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
      .entrySet().stream()
      .filter(e -> e.getValue() % 2 != 0)
      .map(e -> Integer.parseInt(e.getKey()))
      .sorted()
      .map(String::valueOf)
      .forEach(joiner::add);


    return joiner.toString();
  }


}
