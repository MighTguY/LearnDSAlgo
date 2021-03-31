package io.github.mightguy.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ZigZag Conversion The string "PAYPALISHIRING" is written in a zigzag pattern on a given number o
 * f rows like this: (you may want to display this pattern in a fixed font for bett er legibility)
 * <p>
 * <p>
 * P   A   H   N A P L S I I G Y   I   R
 * <p>
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a numbe r of rows:
 * <p>
 * <p>
 * string convert(string s, int numRows);
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3 Output: "PAHNAPLSIIGYIR"
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4 Output: "PINALSIGYAHRPI" Explanation: P     I    N A   L
 * S  I G Y A   H R P     I
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "A", numRows = 1 Output: "A"
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 1000 s consists of English letters (lower-case and upper-case), ',' and '.'. 1
 * <= numRows <= 1000
 * <p>
 * Related Topics String 👍 2138 👎 5430
 */
public class Problem6 {

  public String convert(String s, int numRows) {
    if (numRows == 1) {
      return s;
    }
    List<StringBuilder> rows = new ArrayList<>();

    for (int i = 0; i < Math.min(numRows, s.length()); i++) {
      rows.add(new StringBuilder());
    }

    int crrRow = 0;
    boolean goingDown = false;
    for (char c : s.toCharArray()) {
      rows.get(crrRow).append(c);
      if (crrRow == 0 || crrRow == numRows - 1) {
        goingDown = !goingDown;
      }
      crrRow += goingDown ? 1 : -1;
    }
    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) {
      ret.append(row);
    }
    return ret.toString();
  }
}
