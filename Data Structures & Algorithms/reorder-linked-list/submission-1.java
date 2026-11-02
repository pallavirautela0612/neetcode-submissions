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

        ListNode slow = head;
        ListNode fast = head.next;

        // Finding middle of the list
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        //Reversing the second half of the list.
        //Second half will be started from next node of slow pointer.
        ListNode secondCurr = slow.next; 
        ListNode prev = null;
        while (secondCurr != null) {

            ListNode next = secondCurr.next;
            secondCurr.next = prev; // link reversal
            prev = secondCurr;
            secondCurr = next;
        }

        // Breaking first half from the second half
        slow.next = null;  

        // Merging two halves
        ListNode first = head;
        ListNode second = prev; //Because secondCurr became null at last iteration

        //Second list will be shorter if odd number of nodes & equal in even case.
        while (second != null) { 

            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second; //linking first list node to second list node
            second.next = temp1; //linking second list node to first list node

            first = temp1; //Shifting pointers
            second = temp2; //Shifting pointers
        }
    }
}
