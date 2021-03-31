package io.github.mightguy.medium;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Problem6Test {

  @Test
  public void convert() {
    Problem6 problem6 = new Problem6();
    Assert.assertEquals("PAHNAPLSIIGYIR", problem6.convert("PAYPALISHIRING", 3));
  }
}