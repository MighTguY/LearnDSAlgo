package io.github.mightguy.medium;

/**
 * Longest Palindromic Substring Given a string s, return the longest palindromic substring in s.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "babad" Output: "bab" Note: "aba" is also a valid answer.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "cbbd" Output: "bb"
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "a" Output: "a"
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: s = "ac" Output: "a"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000 s consist of only digits and English letters (lower-case and/or
 * upper-case),
 * <p>
 * <p>
 * Related Topics String Dynamic Programming 👍 9528 👎 643
 */
public class Problem5 {

  /**
   * Success: Runtime:24 ms, faster than 79.59% of Java online submissions.
   * Memory Usage:39.3 MB,
   * less than 62.33% of Java online submissions.
   */
  public String longestPalindrome(String s) {
    if (s == null || s.length() < 1) {
      return "";
    }
    int start = 0, end = 0;
    for (int i = 0; i < s.length(); i++) {
      int len1 = expandAroundCenter(s, i, i);
      int len2 = expandAroundCenter(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > end - start) {
        start = i - (len - 1) / 2;
        end = i + len / 2;
      }
    }
    return s.substring(start, end + 1);
  }

  public int expandAroundCenter(String s, int left, int right) {
    int L = left, R = right;
    while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
      L--;
      R++;
    }
    return R - L - 1;
  }

  /**
   * Success: Runtime:298 ms, faster than 16.90% of Java online submissions. Memory Usage:121.5 MB,
   * less than 5.01% of Java online submissions.
   */
  public String longestPalindromeDP(String s) {
    int[][] dpArr = new int[s.length()][s.length()];
    int maxLength = 1;
    int left = 0, right = 0;
    for (int col = 0; col < s.length(); col++) {
      for (int row = 0; row <= col; row++) {
        if (col == row) {
          dpArr[row][col] = 1;
        } else if (col == row + 1) {
          dpArr[row][col] = (s.charAt(col) == s.charAt(row)) ? 1 : 0;
        } else if (dpArr[row + 1][col - 1] == 1 && s.charAt(col) == s.charAt(row)) {
          dpArr[row][col] = 1;
        } else {
          dpArr[row][col] = 0;
        }
        if (dpArr[row][col] == 1 && col - row + 1 >= maxLength) {
          maxLength = col - row + 1;
          left = row;
          right = col + 1;
        }
      }
    }
    if (maxLength == 0) {
      return "";
    }
    return s.substring(left, right);
  }
}
