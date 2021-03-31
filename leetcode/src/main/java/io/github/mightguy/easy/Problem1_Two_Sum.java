package io.github.mightguy.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum
 */
public class Problem1_Two_Sum {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{i, map.get(complement)};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("Not found");
  }
}
