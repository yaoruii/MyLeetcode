# 寻找最长的回文子字符串
**这道题和最长回文subsequence的区别！！**

**我的思路:**

之前有题：寻找最长无重复字符的子字符串，在那里学习了滑窗的理念，所以在这里，我首先固定start，对end遍历整个字符，但是**对于每一个end，在判断start-end之间的子字符串是否是回文之前，先确认start和end出的字符是否一样因为如果连首尾字符都不一样那么也没有继续确认的必要,一样的话传入整个字符串进行判断**，最后如果子字符串是回文，将该字符串赋值为res，end要继续遍历到末尾，并不断更新res，end到末尾的时候，完成该start的遍历。

之后start++，我们在上一轮遍历中保存最长回文的palin_end，如果palin_end已经是字符的末尾，那么可以直接返回了，因为start++，只会让字符串变短；如果palin_end比此刻的start大，那么此刻的end可以从palin_end+1开始，因为start-palin_end无论是不是回文都会比之前的res短，palin_end<start：start= end+1

遍历完所有的start<len

该方法可行，但太慢，**而且确认start和end出的字符是否一样后，进行的回文判断，可以采用动态编程(DP)的思路，这样就不需要每一个字符串都判断一遍了**

**动态编程**

假设长度为n,建立一个[n][n]的二维数组，保存以(r,c)的子字符串是否是回文，这样判断完start和end出的字符是否一样后，只需要从表格中读取[start+1][end-1]这个是不是回文即可

This yields a straight forward DP solution, which we first initialize the one and two letters palindromes, and work our way up finding all three letters palindromes, and so on...

**从中心扩展**

回文字符串的长度如果是奇数，那么中心就是一个字符，如果是偶数，中心是中间两个元素，且这俩元素相同。

于是从中心扩展，最开始有1个或者两个元素，然后头尾往外扩展，新的元素要相同，一直扩展直到不相等，这个时候返回回文的字符串的长度，由于i是中心的开头，会从0遍历到末尾，也就是所谓的start，所以一个start可能是奇数个字符的中心，也可能是偶数个字符的左侧中心，所以一共有2n-1次的中心扩展（调用相关函数）
> 奇数个中心扩：expend(s, i,i);
>偶数个中心扩：expend(s, i, i+1);







