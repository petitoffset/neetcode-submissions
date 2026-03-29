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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        } 
        return newHead;
        
    }
}
