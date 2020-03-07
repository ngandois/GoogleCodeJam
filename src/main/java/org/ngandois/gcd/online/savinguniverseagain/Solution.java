package org.ngandois.gcd.online.savinguniverseagain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int shield = in.nextInt();
      String str = in.next();
      System.out.println("Case #" + i + ": " + solve(shield, str));
    }
  }

  private static String solve(int shield, String str) {

    char[] chars = str.toCharArray();
    int swap = 0;

    do {
      long laserStrength = 1;
      long damage = 0;
      for (char c : chars) {
        if (c == 'S') {
          damage += laserStrength;
        } else {
          laserStrength *= 2;
        }
      }

      if (damage <= shield)
        return String.valueOf(swap);

      else {
        boolean invert = false;
        for (int i = chars.length - 1; i >= 1 && !invert; i--) {
          if (chars[i] == 'S' && chars[i - 1] == 'C') {
            chars[i] = 'C';
            chars[i - 1] = 'S';
            swap++;
            invert = true;
          }
        }

        if (!invert)
          return "IMPOSSIBLE";
      }
    }
    while (true);
  }
}
