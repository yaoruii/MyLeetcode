# 713. Subarray Product Less Than K

## two pointers: 无数个fuck后换来了一个29%的结果。。
我自己的方法想出来挺简单的，但是实现起来好多坑啊。。。因为test case真的是各种乱七八糟的，难搞啊。
* start=0，一路往右找第一个能使**整体的积**大于等于k的end的pointer，然后，每一个以start开头的subarray的个数：即该sunarray的长度：```end-start```
* 然后start++，end继续从原来的end开始。
* **这个方法看起来简单，但是实现起来很麻烦，因为：1，可能end早早地就到len-1这里了。2，可能中间碰到一个超级大的数，使得end不变之后，我们一路往右start++，等到start = end了，这个时候，这个数很大，也不满足条件，end-start = 0,但是这个时候，曾经积赞的track不能再去除nums[end]了，所以这里也要加一个判断。start<end的时候才可以track/nums[end]。3，当start>end的时候，这个时候要请空end，和刚开始一样，让end=start, track =1。就很麻烦。

## 和我的方法类似的two pointers 或者 sliding windows?:


