/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head;
        head = first.next;
        ListNode next_pair;
        while(first != null && first.next!= null){
            next_pair = first.next.next;//可能==null
            first.next.next = first;
            if(next_pair == null || next_pair.next == null){
                first.next = next_pair;
            }
            else{
                first.next = next_pair.next;
            }
            first = next_pair;
        }
        return head;
        
    }
}
