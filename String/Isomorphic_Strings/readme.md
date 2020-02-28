# Isomorphic Strings

比较两个长度相等的字符串是否具有相同的**Pattern**：

>Input: s = "egg", t = "add"
>
>Output: true
>
>Input: s = "foo", t = "bar"
>
>Output: false

其实这道题一开始也隐约觉得要用Map，但是想不出来怎么用，也知道是和索引相关。

## **我的解法：依旧时间过长，5%**

对i个字符找和其一样的字符，把他们的索引放在一起，比如，i=0的时候，得到[0]和【0】，两者完全一样，继续看i=1,得到[1,2]和[1,2]两者完全一样，如果不一样，返回false,然后i=2，已经mark了，因为i=1的时候就将i=2的元素放进去了，结束。返回true。

依旧是固定一个i，遍历完所有的元素，然后遍历i，所以是n的平方

## **把字符作为数组的索引，因为字符用ASCII码表示：4ms,88%**

>my solution will work only for ASCII. :) For Unicode we need much bigger arrays - of length 2^16
>
>there are 256 characters in ASCII, 0-127 for basic ASCII, 128-255 for extended ASCII.

字符是数组中的索引，字符在字符串中的位置是数组对应的value。所以当遍历到i时，如果两者的字符都是第一次遇到，访问value = 默认的值0，那么在各自的字符索引处附上i+1，下一次再次遇到该字符时，访问value是之前的i+1！！（**要加一**）。由于特性，**每次遇到已经遇到过的字符，同样的字符两者也在曾经同时遇到，所以value永远一样**，否则无此特性。

**这种方法，利用了如果是第一次遇到某字符，其对应的value是0，如果不是第一次遇到就是一个正数，上次的位置，两个数组检索到的value要一样：上次出现的位置也一样**

