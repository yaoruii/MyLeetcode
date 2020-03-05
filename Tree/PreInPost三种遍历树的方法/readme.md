# preorder、inorder、postorder traversal 汇总
## preorder:
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
