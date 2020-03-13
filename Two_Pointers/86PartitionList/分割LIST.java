/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        //You should preserve the original relative order of the nodes in each of the two partitions.
        if(head == null) return null;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode start = res;
        ListNode end;
        ListNode tmp;
        while(start.next != null && start.next.val < x){
            start = start.next;
        }
        end = start;
        while(end != null && end.next!= null ){
            /////end是动态变化的，所以要一直check end.next
            while(end.next!= null && end.next.val>= x){
                end = end.next;
            }
            //上边的while循环需要同时满足两个条件，那么当退出while循环的时候，我们需要确认下是哪一个条件没有被满足。------基本素养
            if(end.next != null){
            tmp = end.next;
            end.next = tmp.next;
            tmp.next = start.next;
            start.next = tmp;
            start = start.next;
            }
        }
        return res.next;
        
    }
}
