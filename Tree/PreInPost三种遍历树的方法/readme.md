# preorder、inorder、postorder traversal 汇总
## 144 preorder:
先root,再left,再right
### 递归：
```
public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> pre = new LinkedList<Integer>();
		preHelper(root,pre);
		return pre;
	}
	public void preHelper(TreeNode root, List<Integer> pre) {
		if(root==null) return;
		pre.add(root.val);//对于这三种不同的遍历方法，这题的action是pre.add(root.val);，和经典代码里的print是一样的
		preHelper(root.left,pre);//所以改变这三行代码的顺序，就可以使用递归实现这三种遍历！！！！so easy!
		preHelper(root.right,pre);
	}
  ```
  ### 迭代+堆栈
  ```
  public List<Integer> preorderTraversal(TreeNode root) {
        /*使用迭代法*/
        List<Integer> fringe = new ArrayList<>();
        if(root == null)return fringe;
        Stack<TreeNode> tovisit = new Stack<>();
        tovisit.push(root);
        TreeNode curr;
        while(! tovisit.isEmpty()){
            curr = tovisit.pop();
            fringe.add(curr.val);
            if(curr.right != null) tovisit.push(curr.right);
            if(curr.left != null) tovisit.push(curr.left);
        }
        return fringe;
  ```
  
## inorder
先左，在root,后右
### 递归：
```
if(root==null) return;
preHelper(root.left,pre);
pre.add(root.val);
preHelper(root.right,pre);
```
### 迭代+stack:
```
 /**iterating with stack!!*/
List<Integer> list = new ArrayList<>();
Stack<TreeNode> stack = new Stack<>();
TreeNode curr = root;
while(curr != null || ! stack.isEmpty()){//curr不为空，或者stack中有node
    //stack的作用：一路往左，把元素暂存
    while(curr != null){
	stack.push(curr);//所有放进stack的node都不为空
	curr = curr.left;//这两句：找到最左边的node，并把沿途的node放进stack
    }
    //退出这个while循环mean：已经找到最左，对其action
    curr = stack.pop();//pop出来mean:act,加入到list中
    list.add(curr.val);//action,已知curr无left，但不知是否有right，所以：
    curr = curr.right;//把curr的right赋值为当前node,然后从头开始，和最一开始的root一样，当成一个新的tree。一路寻找最左，然后输出。   
}
return list;
```

## 145 postorder
是道hard，有点意思，主要在于迭代法
