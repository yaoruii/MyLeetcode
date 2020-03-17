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

**注意：一旦进入while循环，说明当前的left已经寻找结束，如果在while循转里面计算max= math.max(max, right-left）有一个缺点就是，如果最后right一路到最后一个元素，都符合条件，无法进入到while循环，那么还需要最后退出整个while(right<len)循环后，再次计算一下max= math.max(max, right-left），代码就很丑。**

**上述和209这道题的区别：209是求最小的size，所以一旦满足条件，我们就进入while循环，在while循环内部计算min = math.min(min, right-left+1),如果一直不满足条件，一直不进入while循环，直到最后退出大的while循环，最后的right和left依旧是不满足条件的一对，所以不需要再最后再次计算一下**

**但是本题487和159是求满足某个条件的最长的size，*其实是一旦不满足条件*，我们进入while循环，所以不能在while循环内部计算max= math.max(max, right-left），因为*可能要最后的要退出大while循环了，依旧是满足条件的，这个时候的长度也要考虑进去就要在最后再计算一次，比较丑陋***

**上边是解释了这几题的一点小区别，但是本质上487还是209题，求最长的XXXXXXXXX的数组长度**

# 487的follow up:
```
while(right < len){
            if(nums[right]==0){
                //遇到0了，更新0的个数
                zeros++;
            }
            //看看现在几个0了，符不符合条件：符合就更新max,继续配对合适的right
            //不符合就进入while循环，配对结束：不需要更新max，因为符合的时候一直都在更新
            while(zeros>k && left<= right){
                /*这一个if语句 + while循环其实相当于我的方法中的：
                不满足条件后，移动left到当前窗口0的下一个位置：
                即：left=track
                */
                if(nums[left++] == 0) zeros--;//把left的更细写在[]中，美啊
                //因为无论nums[left]和0什么关系，它都要++，所以写进去很简洁
            }
            max = Math.max(max, right - left +1);
            right++;   
        }
        return max;
```
这是原题的代码
