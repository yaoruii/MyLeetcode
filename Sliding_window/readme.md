# sliding window

## 绝了，有个人总结了一套模版，先码一下：在159题那里总结的
<https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.>

> 看了一下真的挺牛逼的，因为非常general！！！

可以针对的题目有：
### 1, [76题，包含target字符串t的最短的sunstring](https://leetcode.com/problems/minimum-window-substring/)

### 2，[3题，最长的不含重复字符的substring](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

### 3, [159题，最长的至多只有两（K）个不同的字符的substring](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)

### 4, [438题，找到所有的同字异形的substring](https://leetcode.com/problems/find-all-anagrams-in-a-string/)

其实，他这个模版就是之前总结的那个移动right，看是找最大size还是找最小size，来确定是满足or不满足的时候改为移动left。但是有一点很值得借鉴：**他是针对string的sliding window，所以好多题可能需要用到map去追踪字符串s和t**

在第76题和第438题，该方法只把target的字符保存在map中，在遍历source的时候，如果遇到了map中的字符（也就是t中的字符），就把map中对应的value减一，直到map中所有的元素的value都等于0了，说明找到了包含所有的字符的字符串，省了一个map
