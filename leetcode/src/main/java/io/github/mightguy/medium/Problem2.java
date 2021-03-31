package io.github.mightguy.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integer s. The digits are
 * stored in reverse order, and each of their nodes contains a si ngle digit. Add the two numbers
 * and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the nu mber 0 itself.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] Explanation: 342 + 465 = 807.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: l1 = [0], l2 = [0] Output: [0]
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in each linked list is in the range [1, 100]. 0 <= Node.val <= 9 It is
 * guaranteed that the list represents a number that does not have leading zeros.
 * <p>
 * Related Topics Linked List Math Recursion 👍 10575 👎 2586
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */
public class Problem2 {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int carry = 0;
    ListNode l3 = new ListNode(0);
    ListNode l3Head = l3;

    while (l1 != null || l2 != null) {
      int l1Val = (l1 == null) ? 0 : l1.val;
      int l2Val = (l2 == null) ? 0 : l2.val;
      int val = l1Val + l2Val + carry;
      carry = val / 10;
      l3.next = new ListNode(val % 10);
      l3 = l3.next;
      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }
    if (carry != 0) {
      l3.next = new ListNode(carry);
    }
    return l3Head.next;
  }
}
