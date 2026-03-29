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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode sortedHead;
        if (list1.val <= list2.val) {
            sortedHead = list1;
            list1 = list1.next;
        } else {
            sortedHead = list2;
            list2 = list2.next;
        } 
        ListNode currentSortedTail = sortedHead;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentSortedTail.next = list1;
                currentSortedTail = currentSortedTail.next;
                list1 = list1.next;
            } else {
                currentSortedTail.next = list2;
                currentSortedTail = currentSortedTail.next;
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            currentSortedTail.next = list2;
        } else {
            currentSortedTail.next = list1;
        }
        return sortedHead;
        
    }
}