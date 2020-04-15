# 547. Friend Circles

```
Input: 
[[1,1,0],
 [1,1,1],
 [0,1,1]]
Output: 1
Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends, 
so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
```
**把547这道题放在了323里面，是因为这道题是披着2d的皮的1d的问题，和323几乎一样一样的**：
* 首先，求多少个朋友圈 == 求有多少个集合，每一集合就是一个set =====》》》 union-find问题
* 2d的形式表示人和人之间的edges关系：m[i][j] ==1:i和j是朋友 ======》》》 edges[i][0]和edges[i][1]是朋友。
* 遍历m，找到1元素的i和j，然后union(i,j)，和323一摸一样，使用路径压缩。
