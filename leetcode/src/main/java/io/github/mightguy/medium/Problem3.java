package io.github.mightguy.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without repeating c haracters.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Notice that
 * the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: s = "" Output: 0
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= s.length <= 5 * 104 s consists of English letters, digits, symbols and spaces.
 * <p>
 * Related Topics Hash Table Two Pointers String Sliding Window 👍 12816 👎 670
 */
public class Problem3 {

  /**
   * Success: Runtime:3 ms, faster than 91.76% of Java online submissions.
   * Memory Usage:41.1 MB,
   * less than 17.05% of Java online submissions.
   */
  public int lengthOfLongestSubstring(String s) {
    int[] charMap = new int[255];
    int ans = 0;
    for (int i = 0, j = 0; j < s.length(); j++) {
      if (charMap[s.charAt(j)] != 0) {
        i = Math.max(i, charMap[s.charAt(i)]);
      }
      ans = Math.max(ans, j - i + 1);
      charMap[s.charAt(j)] = j + 1;
    }
    return ans;
  }

  /**
   * Success: Runtime:9 ms, faster than 35.16% of Java online submissions.
   * Memory Usage:41.7 MB,
   * less than 12.16% of Java online submissions.
   */
  public int lengthOfLongestSubstringUsingMap(String s) {
    Map<Character, Integer> charMap = new HashMap<>();
    int ans = 0;
    for (int i = 0, j = 0; j < s.length(); j++) {
      Integer val = charMap.getOrDefault(s.charAt(j), null);
      if (val != null) {
        i = Math.max(i, val);
      }
      ans = Math.max(ans, j - i + 1);
      charMap.put(s.charAt(j), j + 1);
    }
    return ans;
  }
}
