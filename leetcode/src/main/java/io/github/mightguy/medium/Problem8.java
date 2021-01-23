package io.github.mightguy.medium;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Problem8 {

  public int myAtoi(String s) {
    Long val = 0L;
    boolean isNeg = false;
    boolean isStarted = false;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
        isStarted = true;
        val = (long) 10 * val + (s.charAt(i) - '0');
        if (val >= Integer.MAX_VALUE) {
          break;
        }
      } else if (s.charAt(i) == '-' && !isStarted) {
        isStarted = true;
        isNeg = true;
      } else if (s.charAt(i) == '+' && !isStarted) {
        isStarted = true;
        isNeg = false;
      } else if (s.charAt(i) == 32 && !isStarted) {
        continue;
      } else {
        break;
      }
    }

    if (!isNeg && val >= Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    if (isNeg && val * -1 <= Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (isNeg) ? -1 * val.intValue() : val.intValue();
  }

  public static void main(String[] args) {
    Problem8 problem8 = new Problem8();
    System.out.println(problem8.myAtoi("   -42"));
  }
}
