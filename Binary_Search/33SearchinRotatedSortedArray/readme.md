# 33. Search in Rotated Sorted Array

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

## 我的方法：有点奇怪，而且是o(n),我才意识到：0ms，100%。。

When I worked on the ```exercise 33,Search in Rotated Sorted Array```, I first find the new index ```i ```of the element in index 0 in the original array which is also sorted array, and then I apply ```BInary Search``` on the first part of the rotated sorted array which begin from index ```0``` to ```i-1``` when the target is bigger than nums[0], otherwise I apply ```BInary Search``` on the second part of the rotated sorted array which begin from index ```i``` to ```nums.length -1```. 

So this is the solution to exercise 33, but when I worked on this one, I realise that the first part of solution to exercise 33 is the answer to this one.

It also is the answer to exercise 154, beacuse whether there are the same element does not effect the result. The element in ```i-1``` is the last element in original array, the element in ```i``` is the first elemnt in array, so the first one is definitely bigger than the second one, even if they are the same, which mean all elements in original array is the same.

**exercise 33 :**
```
class Solution {
    public int search(int[] nums, int target) {
        //0的情况；
        int len = nums.length;
        if(len == 0) return -1;
        //find the first element of the original array
        int i = 0;
        while(i< len-1){
            if(nums[i] <= nums[i+1]){
                i++;
            }
            else break;
        }
        //find which part of the rotated array we should apply binary search to based on target
        int lo ;
        int hi ;
        if(target == nums[0]) return 0;
        else if(target > nums[0]){
            lo = 0;
            hi = i;
        }
        else{
            lo = i+1;
            hi = len-1;
        }
        int mid ;
        while(lo <= hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) lo = mid+1;
            else hi = mid-1;
        }
        return -1;
    }
}
```

**exercise 153**:
the first part of the above code is enough:
```
public int findMin(int[] nums) {
        //You may assume no duplicate exists in the array.
        //emmmm。这就是33题的前半部分啊。。
        int len = nums.length;
        //找到最小值所在的位置
        int i = 0;
        while(i< len-1){
            if(nums[i] < nums[i+1]){
                i++;   
            }
            else break;
        }
		//maybe the rotated array is the same as the original array 
        if(i == len-1) return nums[0];
        return nums[i+1];
    }
```
**emmmmm，所以用这个思路把33，81，153，154这四题全部给做了，还去发了一个post，然后我才意识到我根本没用binary search啊，而且我时间复杂度是o(n),我觉得不行。。。。。。。。。。。。。。。。。。。。。。需要重写。。。。。。。。。。。。把帖子删了吧。。。。。。。。。。**

## hhhhh,看了一下，我是寻找最小的元素的索引那块，也就是153题是o(n),整体的33题思路是对的，所以要把153二分查找学习一下
```
public int findMin(int[] nums) {
         int len = nums.length;
	int lo = 0; int hi = len-1;
	if(nums[lo] < nums[hi])  return nums[lo];
	int mid;
	while(lo < hi){
	    mid = lo + (hi-lo)/2;
	    if(nums[mid] < nums[hi]){//说明mid和end at the same part,因为是增序
		//最小的元素可能是mid或者在mid的左侧
		//所以end=mid，下一轮继续和end比较
		hi = mid;
	    }
	    else{//mid> hi元素，说明处于不用的part，mid在前一个,hi在第二个
		//最小的元素一定在mid的右侧，所以lo = mid+1
		//mid= hi元素。。。鉴于没有重复的元素，不会发生
		lo = mid+1;
	    }  
	}
	return nums[lo];
	}
```
**所以上述代码用于33题➕153题**

**至于81题➕154题：上述两题的数组有重复元素的变形题**
**区别在于：当nums[mid]==nums[hi]的时候：如果当前的hi 就是结果，那么nums[hi-1]是最大的元素，大于当前的hi，否则，直接hi--即可
```
public int findMin(int[] nums) {
        int lo = 0; int  hi = len-1; int mid;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] < nums[hi]){
                //处于同一个part，最小值为mid或者在mid的左侧
                hi = mid;
            }
            else if(nums[mid] > nums[hi]){
                lo = mid+1;
            }
            else{//mid == end,无法确定最小值在哪一部分，只好hi--
                //但是在hi--的过程中，可能就错过了用于84题的最下值的索引
                //所以就像你自己的方法的核心是一样的，如果前个数比当前的hi大，那么hi就是结果
                if(hi!=0 && nums[hi] < nums[hi-1]){
                    lo = hi;
                    break;
                }
                else hi--;
            }
        }
        return nums[lo];
```

