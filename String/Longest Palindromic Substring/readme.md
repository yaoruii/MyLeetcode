# 寻找最长的回文子字符串
**这道题和最长回文subsequence的区别！！**

**我的思路:**
之前有题：寻找最长无重复字符的子字符串，在那里学习了滑窗的理念，所以在这里，我首先固定start，对end遍历整个字符，但是**对于每一个end，在判断start-end之间的子字符串是否是回文之前，先确认start和end出的字符是否一样因为如果连首尾字符都不一样那么也没有继续确认的必要,一样的话传入整个字符串进行判断**，最后如果子字符串是回文，将该字符串赋值为res，end要继续遍历到末尾，并不断更新res，end到末尾的时候，完成该start的遍历。
之后start++，我们在上一轮遍历中保存最长回文的palin_end，如果palin_end已经是字符的末尾，那么可以直接返回了，因为start++，只会让字符串变短；如果palin_end比此刻的start大，那么此刻的end可以从palin_end+1开始，因为start-palin_end无论是不是回文都会比之前的res短，palin_end<start：start= end+1
遍历完所有的start<len


