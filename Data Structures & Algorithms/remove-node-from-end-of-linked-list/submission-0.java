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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = getLength(head) - n;
        if(index == 0){
            return head.next;
        }
        ListNode temp = head;

        for(int i=0;i<index - 1;i++){
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next;
        } else {
            temp = temp.next;
        }

        return head;
    }

    public int getLength(ListNode head){
        ListNode temp = head;
        int index = 0;
        while(temp != null){
            temp = temp.next;
            index++;
        }
        return index;
    }
}
