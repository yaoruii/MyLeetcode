# 992 Subarrays with K Different Integers
```
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
```

**这道题之所以不可以用相似题：[340最长的至多包含K个不同元素的子字符串](https://github.com/yaoruii/MyLeetcode/tree/master/Sliding_window/159%E6%B1%82%E6%9C%80%E5%A4%9A%E5%8F%AA%E5%8C%85%E5%90%AB%E4%B8%A4%E4%B8%AA%E5%AD%97%E7%AC%A6%E7%9A%84%E6%9C%80%E5%A4%A7%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%95%BF%E5%BA%A6)是因为：本题不是让求最长的那个长度，而是所有满足条件的子数组，包括最长最短及中间长度的所有可能结果。**

**同样都是找出所有符合条件的子数组，和相似题:[713Subarray Product Less Than K](https://github.com/yaoruii/MyLeetcode/tree/master/Two_Pointers/713SubarrayProductLessThanK)一样，为了找出所有的可能数组，无论长度为多少：**
* **当end固定后，以end结尾的所有子数组的个数为end-start+1，即滑窗的长度。**
## two sliding windows: 144ms,5%
* Create two windows with a 'given end ptr' --> Note, this is very important. End ptr will always be fixed and same for the two windows in any given iteration.
    * i. First window is where the startPtr points such that the given subArray has <= K distinct integers
    * ii. Second window is where the startPtr points such that the given subArray has < K distinct integers
* VERY IMPORTANT - For a given array of length 'N' and 'always ending with last element', number of possible sub-arrays = N
With above concept,
    * i. Number of possible sub-arrays of first window = N (with <= K distinct integers)
    * ii. Number of possible sub-arrays of second window = M (with < K distinct integers)
* Total number of sub-arrays with 'exactly' K distinct integers = N - M,  
  since N = endPtr - startPtr1  
  and M = endPtr - startPtr2  
  N - M = startPtr2 - startPtr1  
  Continue doing this till endPtr iterates from start till end of the input array

**看了其他人对上述描述的实现代码，牛逼啊，基本上就像伪代码一样把上边的捋了一遍，任重道远啊**

## 
