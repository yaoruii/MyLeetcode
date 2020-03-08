# 230. Kth Smallest Element in a BST
```
Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
```
## stack+迭代 + inorder = 可控制的递归:3ms

```
Stack<TreeNode> fringe = new Stack<>();
fringe.push(root);
TreeNode track;
track = root;
int num = 0;
while(track != null || !fringe.empty()){
    while(track != null){
        fringe.push(track);
        track = track.left;
    }//退出该while循环的时候就是最左边的branch元素都进栈了。
    track = fringe.pop();
    num +=1;
    if(num == k){
        return track.val;
    }
    //不管track的right是不是null，都要执行下track=track.right，不然track永远就是上边pop出来的那个node了。
    //而且是不是null，进行不进行把最左边的branch加进去是while(track != null)做的事
    track = track.right;

}
return track.val;
```

## DFS + inorder:0ms
* 设置了一个track的全局变量，用来=第k个元素的node,还有一个nums的全局变量，最开始等于K，每次运行到root结点的时候，num -=1, 当nums==0的时候，让track = 当前的root结点，
这样，在helper函数中，每次的递归都不需要返回什么，**我们也可以全局地追踪nums的大小**
* 首先，当root.left!= null的时候，调用helper(root.left)，这样最终会到达最左的branch的最后一个元素，然后root.left==null, 执行helper()函数的下一块：
* 下一块：说明已经来到了一个没有左孩子的root处，该root可以被遍历了，由于只需要第K个被遍历的元素，所以不做任何处理，只让nums--，之后的nums如果==0了，说明此时的这个root
的确是**我们需要的第K个被遍历的元素**，让track = root，即可。

```
public int nums = 0;
public TreeNode track;
public int kthSmallest(TreeNode root, int k) {
        nums = k;
        track =root;
        helper(root);
        return track.val;  
    }
    
public void helper(TreeNode root){
        if(root.left != null && nums>0){
            helper(root.left);
        }
        nums = nums-1;
       if(nums == 0) track = root;
        if(root.right != null && nums >0){
            helper(root.right);
        } 
    }
  ```
  



