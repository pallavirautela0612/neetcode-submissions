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

        // Break the given list in 2 halves from the mid/slow;

        ListNode list1 = head;
        ListNode slow = list1;
        ListNode fast = list1;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        // Second list start from the next node of mid/slow, reverse it.
        ListNode list2 = reverse(slow.next);

        // 1st half separating from the second half.
        slow.next = null;

        // Now merge list1 & list2; list2 will always be shorter or equals to list1
        while (list2 != null) {

            ListNode temp1 = list1.next;
            list1.next = list2;
            list1 = temp1;

            ListNode temp2 = list2.next;
            list2.next = list1;
            list2 = temp2;
        }
    }

    private ListNode reverse(ListNode list2) {

        ListNode curr = list2;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
