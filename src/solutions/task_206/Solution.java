package solutions.task_206;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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

    public ListNode reverseList(ListNode head) {
        ListNode nextElem = head;
        ListNode current = null;
        while (nextElem != null) {
            ListNode temp = nextElem.next;
            nextElem.next = current;
            current = nextElem;
            nextElem = temp;
        }
        return current;
    }
}