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
