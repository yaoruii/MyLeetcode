/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /*
        //先用hashtable的方法写一下
        //Do not modify the linked list.
        HashSet<ListNode> set = new HashSet<>();
        int index = 0;
        ListNode track = head;
        while(track != null){
            if(set.contains(track)) return track;
            else{
                set.add(track);
                track = track.next;
            }
        }
        //退出了说明track == null
        return track;*/
        //Floyd's Tortoise and Hare
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;//刚开始都指向第一个元素
        ListNode intersect = null;
       
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                intersect = fast;
                break;
            }
        }
        //return slow;//此时只是第一次相遇点，不是入口点
        if(intersect== null) return null;
        ListNode ptr2= intersect;
        ListNode ptr1 = head;
        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
        
        
    }
}
