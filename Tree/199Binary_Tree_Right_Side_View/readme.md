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
