#  310. Minimum Height Trees

# ARE：
* label都是0——(n-1)的整数
* if(num != n-1) return res;//该graph无法成为一棵树。num是edges数组的长度

然后我就想对每一个node，一共n个，使用bfs，算出来每一个node作为root时候的hight。

可以尝试一下啊。

但是我没写，我还是看了答案。。答案的方法，如下图：

![](https://tva1.sinaimg.cn/large/007S8ZIlgy1gfc06fxa9lj30a00dcgmg.jpg)

# DC：
* 使用一个` List<HashSet<Integer>>`来描述graph，具体的代码：
```java
        List<HashSet<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n;i++) graph.add(new HashSet<>());
        for(int[] edge:edges){
            //get什么玩意啊，你还没往list里面加东西呢
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
```

