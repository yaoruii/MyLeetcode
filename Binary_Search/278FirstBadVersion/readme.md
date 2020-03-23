# 278. First Bad Version

```
Given n = 5, and version = 4 is the first bad version.

call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true

Then 4 is the first bad version. 
```

**很典型的Binary search题，记住具体的rigt = mid-1 or mid+1 or mid，都是有可能的，要具体问题具体分析。甚至包括mid的计算也是：lo + (hi - lo)/2 or  
lo+( hi - lo +1)/2**


