# 105 Construct Binary Tree from Preorder and Inorder Traversal

Given preorder and inorder traversal of a tree, construct the binary tree.

>preorder = [3,9,20,15,7]
>
>inorder = [9,3,15,20,7]
>Return the following binary tree:

这道题的算法部分是我自己想出来的，但是却引出了几个问题，其中一个也是很久之前的一道题上遇到过的，但是还是再一次没有想到：数组的子数组可以使用pointer得到

* 首先我们知道preorder的第一个元素会是整个tree的根结点，但是根结点在inorder中却在所有的left tree的元素的后边，也就是说：**找到preorder[0]即根结点** ——> **根据根结点找到其在inorder中的索引** ——> **inorder索引前的数：left tree的inorder** ——> **根据inorder索引前的数的个数，找到left tree的preorder** ——> **根据得到的preorder和inorder递归求出left tree** ——> **同理，right tree也是**

* 所以这就涉及到一个问题：**left tree的inorder、preorder是原传入数组的子数组**，我们要得到子数组，在这个问题上，我又犯了之前犯过的错：把数组转换为list，利用list自带的method求出子list，费时费力费内存，之前遇到过一次了，再次遇到还是走老路，这很严重的现象。。。之前这么多道题没有总结是个错误，以后每天都要总结完，并且思考学习吸收的地方，有些代码比较难可以背一背。

* 上述子数组问题：**靠一个start pointer和一个end pointer就可以解决，因为我们知道了一个子数组的start pointer和end pointer，就相当于知道了里面的所有元素了**，同时我们调用递归函数时，其实也只用到了preorder[pstart]这个元素，剩下的又再次拆解成子数组。

* **根据根结点找到其在inorder中的索引**：这个问题可以通过创建一个map将最开始完整tree的inorder数组的元素和其索引映射，get(key)就可以得到每一个root的索引。

* 算法很重要，数据结构同样重要（ArrayList对于时间复杂度真的可怕），一些重复计算如果可以只计算一次更可以节省时间（不过可能需要多创建一个变量保存之了，这是一个博弈？）

# 106 Construct Binary Tree from Inorder and Postorder Traversal
105的变形题，这次是根据inorder和postorder的结果进行构建tree

方法是一样的，two pointers + recursion + 分清inorder和postorder这两个数组的组成成分。
