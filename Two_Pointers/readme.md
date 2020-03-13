# two pointers

## 搜索一对和为target的元素: 3sums
对于有序数组，two pointers是一个很有效的方法，用来搜索pairs。

给定一个有序数组，长度为N，找到是否存在一对数：A[i], A[j]，两者的和为x

**传统方法: 两个for循环**
```
for (i = 0; i < N; i++) { 
    for (j = 0; j < N; j++) { 
        if (A[i] + A[j] == X) 
            return true; // pair exists 
        if (A[i] + A[j] > X) 
            break; // as the array is sorted 
    } 
} 
```
所以时间复杂度是 O(n2).

**two pointers:**

一个指向first element,另一个指向last element，将两指针的元素加在一起，如果和小于X，那么向右移动左边的指针，如果大于X，那么向左移动右边的指针。一直移动two pointers，直到找到正确的pairs，或者left >= right为止。
```
int i = 0; 
// represents second pointer 
int j = N - 1; 
while (i < j) { 
    // If we find a pair 
    if (A[i] + A[j] == X) 
        return true;   
    // If sum of elements at current pointers is less, we move towards higher values by doing i++ 
    else if (A[i] + A[j] < X) 
        i++; 
    // If sum of elements at current pointers is more, we move towards lower values by doing j-- 
    else
        j--; 
} 
return false; 
```
## tree:
给一个数组，表示一颗树的某种遍历得到的结果，去构建这棵树。

使用two pointers去构建suntree的遍历结果，这样就不用生成新的subarray了。
## 数组或者listnode操作：
要注意null的问题，还有while啊for啊之类的细节

**需要死抠细节啊，i啊，什么时候结束循环啊，尤其是ListNode的题，就死抠**
