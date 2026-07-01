/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Node> map = new HashMap<>(); // key = old node, value = new node
        
        Node dummy = new Node(0);
        Node prev = dummy;

        Node oldHead = head;

        while (head != null) {
            Node newNode = new Node(head.val);
            prev.next = newNode;
            prev = newNode;
            map.put(head, newNode);
            head = head.next;         
        }

        while (oldHead != null) {
            map.get(oldHead).random = map.get(oldHead.random); 
            oldHead = oldHead.next;        
        }

        return dummy.next;        
    }
}
