public class ReverseLinkList {

     /* Definition for singly-linked list.*/
     public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }

        public ListNode reverseList(ListNode head) {
            //首先想到的就是堆栈
            //结果。。。7.75%。。奶奶的，n的时间复杂度
            //继续思考。。。。。。。。。。。。。
        /*if(head == null){return null;}
        Stack<ListNode> list = new Stack<>();
        while(head != null){
            list.push(head);
            head = head.next;
        }

        head = list.pop();
        ListNode tail = head;
        while(!list.empty()){
            tail.next = list.pop();
            tail = tail.next;
        }
        tail.next = null;
        return head;*/
            //方法二：递归
            //终于成功了一次：100%
        if(head == null || head.next == null){return head;}
        //先完成head.next的反转，然后将head接在最后?how
        //，并且让head.next = null

        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return res;
            //迭代

        }

}
