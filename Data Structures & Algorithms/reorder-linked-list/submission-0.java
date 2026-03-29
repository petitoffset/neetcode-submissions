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
    public void reorderList(ListNode head) {
        if (head.next == null) return;

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode beforeSlow = null;
        while (fast != null && fast.next != null) {
            beforeSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        beforeSlow.next = null;
        // reverse second half (with middle node if number of nodes is odd)
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = slow;
            slow = cur;
            cur = tmp;
        }
        // merge two halves
        ListNode first = head;
        ListNode second = slow;
        ListNode dummy = new ListNode();
        ListNode nextFirst = first.next;
        ListNode nextSecond = second.next;
        while (first != null) {
            nextFirst = first.next;
            nextSecond = second.next;
            dummy.next = first;
            dummy.next.next = second;
            dummy = dummy.next.next;
            first = nextFirst;
            second = nextSecond;
        } 
        dummy.next = second;
        
    }
}
