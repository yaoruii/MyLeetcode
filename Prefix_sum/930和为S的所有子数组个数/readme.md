# 930 Binary Subarrays With Sum S

## sliding window：0ms
**这道题和今天做的992是一样的，求包含S个1个所有子数组，转换为至多包含S个1的问题，那么这就是一道sliding window题，实现也很简单，不再叙述**

## hashmap + prefix sum:
p数组依旧是p[i] = a[0]+a[1]+a[2]+···+a[i-1]，p[j+1]-p[i]是子数组[i,j]的的和，所以，我们是寻找i,j使得：i<j,p[j+1]-p[i] ==s
**所以，这道题瞬间变得和今天做的另一道题862很相近了：prefix sum**
* 对于每一个j,我们计算满足：```p[i] = p[j]-s```的i的个数，这等同于求以j结尾的和为s的子数组的个数。
* 在代码里面有深刻的解释，边敲边就明白了。下次写完代码再写md文档。
