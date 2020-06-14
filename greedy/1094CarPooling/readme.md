# 1094. Car Pooling

# After Reading Exercise：

我想的也是：变量num表示车上的人，**遇到新的人就加进去，遇到drop off，就把人减出去，始终保持num变量的值小于等于capacity即可**

但是，开始写代码后，先将数组按照开始位置排序（因为会先被接），把人数加进去，然后遍历下一个区间i，如果，此时已经有drop发生于该区间i之前，那么把相应的人数减出去，由于drop的不一定是第i-1个区间对应的人数，所以，需要使用一个priorityqueue去记录所有的drop处的position，每次poll()最小的，直到在第i个区间的开始位置之前的所有的drop的position和人数都被处理，再加上第i个区间的人数，把第i个区间的drop的position也放入到priorityqueue中。

写的代码：
```java
int num = trips[0][0];
if(num >capacity) return false;
PriorityQueue<Integer> drop = new PriorityQueue<>();
drop.offer(trips[0][2]);
for(int i = 1; i<n;i++){
    while(drop.size() != 0 && trips[i][1]>=drop.peek()){
        //num -= drop.poll();//你他妈为啥要减end position？？？？
    }
    num += trips[i][0];//if pick up,是否会超过cap？ 
    drop.offer(trips[i][2]);
    if(num >capacity) return false;
}
return true;
```
**bug在于：priorityqueue的元素是drop position，没有对应的需要drop掉多少人的人数。如果，要记录人数，就要使用map，pq里面保存的是map.entry，根据entry.key进行排序的结果**

**如果，选择沿着坐标系走，遍历坐标系，而不是区间，得到坐标系上的每一个point处对应的num，check每一个num是否大于capacity**

**怎么得到坐标系上的每一个point处对应的num：**

**回答：**  
* 遍历区间，记录每一个位置上人数的**变化量**：pick up means plus x persons, drop off means - x persons 
* 于是，某些位置是正数，某些位置是负（代表下车的人数），剩下的位置是0，人数不变，只需要关心位置上是正负数的pointer.
* num = 0，然后，去遍历位置上是正负数的pointer，与num相加，如果存在num>capacity的情况，返回false，否则，返回true；

# DC：
## 使用一个大小为1001的数组，记录变化量，因为已知 0 <= trips[i][1] < trips[i][2] <= 1000，最多也就有1001个points出现
* n的时间复杂度。

```java
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips==null || trips.length ==0) return true;
        int[] points = new int[1001];
        for(int[] trip: trips){
            //记录起点和终点的人数变化量
            points[trip[1]] += trip[0];
            points[trip[2]] -= trip[0];//下车，所以要减；
        }
        //将变化量累加，就是第i处的人数。
        int num = 0;
        for(int point: points){
            num += point;
            if(num>capacity) return false;
        }
        return true;
    }
}
```

## 使用treemap：解决了之前说的pq+map的问题，map自身就是有序的了，一个个地遍历即可！

* 使用map映射每一个位置的**变化量**，而不是一个space=1001的map。
* 剩下的和上一个方法都一样：累加变化量就是当前的结果。
* nlog(n)
* 不如数组的方法performence好。

```java
TreeMap<Integer, Integer> points = new TreeMap<>();
for(int[] trip:trips){
    points.put(trip[1], points.getOrDefault(trip[1], 0)+trip[0]);
    points.put(trip[2], points.getOrDefault(trip[2], 0)-trip[0]);
}
int num = 0;
for(Map.Entry<Integer, Integer> entry: points.entrySet()){
    num += entry.getValue();
    if(num>capacity) return false;
}
return true;
```


