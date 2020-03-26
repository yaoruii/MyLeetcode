# 333 Largest BST Subtree

像333这种题怎么会有人能写出来呢？唉

```
Input: [10,5,15,1,8,null,7]

   10 
   / \ 
  5  15 
 / \   \ 
1   8   7

Output: 3
Explanation: The Largest BST Subtree in this case is the highlighted one.
             The return value is the subtree's size, which is 3.
```
## DFS:bottom up search

* 首先给的是一个二叉树，不是BST，是ST，也就是说这些node的大小关系是无所谓的，要从里面找到最大的BST tree，符合node的大小关系的suntree。
* BST 的大小关系：root.right这棵树的最小值 > root >root.left这棵树的最大值
* bottom up :首先定位到最左的node1，看看该node1的左孩子多大以及取值范围，右孩子多大以及取值范围，和该node1比是够满足条件，满足就计算下以该node1为root的subtree的大小
* 该node1为最左元素，如果其有右孩子，右孩子也是一路下去到最左，然后一层层地往上计算，得到node1的右孩子的size和取值范围
* 所以上述的遍历为postorder?
* 如果不满足大小关系：该node1为root的树不是BST,就把node1返回的size = -1,意味着以node1为root的树不是bst
* 如果该node1的某个孩子不是BST，也就是某个孩子的size = -1,那么node1为root的树不是bst，所以也让node1的size= -1.
* 以上两种情况是满足不是BST的情况。
