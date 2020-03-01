public class isPalindromicLinkedList {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public boolean isPalindrome(ListNode head) {
            if(head == null || head.next == null){return true;}
        /*//stack法：2ms,49%
        //先想到了用stack，最后进入的末尾node先出来和原list的head比较
        //stack中的元素存储的是node的地址，他们之间的连接关系就是next的值不变（val没变，next当然也不会变）
        Stack<ListNode> stored = new Stack<>();
        ListNode track = head;
        while(track != null){
            stored.push(track);
            track = track.next;
        }
        track = head;
        while(!stored.empty()){
            if(stored.pop().val != track.val){
                return false;
            }
            track = track.next;

        }
        return true;  */
            //follow up：do it in O(n) time and O(1) space?
            //？？？？？1086ms???
            //???1444ms
            //想到一种two pointers + recursion的方法，但是会迫坏原list，先试试
            ListNode tail = head;
            //ListNode second = head;
            while(tail.next.next != null){//while会误写成for
                tail = tail.next;
                //second= second.next;
            }
            if(head.val != tail.next.val){
                return false;
            }
            else{
                tail.next= null;//之前让tail =null不行肯定是因为没有使末尾node变成null
                return isPalindrome(head.next);
            }
        }

}
