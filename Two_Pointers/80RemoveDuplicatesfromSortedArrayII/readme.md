# 80. Remove Duplicates from Sorted Array II
```
Given nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

It doesn't matter what you leave beyond the returned length.
```
## two pointers : 0ms 100%
每个元素至多出现两次，如果大于两次了，就被删掉，但是**不使用额外的内存，所以要在nums数组的基础上直接赋值，定义一个real_index追踪要被重新赋值的位置的索引**
* 两个pointers，一个指向新元素nums[i],另一个j=i初始化，然后通过while循环，向右移动j，计算相同的nums[i]有多少个。
* 计算完了之后，得到了nums[i]出现的次数了。
   * 如果time ==1: 把read_index出的值assign为nums[i]
   * 如果time >1/2,3,4...，那么把real_index和real_index+1处的值赋值为nums[i]
   * 每次assign完，不要忘记把real_index++
* 同时，此时的j指向的一个新元素了，进行下一轮的for(i..)循环前，我们要把i=j，从而让i再次指向新元素
* 最后，返回real_index即可
```
class Solution {
    public int removeDuplicates(int[] nums) {
        //uch that duplicates appeared at most twice and return the new length.
        int len = nums.length;
        int times;
        int j ;
        int real_index =0; /*use this variance to track which index needed to be assigned*/
        for(int i = 0; i< len; ){
            j  = i;
            times = 0;
            while( j< len && nums[j] == nums[i]){/*while loop to calculate how many time nums[i] appears*/
                times ++;
                j ++;
            }
            nums[real_index]  = nums[i];/*no matter times nums[i] appears,the first asignment is always needed*/
            if(times>=2){   /*if there are two or more nums[i], then the second one is also needed*/
                real_index ++;
                nums[real_index]  = nums[i];
            }
            i = j; /*i = j , begin to track the new different element for the next for loop*/
            real_index ++;
        }
        return real_index; 
    }
}
```
