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

## DFS:学习, 0ms, 100%, dfs会快一点
**看了下递归的代码，和BFS一样，依旧类似于当初学习BFS、DFS时看的那份代码一样，不过action有所改变罢了，DFS的action还是有点难消化，但本质还是一样**
```
public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        dfs(root, view, 0);
        return view;
        
    }
    public void dfs(TreeNode root, List<Integer> res, int depth){
        if(root == null) return;
        /*47-49 是action*/
        if(res.size() == depth){//说明这一层的node还未被遍历,如果已经被遍历，说明此时的root不是最右，什么都不做
            res.add(root.val);
        }//action仅仅在遇到depth==size时有。
        /*接下来是dfs(v),递归*/
        if(root.right != null) dfs(root.right, res, depth+1);//call这个后，就会一路沿着最右走下去，直到null，
        //然后往上走（也就是所谓的return最后一个递归）（开始倒数第二个递归call的left），找倒数第二右，
        //最后来到了整个树的root的left child，然后也是一路最右地走下去
        if(root.left != null) dfs(root.left, res, depth+1);
    }
```
# 116. Populating Next Right Pointers in Each Node
```
给node的next赋值，next指向和node在同一个level的其右边的node，最右边的是null
```
## BFS:Level-level traversal的变形：1ms，50%
这道题和写完199后写到的，立刻就想到了BFS，因为和之前的level-level traversal本质上还是一样的，traversal的过程中，给当前正在被处理的node的next赋值。
**和上边的199一样，这样的方法时间比较久，performance 不也太好，先把今天的第三题写了，然后再说**

## DFS：
学习了199的dfs，进行尝试。以及117的启发，它是一个完美树，这意味这什么呢？


# 117. Populating Next Right Pointers in Each Node II
看到117，我才发现116给定的tree是perfect tree，就是平衡的：
>You are given a **perfect binary tree** where all leaves are on the same level, and every parent has two children. The binary tree has the following definition

所以我写的116的代码也是完全完全适用于117的，事实上：**上述代码应该是写个117的，既然116是perfect tree，那么肯定有比上述代码更简单的方法**

至此，我用了一两个小时就写完了今天的三道（中间追呆哈了，还是浪费了时间，所以才这样表达）。。用的全部都是BFS，完全一样的思路，同样，performance都不好，接下来进行代码学习时间！


