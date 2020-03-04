# 404. Sum of Left Leaves

求所有的左叶子的val的和

## 借鉴102和103，自己写的BFS法：100%，84%
this one is just like 102 and 103, we can see it as level-level traversal but put those nodes that are someone's left children into a queue called l, put those nodes that are someone's right children into the other queue called r. We all know that if one node is someone's right child, it will never be added, so the elements in r we juet poll() them, then find those's children and put children into correct queues. But for elements in L queue, there ara some nodes which are leaf, when we meet them, we sum theirs val together, if it is not a leaf, what we do is the same as what we do to the elements in r queue. When we process all elements in the two queues, we can return sum.


## 学习别人的递归法：100%，98%
base case :
会使sum有所增加的base case:  
**root.left!=null && root.leaf.left == null && root.lefe.right == null**  
因为：我们认为光秃秃的root是0，不是leaf，所以必须要借由真正的左Leaf的parent-上式的root去access the left leaf. 这样是方便的，因为这样就不用判断某一个光秃秃的node是不是左leaf了，因为我们不判断光秃秃的node了。right leaf压根没有被加的机会，只会沦为光秃秃的node后被返回0.
