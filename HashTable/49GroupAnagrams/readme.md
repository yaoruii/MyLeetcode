# 49. Group Anagrams

看了答案，牛逼啊。。靠。。唉任重而道远。

## HashMap: 6ms,98%

**核心：两个字符是同字母异序词，那么他们俩个的排序后的字符串是一样的**

所以，对每个i元素进行排序，得到它的排序后的结果，将排序后的string作为key放入到map中，value是新建一个空的list，而排序前的string加入到这个list中。当遇到anagrams的时候，排序后的结果已经存在map中，只需要将排序前的string加入到value这个list中即可。

**如何对字符串排序？**

调用```char [] c = i.toCharArray()```将字符串转换为字符数组，调用```Arrays.sort(c)```对数组进行排序，然后再调用```String new = String.valueOf(c)```,得到排序后的string。

**为什么对字符数组排序后，不直接将其作为map的key，还费事转换为string？**

https://blog.csdn.net/codejas/article/details/78837830
设计Hashcode()最重要的因素就是：**对同一个对象调用code（）会产生同样的值！而String数据类型对这一性质有很好的支持，因为，String的hashcode()是根据内容设计的，而不是根据地址设计的**，如果直接用字符数组c，得到的hashcode是根据地址设计的，大家都不一样。
