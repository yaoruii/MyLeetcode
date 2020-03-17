# 159 Longest Substring with At Most Two Distinct Characters

```
Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
```
## hashMap + sliding window : 66%
* 使用一个hashMap去在right遍历字符串的时候，把right对应的字符保存在里面，当map.size()>2的时候，不再满足条件：move on left:获得当前的left，让他在map中的value--，如果减完后，它的value=0了，说明当前窗口不再有这个字符了，要将其移除出去，然后再次进行判断是否满足条件。不满足，继续move on，满足的话退出while循环。
* 如果加入right的字符后满足条件：**因为是最大问题**，所以不进入while循环，而是直接去更新max，然后right++;

# 340 Longest Substring with At Most K Distinct Characters（general 版本）

## 同上

## 有人用数组代替HashMap去追踪字符及其个数：97%

* 上边的方法是使用hashmap去追踪right的遍历过程，所以可以用数组代替
* 定义一个长度为256的整型数组，int[256]，索引是当前被遍历的字符的ascii码，碰到这个字符，让对应的数组值++，同时再定义一个counter，当当前的right对应的数组值++之前如果是0的话：**第一次遇到这个字符**，counter++。
* 满足条件： counter<= K，不满足条件：counter>k，进入while循环：move on left：数组值--，如果减完后等于0，记得把counter--
* 退出while循环，Max问题：更新结果。
