# 49. Group Anagrams

看了答案，牛逼啊。。靠。。唉任重而道远。

## HashMap: 6ms,98%

**核心：两个字符是同字母异序词，那么他们俩个的排序后的字符串是一样的**

所以，对每个i元素进行排序，得到它的排序后的结果，将排序后的string作为key放入到map中，value是新建一个空的list，而排序前的string加入到这个list中。当遇到anagrams
