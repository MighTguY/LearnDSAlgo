package io.github.mightguy.medium;

/**
 * String to Integer (atoi) Implement the myAtoi(string s) function, which converts a string to a
 * 32-bit s igned integer (similar to C/C++'s atoi function).
 * <p>
 * The algorithm for myAtoi(string s) is as follows:
 * <p>
 * <p>
 * Read in and ignore any leading whitespace. Check if the next character (if not already at the end
 * of the string) is '-' or '+'. Read this character in if it is either. This determines if the
 * final res ult is negative or positive respectively. Assume the result is positive if neith er is
 * present. Read in next the characters until the next non-digit charcter or the end of t he input
 * is reached. The rest of the string is ignored. Convert these digits into an integer (i.e. "123"
 * -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as
 * necessary (from ste p 2). If the integer is out of the 32-bit signed integer range [-231, 231 -
 * 1], the n clamp the integer so that it remains in the range. Specifically, integers less than
 * -231 should be clamped to -231, and integers greater than 231 - 1 should b e clamped to 231 - 1.
 * Return the integer as the final result.
 * <p>
 * <p>
 * Note:
 * <p>
 * <p>
 * Only the space character ' ' is considered a whitespace character. Do not ignore any characters
 * other than the leading whitespace or the rest of the string after the digits.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "42" Output: 42 Explanation: The underlined characters are what is read in, the caret
 * is the c urrent reader position. Step 1: "42" (no characters read because there is no leading
 * whitespace) ^ Step 2: "42" (no characters read because there is neither a '-' nor '+') ^ Step 3:
 * "42" ("42" is read in) ^ The parsed integer is 42. Since 42 is in the range [-231, 231 - 1], the
 * final result is 42.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "   -42" Output: -42 Explanation: Step 1: "   -42" (leading whitespace is read and
 * ignored) ^ Step 2: "   -42" ('-' is read, so the result should be negative) ^ Step 3: "   -42"
 * ("42" is read in) ^ The parsed integer is -42. Since -42 is in the range [-231, 231 - 1], the
 * final result is -42.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "4193 with words" Output: 4193 Explanation: Step 1: "4193 with words" (no characters
 * read because there is no leading whit espace) ^ Step 2: "4193 with words" (no characters read
 * because there is neither a '-' n or '+') ^ Step 3: "4193 with words" ("4193" is read in; reading
 * stops because the next c haracter is a non-digit) ^ The parsed integer is 4193. Since 4193 is in
 * the range [-231, 231 - 1], the final result is 4193.
 * <p>
 * <p>
 * Example 4:
 * <p>
 * <p>
 * Input: s = "words and 987" Output: 0 Explanation: Step 1: "words and 987" (no characters read
 * because there is no leading whites pace) ^ Step 2: "words and 987" (no characters read because
 * there is neither a '-' nor '+') ^ Step 3: "words and 987" (reading stops immediately because
 * there is a non-digi t 'w') ^ The parsed integer is 0 because no digits were read. Since 0 is in
 * the range [-231, 231 - 1], the final result is 0.
 * <p>
 * <p>
 * Example 5:
 * <p>
 * <p>
 * Input: s = "-91283472332" Output: -2147483648 Explanation: Step 1: "-91283472332" (no characters
 * read because there is no leading whitesp ace) ^ Step 2: "-91283472332" ('-' is read, so the
 * result should be negative) ^ Step 3: "-91283472332" ("91283472332" is read in) ^ The parsed
 * integer is -91283472332. Since -91283472332 is less than the lower bound of the range [-231, 231
 * - 1], the final result is clamped to -231 = -2147483648.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 0 <= s.length <= 200 s consists of English letters (lower-case and upper-case), digits (0-9), '
 * ', '+', '-', and '.'.
 * <p>
 * Related Topics Math String 👍 0 👎 0 https://leetcode.com/problems/string-to-integer-atoi/
 */
public class Problem8 {

  public int myAtoi(String s) {
    int signVal = 1;
    int result = 0;
    boolean isStarted = false;
    s = s.trim();
    if (s.length() == 0) {
      return 0;
    }

    for (char ch : s.toCharArray()) {
      if (ch >= '0' && ch <= '9') {
        isStarted = true;
        int val = ch - '0';
        if (signVal == 1 && ((val > 7 && result == Integer.MAX_VALUE / 10)
            || result > Integer.MAX_VALUE / 10)) {
          return Integer.MAX_VALUE;
        }
        if (signVal == -1 && ((val * signVal < -8 && result * signVal == Integer.MIN_VALUE / 10)
            || result * signVal < Integer.MIN_VALUE / 10)) {
          return Integer.MIN_VALUE;
        }
        result = result * 10 + val;
      } else if (ch == '-' && !isStarted) {
        isStarted = true;
        signVal = -1;
      } else if (ch == '+' && !isStarted) {
        isStarted = true;
        signVal = 1;
      } else if (ch == 32 && !isStarted) {
        continue;
      } else {
        break;
      }
    }
    return result * signVal;
  }

  public int myAtoi2(String s) {
    Long val = 0L;
    boolean isNeg = false;
    boolean isStarted = false;

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) - '0' <= 9 && s.charAt(i) - '0' >= 0) {
        isStarted = true;
        val = (long) 10 * val + (s.charAt(i) - '0');
        if (val >= Integer.MAX_VALUE) {
          break;
        }
      } else if (s.charAt(i) == '-' && !isStarted) {
        isStarted = true;
        isNeg = true;
      } else if (s.charAt(i) == '+' && !isStarted) {
        isStarted = true;
        isNeg = false;
      } else if (s.charAt(i) == 32 && !isStarted) {
        continue;
      } else {
        break;
      }
    }

    if (!isNeg && val >= Integer.MAX_VALUE) {
      return Integer.MAX_VALUE;
    }

    if (isNeg && val * -1 <= Integer.MIN_VALUE) {
      return Integer.MIN_VALUE;
    }

    return (isNeg) ? -1 * val.intValue() : val.intValue();
  }
}
