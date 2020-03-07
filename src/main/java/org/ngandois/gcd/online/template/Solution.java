package org.ngandois.gcd.online.template;


import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      System.out.println("Case #" + i + ": " + solve(n));
    }
  }

  private static String solve(int n) {
    return "" + n * 2;

  }

}


