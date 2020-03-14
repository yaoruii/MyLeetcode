# 283. Move Zeroes
```
move all 0's to the end of it while maintaining the relative order of the non-zero elements.
把数组中的0都移到数组的后边，前边的非0数字的顺序保持不变
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
```
## two pointers: 0ms, 100%
思想很简单：
* 首先定位到第一个0数字，让start指向它，如果遍历完，都没有找到0元素(start >= len)，那么可以直接结束了。
* 然后，让end指向第一个0的下一个元素，开始寻找下一个非0数字，找到之后：如果不存在(end >= len)，说明从第一个0开始到最后全部都是0，结束。
* 然后，让start指向的第一个0和end指向的之后的第一个非0，进行交换元素。
* 此刻，我们可以确定：start+1 到 end的元素都是0，那么遇到下一个非0元素，肯定是要和start+1这个地方的0进行交换的，所以让start = start+1, end = end+1。
* 然后，继续while遍历end，让其指向下一个非0的元素，然后和start交换，然后start++,end++。继续循环。直到end 和start>=len.
