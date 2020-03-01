# Reverse Link list
 难受。。写的东西咋没了，靠靠靠
 
 ## 堆栈法：7.75%。。n的时间复杂度
 
 ## 递归：终于成功了一次：100%
 
 * 先完成head.next的反转，然后将head接在最后?how？？？
 * 并且让head.next = null
 
 所以我们只需要完成上述两步即可，关于第一点：
 * 不需要将递归返回的res进行遍历找到指向null的末尾node，因为res是head.next的反转结果，末尾node就是当前head的next，**这一指向关系未变，head.next == 末尾node，所以一行：head.next.next = head, head = null, 即可。**
 * 同时注意，返回的是res，因为头部一直都是res，我们只是多次调用函数自身，然后把每次的head放在最后。

## follow up:迭代：还未实现
