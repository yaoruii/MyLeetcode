# 487. Max Consecutive Ones II
```
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
After flipping, the maximum number of consecutive 1s is 4.
```

## 有人把这道题转换成76题那个hard题的滑窗法，叹为观止啊！！！！感觉159也可以这样，一会试试。

**题目转换：连续的1，至多包含1个0 ------->>>>>>>> 寻找最多包含 K=1 个0的子数组长度。**

**所以，经过上述的转换后，就可以转换思路为：追踪0的个数，一旦大于K个，当前right和left的配对结束，进入while循环，把当前的left去掉：**
* 如果当前的left是0，那么追踪0的个数的变量要减一
* 如果当前的left不是0，则什么都不做
* 最后left++，相当于右移了一位。

**注意：一旦进入while循环，说明当前的left已经寻找结束，如果在while循转里面计算max= math,max(max, right-left）有一个缺点就是，如果最后right一路到最后一个元素，都符合条件，无法进入到while循环，那么还需要最后
* 如果当前的left不是0，则什么都不做的
* 如果当前的left不是0，则什么都
