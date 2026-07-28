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
        if(head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode prev=null,curr=mid.next, next;
        mid.next=null;
        while(curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ListNode leftHead = head;
        ListNode rightHead = prev;
        ListNode nextL, nextR;
        while(leftHead != null && rightHead != null) {
            nextL = leftHead.next;
            leftHead.next = rightHead;
            nextR = rightHead.next;
            rightHead.next = nextL;

            rightHead = nextR;
            leftHead = nextL;
        }
    }
    private ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}