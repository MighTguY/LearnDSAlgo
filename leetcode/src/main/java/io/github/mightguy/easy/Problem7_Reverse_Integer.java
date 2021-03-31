package io.github.mightguy.easy;

/*
Reverse Integer
 */
public class Problem7_Reverse_Integer {

  public int reverse(int x) {
    int reverse = 0;
    while (x != 0) {
      int rem = x % 10;
      x = x / 10;
      if ((rem > 7 && reverse == Integer.MAX_VALUE / 10) || reverse > Integer.MAX_VALUE / 10) {
        return 0;
      }
      if ((rem < -8 && reverse == Integer.MIN_VALUE / 10) || reverse < Integer.MIN_VALUE / 10) {
        return 0;
      }
      reverse = reverse * 10 + rem;
    }
    return reverse;
  }

}
