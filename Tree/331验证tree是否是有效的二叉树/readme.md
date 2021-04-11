331


使用stack:给的是一个字符串，preorder：root,left, right，null用#代替

遍历字符串：
* 如果是数字，入栈
* 如果是#：curr=#
   * if peek() 是数字，peek()的left child 是null，curr= #入栈继续
   * if peek() 是#， peek()是倒数第二个元素sub-root的left child，curr= #还没入栈的这个是right child，两者都是#，sub-root是叶子节点！pop()两次，然后将Curr=# 入栈，相当于将该叶子节点取消了，用一个# mark一下。
      * 如果，无法连续pop()两次，即把peek =# POP出来后，stack空了，那么该string代表的tree无效。


最终，遍历完字符串，会一路取消到：stack中只有一个元素，且为#

