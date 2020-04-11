# 349/350 Intersection of Two Arrays i 和 ii
```
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2](350题）
output: [2](349题）
```

```
350题还带了一系列的follow up：
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
```
## Hash Table:
对于349，最终只需要返回一个unique element即可，所以，可以使用hashmap或者hahset，把nums1遍历一遍，放入map或者set，本题set即可，因为set内保留的就是unique的元素，和map一样，唯一的区别就是map中还有对应的次数，可是349中次数并不重要。

之后，遍历nums2，对每一个元素，看看set/map中是否包含，如果已经存在，那么把该元素放入到另一个res的set中，最后将res的set转换为数组返回即可。

对于350，就可以用map，不过要把两个数组对应的map都求出来才可以，并且比较相同元素的次数的大小？（我的思路

## sort + two pointers
先使用自带的sort函数将数组排序，然后two pointers，一个p1指向nums1，一个p2指向nums2进行遍历。

如果当前的1数组小于当前的2数组，说明，p1需要往右移动才有可能碰到和当前的2数组一样的元素，所以右移p1，如果右侧是同样的元素，需要跳过，继续移，因为**当前这个数已经被pass了，通过一个while循环实现，在之前的某类题中遇到过。。。：```while(p1<len1-1 && nums1[p1] == nums1[p1+1]) p1++;```。**

同理，如果p2小，需要右移p2，同样的右移思路。

如果两者相等，存入res中，此时，349和350的需要不同的对待手段：
* 349直接放进去，然后按照上边的移动方法把p1和p2都移动到下一个unique元素即可。
* 350，不仅要移动到下一个unique，还要记录下每一个移动了多少下，然后把元素放进res中时重复的次数和移动次数较少的次数一致。。
```
int dis1 = p1, dis2 = p2;
while(dis2<len2-1 && nums2[dis2] == nums2[dis2+1]) dis2++;
while(dis1<len1-1 && nums1[dis1] == nums1[dis1+1]) dis1++;
int dis = Math.min(dis1-p1, dis2-p2);
while(dis>=0){
    list.add(nums1[p1]);
    dis--;
}
p1 =dis1 +1;
p2 = dis2+1;
```

## Binary Search
就是固定
