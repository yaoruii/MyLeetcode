# 510. Inorder Successor in BST II

**285的变形题，给的不是root，而是只给了p，但是node拥有了一个指向父节点的指针，所以，可以根据p找到root，然后调用285的方法。找到root后，把285的函数拿过来当helper()函数即可，剩下的和285一样**


**所以，这道题，出了一个follow up:Could you solve it without looking up any of the node's values?,不比较node的值，和285不一样了**

## follow up

* 根据node的不同情况的分类分析，使用if进行不同处理
* 1，如果node没有右孩子，且其是其母结点的左孩子，那么node的successor就是其parent
* 2, 如果node有右孩子，那么进入到右孩子这个subtree，node.right就是右孩子的root，node的successor就是该subtree一路向左寻找最左的node。
```
 if(node.right != null){
    Node res = node.right;
    while(res.left != null) res = res.left;
    return res;
  }
```
* 3, 如果node没有右孩子，且其是其母结点的右孩子，那么successor就是一路往上找node的祖先，找到第一个祖先 which 是再上一个祖先的左孩子（所以，这里要满足再上一个祖先不为null，不然无法验证是否是左孩子），那么这个祖先的parent，也就是“再上一个祖先”就是答案。这里分两种情况：
   * node一路向上，找到了第一个祖先，其是其母结点的左孩子，这个母结点就是答案
   * node一路向上，找到的某一个祖先是root，其上一个祖先为null，也就是说，node没有后继者了，为null，所以1中的母结点依然是答案。
   
```
if(node.right == null){
    //node是没有右孩子的root或者是其父节点的左孩子
    Node res = node;
    //node是其母结点的右孩子，寻找第一个祖先 which 是第一个再上一级祖先的左孩子
    while(res.parent != null && res != res.parent.left) //首先要判断res.parent是否是null，不然无法引用其的left属性
        res = res.parent;
    return res.parent;
}
```
* 可以看出，3和1本质上是一样的，1是从node本身出发，node就是3中的第一个祖先了，3是需要往上走一段距离。所以，可以用一个while循环，不满足条件的时候，继续往上走。
