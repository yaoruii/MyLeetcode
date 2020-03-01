# 234 Palindrome Linked List

判断一个LINKED LIST是不是回文

## 堆栈法：：2ms,49%
先想到了用stack，最后进入的末尾node先出来和原list的head比较。stack中的元素存储的是node的地址，他们之间的连接关系就是next的值不变（val没变，next当然也不会变）

