# 0021.Merge Two Sorted Lists

Linked List常考笔试题，一般用作第一轮笔试。

只要两个list都不是null，那么选出较小者。如果有一个变成了null，那么跳出循环，并根据哪个list不是null，把剩下部分接上即可。

这边用到一个小技巧是dummy node，可以为了防止head是null的情况。

## Solution
```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        
        return dummy.next;
    }
}
```

Topic: [Stack](../Linked_List/)

[Leetcode Link](https://leetcode.com/problems/merge-two-sorted-lists/)