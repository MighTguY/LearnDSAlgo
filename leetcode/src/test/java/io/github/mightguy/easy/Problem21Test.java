package io.github.mightguy.easy;

import static org.junit.Assert.*;


import io.github.mightguy.easy.Problem21.ListNode;
import io.github.mightguy.medium.Problem2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.junit.Test;

public class Problem21Test {

  public ListNode listNode(String numList) {
    List<Integer> arr = Arrays.asList(numList.split(",")).stream().map(Integer::parseInt).collect(
        Collectors.toList());
    ListNode l1 = new ListNode(0);
    ListNode l1Head = l1;
    for (int i : arr) {
      l1.next = new ListNode(i);
      l1 = l1.next;
    }
    return l1Head.next;
  }

  public String toString(ListNode l1) {
    List<Integer> arrList = new ArrayList<>();
    while (l1 != null) {
      arrList.add(l1.val);
      l1 = l1.next;
    }
    return arrList.stream().map(v -> v.toString()).collect(Collectors.joining(","));
  }



  @Test
  public void mergeTwoLists() {
    String input1 = "2,3,4";
    String input2 = "1,6,9";
    String expectedOp = "1,2,3,4,6,9";
    Assert.assertEquals(expectedOp, compute(input1, input2));
  }

  private String compute(String ip1, String ip2) {
    Problem21 problem21 = new Problem21();
    return toString(problem21.mergeTwoLists(listNode(ip1), listNode(ip2)));
  }
}