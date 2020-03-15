# 209. Minimum Size Subarray Sum

## two pointer:
本题的two pointers有点不太一样，看似和滑窗法类似，但是又不太一样，很有意思的一题：
* 首先想到定位start为0，然后向右移动end指针，++，直到碰到一个数，让这之间的数组元素加在一起大于等于k，此时，```end-start+1```是以start为起点的满足条件的子数组的长度。
* 然后，想到要开始移动start了！按照之前写过的滑窗题，此时的start减小了，end不变，所以此时的子数组不满足条件？？？，**但是问题就出在这里：此时start减少了，sum一定减少，但是此时的sum还是有可能大于等于k的，因为我们不知道上一个sum大于k多少，也许减去一个值，它还是大于k的**
* **then this is where i am stuck**
* 方法：start往右移动后，开始寻找：当以新的start为起点的时候的最小数组长度，end作为上一个start的末尾先不变，**判断一下当前end是否已经满足要求**：不会出现比当前end更小的end满足当前start了，因为当前end是基于上一个start的配对，也就是说加上上一个start，才满足条件，所以不会出现新的start配更小的end，所以当前start要么和当前end配对，要么不满足要求，继续迭代end
* 如果，此时的end和start配对，那么我们结束当前的start，继续保持end不变，start++，直到碰到一个start使得当前end无法满足条件了，再往右的start更无法满足了，这个时候开始遍历end++，找到合适的end后，计算出当前start对应的len，然后start++，继续上一点的tech。
* 上一点和上上一点的tech，注意：**start要永远小于等于end**

## follow up: binary search:

>If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 

这个题有个follow up，让我们用o(NlogN)的时间复杂度去求解，很明显地，在考察我们二分。
