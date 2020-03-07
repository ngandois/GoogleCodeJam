package org.ngandois.gcd.online.troublesort;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i = 1; i <= t; ++i) {
      int[] numbers = new int[in.nextInt()];
      for (int j = 0; j < numbers.length; ++j) {
        numbers[j] = in.nextInt();
      }
      System.out.println("Case #" + i + ": " + solve(numbers));
    }
  }

  private static String solve(int[] numbers) {
    troubleSort(numbers);
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1])
        return String.valueOf(i);
    }
    return "OK";

  }

  private static void troubleSort(int[] L) {
    boolean done = false;
    while (!done) {
      done = true;
      for (int i = 0; i < L.length - 2; i++) {
        if (L[i] > L[i + 2]) {
          done = false;
          int tmp = L[i];
          L[i] = L[i + 2];
          L[i + 2] = tmp;
        }
      }
    }
  }

}


