package io.github.mightguy.easy;

/**
 * Palindrome Number
 */
public class Problem9_Palindrome_Number {

  public boolean isPalindrome(int x) {

    int reverse = 0;
    while (x > reverse) {
      reverse = reverse * 10 + x % 10;
      x = x / 10;
    }
    return (reverse == x) || (reverse / 10 == x);
  }
}
