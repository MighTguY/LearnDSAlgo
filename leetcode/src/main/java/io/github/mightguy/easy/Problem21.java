package io.github.mightguy.easy;

/**
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4] Output: [1,1,2,3,4,4]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: l1 = [], l2 = [] Output: []
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: l1 = [], l2 = [0] Output: [0]
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * The number of nodes in both lists is in the range [0, 50]. -100 <= Node.val <= 100 Both l1 and l2
 * are sorted in non-decreasing order.
 * <p>
 * Related Topics Linked List Recursion 👍 5982 👎 712
 */

public class Problem21 {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode merged = new ListNode(0);
    ListNode mergedHead = merged;

    while (l1 != null && l2 != null) {

      if (l1.val > l2.val) {
        merged.next = new ListNode(l2.val);
        l2 = l2.next;
      } else {
        merged.next = new ListNode(l1.val);
        l1 = l1.next;
      }
      merged = merged.next;
    }

    merged.next = (l1 != null) ? l1 : l2;
    return mergedHead.next;
  }
}
