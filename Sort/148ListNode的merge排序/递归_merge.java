class Solution {
    public ListNode sortList(ListNode head) {
        //要求是constant space complexity，但是自顶向下的merge不行
        //自底向上的merge可以
        //先尝试实现自顶向下的merge吧。。
        if(head ==null || head.next==null) return head;
        ListNode pre = null;ListNode slow = head;ListNode fast = head;
        while(fast!=null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        /*要pre干啥？？
        ListNode l1 = sortList(head);*/
        //如果不要pre，直接调用上边这一行代码，是不是觉得很荒谬！自己调用自己，连参数都一样，陷入无尽循环
        //所以，pre是用来将该list从中间劈开的！
        pre.next = null;//pre.next不再是slow而是null，现在是两个list
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1,l2);
    }
    private ListNode merge(ListNode l1, ListNode l2){
        ListNode res = new ListNode(0);
        ListNode track = res;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                track.next = l1;
                l1 = l1.next;
            }
            else{
                track.next = l2;
                l2 = l2.next;
            }
            track = track.next;
        }
        if(l1==null){//l1的所有node都已经遍历完，把l2放到后边即可
            track.next = l2;
        }
        else if(l2 == null){
            track.next = l1;
        }
        return res.next;
    }
}
