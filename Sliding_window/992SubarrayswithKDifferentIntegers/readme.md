# 992 Subarrays with K Different Integers
```
Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers:  
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
```

**这道题之所以不可以用相似题：[340最长的至多包含K个不同元素的子字符串](https://github.com/yaoruii/MyLeetcode/tree/master/Sliding_window/159%E6%B1%82%E6%9C%80%E5%A4%9A%E5%8F%AA%E5%8C%85%E5%90%AB%E4%B8%A4%E4%B8%AA%E5%AD%97%E7%AC%A6%E7%9A%84%E6%9C%80%E5%A4%A7%E7%9A%84%E5%AD%90%E5%AD%97%E7%AC%A6%E4%B8%B2%E9%95%BF%E5%BA%A6)是因为：本题不是让求最长的那个长度，而是所有满足条件的子数组，包括最长最短及中间长度的所有可能结果。所以是把每一个right得到的个数加在一起。**

**同样都是找出所有符合条件的子数组，和相似题:[713Subarray Product Less Than K](https://github.com/yaoruii/MyLeetcode/tree/master/Two_Pointers/713SubarrayProductLessThanK),两题的不同之处：713是乘积小于K，即至多K，无论是多少只要小于K即可，992如果也是至多K个不同的元素，即map.size()<=K,那么就是一道经典的滑窗题，和上边的340一样。子数组的个数：**
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

## holy shit!!!!!转换为：求至多包含K个不同元素的题
就像上边分析的那样，至多K个不同元素很经典，那么K个元素只需要往前再进一步：   
* **exactly(K) = atMost(K) - atMost(K-1)**
* 但是时间并没有提升
* 但是不管了，我稀罕这个方法

# 930. Binary Subarrays With Sum
```
Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
```
**和992一道题：至多s个1，很简单，遍历到当前的right就去帮right配对，找子数列最多的left(即最小的left),然后把所有的right的个数加在一起，就是所有的个数。**



