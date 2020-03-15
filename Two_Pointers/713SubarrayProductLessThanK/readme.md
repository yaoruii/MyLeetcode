# 713. Subarray Product Less Than K

## two pointers: 无数个fuck后换来了一个29%的结果。。9ms
我自己的方法想出来挺简单的，但是实现起来好多坑啊。。。因为test case真的是各种乱七八糟的，难搞啊。
* start=0，一路往右找第一个能使**整体的积**大于等于k的end的pointer，然后，每一个以start开头的subarray的个数：即该sunarray的长度：```end-start```
* 然后start++，end继续从原来的end开始。
* 这个方法看起来简单，但是实现起来很麻烦，因为：**1，可能end早早地就到len-1这里了。2，可能中间碰到一个超级大的数，使得end不变之后，我们一路往右start++，等到start = end了，这个时候，这个数很大，也不满足条件，end-start = 0,但是这个时候，曾经积赞的track不能再去除nums[end]了，所以这里也要加一个判断。start<end的时候才可以track/nums[end]。3，当start>end的时候，这个时候要请空end，和刚开始一样，让end=start, track =1。就很麻烦。**

## 和我的方法类似的two pointers 或者 sliding windows?:7ms,98%
* 答案的方法和我的是反方向遍历：我是从左往右遍历start，最后plus上所有以start为第一个元素的sunarray的个数。而答案是：从左往右遍历right，和right配对的left，**是个增函数**，所以，固定了right后，我们去定位配对的left，然后计算以right末尾的subarray的个数。如果(track x nums[right])大于等于k了，说明当前配对的left过左，把当前left的值➗掉，然后left++,，直到我们找到合适的left。
* 答案的方法为什么好：**1，```把当前left的值➗掉```，这一行为不用担心上述的track已经被除到1的情况了，因为当遇到一个超级大的数作为当前的right使，它配对的left可能是它自己，也可能无，我们把left从左侧一直++,并除去对应的left，当track= nums[end]时<k了，所以结束，或者track =1了，也会小于k，结束。2，根据1，所以left会自动地和right保持一致，最多等于right，我们通过for控制right，也就控制了left**
* 因为nums数组都是正整数，所以最小的数的和至少为1，所以当k<=1的时候，不存在subarray满足小于k的情况。
* 和我的是反方向。

