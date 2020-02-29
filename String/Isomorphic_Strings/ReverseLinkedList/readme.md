# Reverse Linked List

>Input: 1->2->3->4->5->NULL
>
>Output: 5->4->3->2->1->NULL

## 堆栈法：7.75%
这道题一开始拿到后就立刻想到了堆栈，先进后出，很简单。

但是要涉及到先遍历输入的list，将其进入到堆栈中，然后再遍历堆栈，将node连接成新的输出list，所以时间复杂度是n

## 之后实现了递归法：100%
递归就是先完成head.next这个list的reverse，得到返回的结果后，将head连接在返回的结果后边，这里有一个点：**如何将找到返回的结果的末尾node，并将其的next=head**，一开始想的是对结果进行遍历，找到结果的node中其next=null的node，最后突然意识到两点：

* 每一轮的调用自身这个函数传入head.next，该head.next无论去到了哪里（**实际上去到了：调用自身这个函数时的返回结果res这个list的末尾**），head都是指向这它的，就是说我们要把head连接在它后边，现在是head在它前边
* 当使用：head.next(末尾node）.next = head, head.next = null后，完成了这一次的reverse，需要将其作为上一个reverseList()的call的返回结果返回，这里注意：**直接返回这一轮的call的返回结果res即可，因为我们已经在res后边加上这一轮的head**

