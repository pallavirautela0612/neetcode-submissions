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
        // 1. Create a dummy node to act as the permanent anchor for the start
        ListNode dummy = new ListNode(-1);
        
        // 2. Use a tracker pointer ('curr') to move forward and link nodes
        ListNode curr = dummy; 
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1;   // Link the existing node (no need to use 'new')
                list1 = list1.next;  // Move list1 pointer forward
            } else {
                curr.next = list2;   // Link the existing node
                list2 = list2.next;  // Move list2 pointer forward
            }
            curr = curr.next;        // CRITICAL: Move your tracker forward!
        }
        
        // 3. Attach the remaining elements of whichever list isn't empty
        if (list1 != null) {
            curr.next = list1;
        } else {
            curr.next = list2;
        }
        
        // 4. Return the node after the dummy anchor
        return dummy.next;
    }
}