# 114. Flatten Binary Tree to Linked List

这道题就是把一个tree变成一个全部都朝右的tree：
```
    1
   / \
  2   5
 / \   \
3   4   6
```
to 
```
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

## inorder入队 + 队列访问重置：1ms,28%
这道题一开始我想：结果的node是按照inorder的顺序一个排一个，后被inorder的元素的上一个被inorder的元素的right child。所以可以先进行inorder traversal，所谓的action就是将当前被访问的元素放入队列之中。

全部都进入到队列后，在从最前端返回一个又一个的node，用track追踪上一个poll()的node,然后让track.right = poll(),track.left = null, track = track.right.

## postorder + 直接递归：0ms,100%
```
public void flatten(TreeNode root) {
    flatten(root,null);
}
private TreeNode flatten(TreeNode root, TreeNode pre) {
    if(root==null) return pre;//注意root==null,是返回pre,因为没有元素要加进去，那么就把要加到它身上的tree=它，然后进入下一轮，很合理
    pre=flatten(root.right,pre); //先把right tree弄直，返回的结果是接下来的left tree的第一个被进行到40行的元素的right child.
    pre=flatten(root.left,pre);
    root.right=pre;
    root.left=null;
    pre=root;
    return pre;
}
```
示意图
```
pre = 5
cur = 4

    1
   / 
  2   
 / \   
3   4
     \
      5
       \
        6
-----------        
pre = 4
cur = 3

    1
   / 
  2   
 /   
3 
 \
  4
   \
    5
     \
      6
————————--
pre = 3
cur = 2
    1
   / 
  2   
   \
    3 
     \
      4
       \
        5
         \
          6
-----------  
pre = 2
cur = 1
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
