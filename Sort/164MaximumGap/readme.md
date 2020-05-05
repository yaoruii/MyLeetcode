# 164. Maximum Gap

```
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
```
**要求：Try to solve it in linear time/space！！！所以，一般的先对数组进行排序，然后再一个个遍历相邻的psir求的最大的gap不行**

## 桶排序
* 将元素分别放进相应的桶中，同时控制好桶内的interval的大小，使得桶内的相邻元素之间的gap不会是最大的gap，这样，只需要计算桶和桶之间的gap:上一个桶的最大的元素和这个桶的最小的元素的差，同时两个桶之间如果有空桶，直接跳过空桶即可
* 设最大的gap为t，那么t能取的最小值就是```b=(max-min)/(n-1)```,n是数组的元素个数，n-1是空隙的个数，在所有gap都平均的情况下，t为这个数，一旦不平均，t会增大
* 因此，将interval设为b，在一个桶内的数的范围为```[min+(k-1)b, min+k*b)，比如：[min, min+b)是第一个桶的范围。
* b的计算可能除尽也可能无法除尽，如果可以除尽，最后的max就无法被包含在桶中，因此，无论哪种情况max不要放进桶中。min可以放也可以不放，简单起见，别放了
* b无法除尽时，向上取整，因为右侧区间是取不到的，所以5.5向上取到6，还是会包含5，不包含6，数组元素都是整数。
* min/max不放进去，就剩n-2个数，有n-1个bucket，所以一定有桶是空的，所以，一定存在两个桶，之间的gap大于interval即b
* 实际操作的时候，只需要记录每一个桶的max和min值，用两个数组，把每一个属于该桶的nums[i]和原本的min/max比较，更新得到min/max
* 遍历完数组，得到每一个桶的最大最小值后，遍历桶，得到最大的gap，记得跳过空的桶：max为初始值-1的桶。


