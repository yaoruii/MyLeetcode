# Path Sum I II III

## 112 I:
Given the below binary tree and sum = 22,:
```
      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
```

## 113 II:
Given the below binary tree and sum = 22,:
```
还是上边那个树
return：
[
   [5,4,11,2],
   [5,8,4,5]
]
```
这道题之前写过，用的是257的方法，但是太慢了，8%，后来就搁浅了

## 437 III：
The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes)
```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```
