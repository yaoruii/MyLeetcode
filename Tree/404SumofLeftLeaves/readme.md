# 404. Sum of Left Leaves

求所有的左叶子的val的和

## 借鉴102和103，自己写的BFS法：100%，84%
this one is just like 102 and 103, we can see it as level-level traversal but put those nodes that are someone's left children into a queue called l, put those nodes that are someone's right children into the other queue called r. We all know that if one node is someone's right child, it will never be added, so the elements in r we juet poll() them, then find those's children and put children into correct queues. But for elements in L queue, there ara some nodes which are leaf, when we meet them, we sum theirs val together, if it is not a leaf, what we do is the same as what we do to the elements in r queue. When we process all elements in the two queues, we can return sum.


## 学习别人的递归法：100%，98%
base case :
会
base使sum
