package org.ngandois.gcd.MMXVI.qualif;

import org.ngandois.gcd.tools.*;

import java.io.IOException;
import java.util.OptionalLong;


public class C extends CaseResolver {

    public static void main(String[] args) throws IOException {
        C solver = new C();
        new ExerciseResolver("C-large", solver).resolve();

        /*
        large FAILEd with
        Exception in thread "main" java.lang.NumberFormatException: For input string: "10000000000000000000000000100001"
	        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	        at java.lang.Long.parseLong(Long.java:592)
	        at org.ngandois.gcd.MMXVI.qualif.C.getDivisor(C.java:65)
         */
    }

    private C() {
        super(new LineByLineCaseReader(new InputSpaceParsing()));
    }


    @Override
    public Exercise.TestResult solve(Exercise.TestCase c) {
        StringBuilder result = new StringBuilder();
        int N = Integer.parseInt(c.data.get(0).get(0));
        int J = Integer.parseInt(c.data.get(0).get(1));

        String coin = "";
        if (N == 6)
            coin = "100001";
        if (N == 16)
            coin = "1000000000000001";
        if (N == 32)
            coin = "10000000000000000000000000000001";

        int nbCoin = 0; // will start with the initial one

        while (nbCoin < J) {
            StringBuilder buf = new StringBuilder();
            int nbDivisor = 0;
            for (int base = 2; base <= 10; base++) {
                OptionalLong divisor = getDivisor(coin, base);
                if (divisor.isPresent()) {
                    nbDivisor++;
                    buf.append(divisor.getAsLong()).append(" ");
                } else
                    break; // at least a divisor is missing
            }

            if (nbDivisor == 9) { // we got one
                buf.setLength(buf.length() - 1); // remove the last space
                result.append("\n").append(coin).append(" ").append(buf);
                nbCoin++;
            }

            //try next one
            long nextCoin = Long.parseLong(coin, 2);
            nextCoin += 2;
            coin = Long.toString(nextCoin, 2);
        }

        return new Exercise.TestResult(c.testNumber, result.toString());
    }

    private OptionalLong getDivisor(String coin, int radix) {
        long value = Long.parseLong(coin, radix);

        if (value % 2 == 0)
            OptionalLong.of(2);

        // 2 is not a divisor so try odd divisors
        // but no need to go above the square root (symmetric point of divisors)
        long sqrt = (long) Math.sqrt(value);

        for (double i = 3; i <= sqrt; i = i + 2) {
            if (value % i == 0)
                return OptionalLong.of((long) i);
        }

        return OptionalLong.empty();
    }
}