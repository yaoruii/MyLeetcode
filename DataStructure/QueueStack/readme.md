# 使用队列实现堆栈
队列queue是先进先出，堆栈是先进后出，后进先出，所以为了简单，可以使用双端队列：Deque，两头都可以进出。

>addLast(); removeLast(); peekLast();

# 使用堆栈实现队列

push很简单，因为都是放入到队尾，pop的时候，要pop出最低部的，就要用另一个stack做tmp，保存除了最底部的那个元素之外的其他元素，然后把最底部的元素pop()出来，然后再把tmp中的元素放回去