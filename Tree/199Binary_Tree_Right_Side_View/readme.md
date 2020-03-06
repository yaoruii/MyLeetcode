# 199. Binary Tree Right Side View
```
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
  ```
  
## BFS:Level-level traversal的变形：1ms，78%
我想出的方法：我觉得这是Level-level traversal的变形，因为我们依旧是按照Level-level traversal整个tree，只是在每一个level的最后一个元素被poll()出来时，把它加在res中

##DFS:学习


# 116. Populating Next Right Pointers in Each Node
```
给node的next赋值，next指向和node在同一个level的其右边的node，最右边的是null
```
## BFS:Level-level traversal的变形：1ms，50%
这道题和写完199后写到的，立刻就想到了BFS，因为和之前的level-level traversal本质上还是一样的，traversal的过程中，给当前正在被处理的node的next赋值。
**和上边的199一样，这样的方法时间比较久，performance 不也太好，先把今天的第三题写了，然后再说**

# 117. Populating Next Right Pointers in Each Node II
看到117，我才发现116给定的tree是perfect tree，就是平衡的：
>You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The binary tree has the following definition

所以我写的116的代码也是完全完全适用于117的，事实上：**上述代码应该是写个117的，既然116是perfect tree，那么肯定有比上述代码更简单的方法**

至此，我用了一两个小时就写完了今天的三道（中间追呆哈了，还是浪费了时间，所以才这样表达）。。用的全部都是BFS，完全一样的思路，同样，performance都不好，接下来进行代码学习时间！


