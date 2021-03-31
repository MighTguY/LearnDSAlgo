package io.github.mightguy.medium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Problem5Test {

  @Test
  public void longestPalindrome() {
    Problem5 problem5 = new Problem5();
    Assert.assertEquals("aba", problem5.longestPalindrome("babad"));
    Assert.assertEquals("bb", problem5.longestPalindrome("cbbd"));
    Assert.assertEquals("c", problem5.longestPalindrome("ac"));
    Assert.assertEquals("a", problem5.longestPalindrome("a"));
  }
}