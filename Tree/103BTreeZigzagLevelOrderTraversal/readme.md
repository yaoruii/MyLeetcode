# 103. Binary Tree Zigzag Level Order Traversal
蜿蜒曲折地遍历元素，第一行from left to right, the next level: from right to left, the next level: from left to right  
[3,9,20,1,2,15,7] ======= [[3],[20,9],[1,2,15,7]]

本来这题，我以为和102系列的level-level遍历是一样的，是不过有的行数，我们以前是：
> 以前：level.add(track.val)  
>现在：要做个判断：奇数行add(track.val); 偶数行：add(0, track.val)  
> 但是有人说**这样不是真正的ZigZag traversal**，我觉得他说的有道理，如果不是单纯地add到list中，而是print，那么这种算法的结果就不对了  

我觉得他说的很对，于是采取了两个队列/堆栈的方法：s1:负责存放node.level=0,2,4..，s2:负责存放node.level=1,3,5,...：
* 如果使用队列，把元素放入s1是按照track.left先，把元素放入s2时按照track.right先的顺序，但是这样就导致了一个问题：s2=[20,9],poll出来加入到level中时也是正确的顺序【20，9】,但是，在把20和9分别加入到level时，我们还要把他们的children加入到s1，按照track.left先，这样s1=【15，7，1，2】(如果9的左是1，右是2),之后，s1.poll()的话，就变成了【15，7，1，2】，**虽然是按照from left to right，但是是上一层的right的孩子先被遍历，wrong**,
* 所以，**需要两个堆栈**，这样就避免了上述问题：把元素放入s1是track.right先，这样left先出来，把元素放入s2按照track.left先。所以s2=[9,20]，pop()20先出来，把20的孩子放入s1,按照右边先，最后level=【20，9】，s2=【7，15，2，1】，s2被pop出=level=【1，2，15，7】。correct。

