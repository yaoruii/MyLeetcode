# K-th Smallest Prime Fraction

* 构建候选solution：一个小于1的分数的分子和分母组成的长度为2的数组
* 搜索范围：最小的min/max，最大的1/nums[1]
* 如何验证：对于一个num,count(num)为小于等于num的数，count(num)>=k中最小的num就是我们要找的，因为前一个数极为x，count(x)<k,下一个数num_min,count(num_min)>=k,所以第K个一定是num_min
* count(num)如何计算：固定分子，从头遍历分母，下一个分子变大，当前的right可能使得结果大于mid了，所以right继续前进，two pointer，n的时间复杂度
* 比较大小的时候，可以类似于719的求差转变为求和，此处的求商也可以变成乘法。
* 如何遍历搜索空间：使用bs，变成log(d)
