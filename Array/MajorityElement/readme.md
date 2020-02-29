# 169 Majority element

>Given an array of size n, find the majority element. The majority element is the element that appears more than **⌊ n/2 ⌋ times.**

## 我的解法：使用Map:

可以用一个map，key是该元素，value是该元素出现的次数。

当第一次遇到某元素时，map中无该对应关系，getOrDefault()会返回-1，这个时候将（该元素，1）放入map。第二次遇到这个元素的时候，就存在这个关系对了，所以getOrDefault()返回的是1，然后我们将返回的value+1，并put入新的关系对。

同时使用一个整数记录较大的value，遍历完后，直接返回该整数即可，不需要再去从Map中找最大value。

## 排序法：震撼啊
**Arrays可以直接调用sort()函数进行排序。**

先将nums进行排序，那么出现**大于⌊ n/2 ⌋ times.** 次的这个元素一定覆盖了 n/2，直接返回(nums[n/2])
>假设最多元素是最小值，当n是偶数时，那么该元素至少出现到（n/2+1），当n是奇数时，那么中心是（n/2+1），那么至少出现到（n/2+1）
>
>同理，当该元素是最大值时，距离末尾（n/2+1）。上述都是位数，所以索引是n/2


## 217 变形题：Contains Duplicate
>Given an array of integers, find if the array contains any duplicates.
>
>Input: [1,2,3,1] Output: true

根据上边的思路，可以用map，直接value一旦有==2的就返回true，也可以用sort()完后，i和i+1的元素相等即是有重复。

## 219.变形题： Contains Duplicate II

>Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
>
>Input: nums = [1,2,3,1,2,3], k = 2
>Output: false

这道题用map可行，sort改变了内部结构不行。

如果是第一次遇到该元素，将其put()进去，value是**该元素的索引，因为，当下一次遇到相同的元素时，我们要关注的是，此时的索引和已经被保存的索引的差值，如果该差值小于等于k，可以结束返回true，如果大于，我们将新的索引填入其中，因为下次再遇到新索引，没有理由和老索引比较**，最后，遍历完所有元素，也没遇到可以返回true的，返回false
