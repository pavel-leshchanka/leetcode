package solutions.task_2130;

/**
 * 2130. Maximum Twin Sum of a Linked List
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the
 * (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes
 * with twins for n = 4.
 * The twin sum is defined as the sum of a node and its twin.
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */

class Solution {
    public class ListNode {
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

    public int pairSum(ListNode head) {
        ListNode listNode = head;
        ListNode current = head;
        ListNode currentAfter = head.next;
        while (currentAfter.next != null) {
            current = current.next;
            currentAfter = currentAfter.next.next;
        }
        ListNode afterHead = current.next;
        ListNode priv = null;//
        while (afterHead != null) {
            ListNode temp = afterHead.next;
            afterHead.next = priv;
            priv = afterHead;
            afterHead = temp;
        }
        int max = 0;
        while (listNode.next != null) {
            int i = priv.val + listNode.val;
            if (i > max) max = i;
            listNode = listNode.next;
            priv = priv.next;
        }
        return max;
    }
}