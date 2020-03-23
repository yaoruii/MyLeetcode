# Union_Find
## Quick find

**数据结构**：

* 整数数组 id[] 代表N个元素所处的set的ID
* p和q是联通的，如果，they have the same id.

**Find:**

* Check if p and q have the same id

**Union:**

* 为了将p和q所在的set结合，要将所有和p的id一样的entries的id: id[p] 改成 id[q].

**Quick find is too slow:**

把获取数组的次数当作cost model的话：number of array accesses

* 初始化：N
* Find: 1
* UNION: N

## Quick Union

**数据结构**：

* 整数数组 id[] 代表N个元素各自的父母，id[root] = root自身
* p和q是联通的，如果，p和q的root是一样的。

**Find:**

* Check if p and q have the same root

**Union:**

* 为了将p和q所在的set结合，将p的root的id 改成q的root。即将p的root成为q的root的一个孩子。

**Quick union is also too slow:**

把获取数组的次数当作cost model的话：number of array accesses

* 初始化：N
* find： N
* Union:  N † (因为包含在union过程中，进行的find p's and q's root 的过程)
* tree可能变得非常高，Find()会很expensive.

## Weighted Quick Union 

为了防止qu中的过高的tree, 改善为：Weighted Quick Union

* keep track of the weight(size) of every tree: 引入一个数组 size[]，记得在union后更新size的大小
* Balance by linking root of smaller tree to root of bigger tree.

**Runtime**

* Find 花费的时间和p、q的深度成正比
* Union: constant time, given root
* Depth of any node x is at most lg N.
* 初始化：N
* find： lg N
* Union: lg N †

## + path compression

改善二：+ 路径压缩

**在计算完p的root后，将每一个被检查过的node都直接指向该root**

有两种实现方法：

* 在root()函数中加入第二个loop, 将每个被检查过的node的ID设为root
* 将每一个被检查的node的ID指向它的祖父：id[i] = id[ id[i] ]，将路径减半。
* 这两种方法在实际操作中都很好

