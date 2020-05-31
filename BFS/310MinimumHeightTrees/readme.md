#  310. Minimum Height Trees

# ARE：
* label都是0——(n-1)的整数
* if(num != n-1) return res;//该graph无法成为一棵树。num是edges数组的长度

然后我就想对每一个node，一共n个，使用bfs，算出来每一个node作为root时候的hight。

可以尝试一下啊。
