package io.github.mightguy.easy;

import org.junit.Assert;
import org.junit.Test;

public class Problem14Test {

  @Test
  public void longestCommonPrefix() {
    Problem14 problem14 = new Problem14();
//    Assert.assertEquals("fl", problem14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//    Assert.assertEquals("flower", problem14.longestCommonPrefix(new String[]{"flower", "flowering"}));
    Assert.assertEquals("flo", problem14.longestCommonPrefix(new String[]{"flower","flo", "flowering"}));
  }
}