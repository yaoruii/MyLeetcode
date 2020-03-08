# 235. Lowest Common Ancestor of a Binary Search Tree

**这道题本来不会写，没有思路，然后我看到了236：也是找LCA，不过是普通的二叉树，不是BST，那么235一定用到了BST的独特的特性，然后就想出来了**

* BST的特性，左边的孩子比root小，右边的孩子比root大
* 所以我们可以通过比较root和p,q的大小，来确定p,q的大概的位置
* 大概的位置很重要：
    * 如果两者有一个等于root，那么祖先就是root
    * 如果两者分布在root的两侧，那么他们唯一的也是最低的祖先就是root
    * 如果两者同时分布在左侧，那么就可以递归调用该函数，此时的root会被传入root.left
    * 如果两者同时分布在右侧，那么就可以递归调用该函数，此时的root会被传入root.right

    
```
         TreeNode small;
        TreeNode big;
        if(p.val < q.val) {
            small = p;
            big = q;
        }
        else{
            small = q;
            big = p;
        }
        if(small.val <= root.val && big.val>= root.val) return root;
        else if(small.val> root.val) return lowestCommonAncestor(root.right, p, q);
        else {
            return lowestCommonAncestor(root.left, p, q);
        }
```
