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
    public ListNode mergeKLists(ListNode[] lists) {
        // Min Heap
        // "head" should be "tail"
        // PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        // for (ListNode node : lists) {
        //     if (node != null) {
        //         minHeap.add(node);
        //     }
        // }
        // ListNode dummy = new ListNode();
        // ListNode head = dummy;
        // while (minHeap.size() > 0) {
        //     head.next = minHeap.poll();
        //     if (head.next.next != null) {
        //         minHeap.add(head.next.next);
        //     }
        //     head = head.next;
        // }
        // return dummy.next;

        // Divide and conquer, merging pairs
        if (lists.length == 0) return null;
        int len = lists.length;
        int interval = 1;
        while (interval < lists.length) {
            for (int i = 0; i + interval < lists.length; i += interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];

    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (a != null && b != null) {
            if (a.val < b.val) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = a == null ? b : a;
        return dummy.next;
    }
}
