# 173. Binary Search Tree Iterator

**这道题本质上还是 inorder traversal ，我们按照inorder的顺序对nodes进行一个一个地读取（iterator)**
```
BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false

Note:
next() and hasNext() should run in  average O(1) time and uses O(h) memory  where h is the height of the tree.
You may assume that next() call will always be valid, that is, there will be at least a next smallest number in the BST when next() is called.
```
**average O(1) time and uses O(h) memory**

## 递归得到flattened的tree：O(n) memory
常规算法：使用inorder的递归，先左后root.action，然后再右，把所有的node按照inorder的顺序排放在队列或者数组中，然后next()直接poll()出去即可
但是不满足O(h) memory。
## 迭代得到可控地递归：
就是迭代法进行inorder traversal
* 最开始将root作为整个树的结点的最左边的一天分支push()进去
* 然后每次 ```next()``` 将stack中最上边的pop()出去之后，此时，我们应该转向被pop出去的node的right child，我们下一次pop的是right child作为root结点时对应的最左边的一条分支的最后一个元素，所以要将right child作为root结点时对应的最左边的一条分支 依此push()到堆栈中
* 下次```next()```的时候，pop()最上边的元素，就是步骤2的最左的最后一个元素，依此类推，重复下去，**不断地有元素pop()出去，但同时刻，我们会把这个出去的元素的right child的最左分支push()进去**
* 直到stack为空，遍历完所有的元素了。

 ```
class BSTIterator {
    //使用迭代的方法去模拟inorder
    public Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftmostnodes(root);//整个tree的最左边的那一条branch被添加了进去   
    }
    private void leftmostnodes(TreeNode root){
        //given a root, add all the left most nodes along this root to the stack
        while(root != null){
            stack.push(root);
            root = root.left;
        }
    }
    /** @return the next smallest number */
    public int next() {
        TreeNode leftmost = stack.pop();//此时在stack最顶端的就是此刻的smallest
        if(leftmost.right != null){//有可能有rightchild
            leftmostnodes(leftmost.right);//把right的最左边的分支加进去
        }
        return leftmost.val;
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }
}
 ```
