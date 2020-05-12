# 274. H-Index
```
Input: citations = [3,0,6,1,5]
Output: 3 
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had 
             received 3, 0, 6, 1, 5 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
 ```
 
 # 使用sort()排序，然后一个个地找h：
 排序后：
 * 首先，如果，最小值>=n，那么n个元素都大于等于n，所以h=n
 * 如果最小值<n，那么h!=最小值，因为有n个元素至少为最小值，但是最小值<n
 * 因此，需要继续遍历下边的元素：
    * 至少为a[i]的元素个数为```h = n-i```，这是h必须要满足的
    * 同时，要满足```a[i-1]<=h && h<=a[i]```，这样，才可以说```至少为h的元素个数为h```
    * 注意：剩下的元素从a[0]到a[i-1]都是不超过h，因此，h可以等于a[i-1]。
    
# hash table ??
