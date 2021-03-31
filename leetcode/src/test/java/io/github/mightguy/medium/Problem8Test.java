package io.github.mightguy.medium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Problem8Test {

  @Test
  public void myAtoi() {
    Problem8 problem8 = new Problem8();
    Assert.assertEquals(-42, problem8.myAtoi("   -42"));
    Assert.assertEquals(0, problem8.myAtoi("words and 987"));
    Assert.assertEquals(0, problem8.myAtoi("words and -987"));
    Assert.assertEquals(0, problem8.myAtoi("words and +987"));
    Assert.assertEquals(Integer.MIN_VALUE, problem8.myAtoi("-91283472332"));
    Assert.assertEquals(Integer.MAX_VALUE, problem8.myAtoi("212371237129731923"));
    Assert.assertEquals(424, problem8.myAtoi(" 424 asdasd "));
  }
}