/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        //two pointers
        if(k == 0 || head == null) return head;
        ListNode start = head;
        ListNode end = start;
        int len = 0;
        while(end!= null && end.next != null){
            len +=1;
            end = end.next;
        }
        //应该是当end.next=null时退出了while循环，end此时指向末尾，start指向最开头
        //但是由于end此时指向末尾，end.next已经为null，无法进入最后一次的len++，要补上
        len++;
        k= k%len;//len = 3, k = 1
        //如果K等于0了，那么说明不需要做任何操作，那么下边的这些代码就是不对的！！！要判断一下啊！
        if(k>0){
            for(int i = 1; i< len-k; i++){
                start = start.next;
            }
            ListNode tmp = start.next;
            start.next = null;
            end.next = head;
            return tmp;
        }
        return head;
    }
}
