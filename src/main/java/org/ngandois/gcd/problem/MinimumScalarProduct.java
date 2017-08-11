package org.ngandois.gcd.problem;

import org.ngandois.gcd.tools.CaseResolver;
import org.ngandois.gcd.tools.ExerciseResolver;
import org.ngandois.gcd.tools.InputSpaceParsing;
import org.ngandois.gcd.tools.SkipOneReadXCaseReader;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;


public class MinimumScalarProduct extends CaseResolver {

  public static void main(String[] args) throws IOException {
    MinimumScalarProduct solver = new MinimumScalarProduct();
    new ExerciseResolver("A-small-practice", solver).resolve();
  }

  public MinimumScalarProduct() {
    super(new SkipOneReadXCaseReader(2, new InputSpaceParsing()));
  }


  @Override
  public String solve(List<List<String>> data) {
    List<String> v1 = data.get(0);
    List<String> v2 = data.get(1);

    Integer[] sorted = v1.stream().map(Integer::parseInt).sorted().toArray(Integer[]::new);
    Integer[] reverse = v2.stream().map(Integer::parseInt).sorted(Comparator.reverseOrder()).toArray(Integer[]::new);

    BigInteger m = IntStream.range(0, v1.size())
      .mapToObj(i -> BigInteger.valueOf(sorted[i]).multiply(BigInteger.valueOf(reverse[i])))
      .reduce(BigInteger.ZERO, BigInteger::add);

    return String.valueOf(m);
  }
}
