# 451. Sort Characters By Frequency

```
Given a string, sort it in decreasing order based on the frequency of characters.根据出现的频率对字符串进行重写排序。

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
```
**347的变形题**：因为首先肯定是要求每个unique字符出现的频率，求出来后，得到基于频率的字符排序的结果，从大到小，gather这些字符，并根据对应的频率，重复每个字符对应的次数，一摸一样的题。

## heap 

## bucket sort

