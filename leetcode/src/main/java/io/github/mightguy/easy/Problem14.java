package io.github.mightguy.easy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: strs = ["flower","fl","flow","flight", "flowering] Output: "fl"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no common prefix among the
 * input strings.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i] consists of only lower-case English
 * letters.
 * <p>
 * Related Topics String 👍 3604 👎 2101
 */
public class Problem14 {

  public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0 ) {
      return "";
    }
    String first = strs[0];
    for (int i = 0; i < strs[0].length(); i++) {
      char ch = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (i == strs[j].length() || ch != strs[j].charAt(i)) {
          return first.substring(0, i);
        }
      }
    }
    return strs[0];
  }

}
