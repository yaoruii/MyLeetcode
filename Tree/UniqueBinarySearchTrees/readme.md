# 96 Unique Binary Search Trees

beautiful啊，这道题我自己写出来的！！ 使用了上次看的DP之一，基本上可以套用：递归+DP保存之前计算过的元素，而不是重复计算重复调用函数

Bst树的left tree的所有元素都比root小，right tree所有元素都比root大，所以传入n，把元素按1，2，3，...n排列好，root可以从1,2,3..n中pick任何一个，那么被pick的root的左侧元素是1，2，...root-1，它们一起组成left child，右侧元素：root+1,...n，他们一起组成right tree。

于是，我们只需要对root进行**迭代**，从1到n，每一哥root得到的tree的个数相加起来就是最终的结果。

**重点：对于n=3,当root=1，我们需要计算n(2)=?,然后root=2,我们需要计算n(1)x n(1),最后root=3,我们需要计算n(2)=?,很明显的DP问题，使用一个mem[]保存我们计算的结果，还没计算的地方的value就写成0（因为任何被计算过的都至少是1），每次调用递归自身函数，先看mem[n]!=0,如果！=0，那么直接返回即可，==0，那么计算这个n对应的结果，保存到mem[n],再返回

**在原来的method里面建立mem[]数组，然后写个helper函数，这个helper函数是递归算法，在原函数中将n和定义的mem[]传入到helper中。在helper中完成大部分工作**
