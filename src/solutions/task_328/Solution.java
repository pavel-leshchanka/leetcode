package solutions.task_328;

/**
 * 328. Odd Even Linked List
 * Given the head of a singly linked list, group all the nodes with odd indices together followed
 * by the nodes with even indices, and return the reordered list.
 * The first node is considered odd, and the second node is even, and so on.
 * Note that the relative order inside both the even and odd groups should remain as it was in
 * the input.
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstObb = head.next;
        ListNode startEven = head;
        ListNode startObb = head.next;
        while (startEven.next != null && startObb.next != null) {
            startEven.next = startEven.next.next;
            startObb.next = startObb.next.next;
            startEven = startEven.next;
            startObb = startObb.next;
        }
        startEven.next = firstObb;
        return head;
    }
}