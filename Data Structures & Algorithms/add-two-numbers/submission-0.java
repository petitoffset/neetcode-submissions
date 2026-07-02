/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            ListNode next = new ListNode();
            int val = l1.val + l2.val + carry;
            next.val = val % 10;
            carry = val / 10;
            prev.next = next;
            prev = next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 != null) {
            while (l1 != null) {
                ListNode next = new ListNode();
                int val = l1.val + carry;
                next.val = val % 10;
                carry = val / 10;
                prev.next = next;
                prev = next;
                l1 = l1.next;
            }
        }
        if (l2 != null) {
            while (l2 != null) {
                ListNode next = new ListNode();
                int val = l2.val + carry;
                next.val = val % 10;
                carry = val / 10;
                prev.next = next;
                prev = next;
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            ListNode next = new ListNode(1);
            prev.next = next;
        }
        return dummy.next;  
    }
}
