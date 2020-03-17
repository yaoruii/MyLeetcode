# 76. Minimum Window Substring

## 非常典型的sliding window + hash table + string 题目

* 使用hashmap先把target的字符的情况记录下来。然后，使用right遍历s字符串，将right处的字符保存在windowmap中，**如果这个字符存在map中同时这个字符在两个map中的value一样，那么counter++**
* 当counter== map.size()(字符串t不一样的的字符数时), 字符串t中所有的字符都在该滑窗内了，**满足条件：进入while循环，更新min的值，move on left:**
* 把left的值从windowmap中去掉（value--），如果t字符串中有这个字符，这个时候check一下，windowmap中的该字符的个数是否小于了map中的value，如果小于了，说明该字符被去掉后，我们无法满足全部包含的情况了：**counter--;**, 然后等到count < map.size()的时候，退出while循环，结束了left的move on。
* 退出后，right++，进入下一轮的大循环。
