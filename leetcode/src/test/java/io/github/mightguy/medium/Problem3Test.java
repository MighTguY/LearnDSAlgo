package io.github.mightguy.medium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Problem3Test {

  @Test
  public void lengthOfLongestSubstring() {
    Problem3 problem3 = new Problem3();

    Assert.assertEquals(3,problem3.lengthOfLongestSubstring("abcabcbb") );
    Assert.assertEquals(1,problem3.lengthOfLongestSubstring("bbbbb") );
    Assert.assertEquals(3,problem3.lengthOfLongestSubstring("pwwkew") );
  }
}