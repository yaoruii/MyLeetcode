# 56 Merge Intervals

**56题应该是这几题的母题，合并区间，本质上判断，i个结束和i+1的开始**

## 分别排序+ two pointers

排好序的区间；

一个指针，指向第一个区间，它的starting time将作为合并后的区间的starting time，现在去找合并后的区间的end time:**即，最后一个互相重叠的区间的end time**

**方法：最后一个区间的end time小于下一个区间的start time且是第一个出现这种关系**

```java 
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals==null || intervals.length ==0) return intervals;
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i =0; i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);Arrays.sort(end);
        List<int[]> res = new ArrayList<>();
        int s =0;int e= 0;//two pointers
        //s指向区间的开始的元素，e指向区间结束的元素
        while(e<n){
            if(e==n-1 || end[e]<start[e+1]){//第一次出现，最后的区间找到
                res.add(new int[]{start[s], end[e]});//写入合并后的区间结果
                s= e+1;
            }
            e++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
```

## 按照start 排序（正常搞吧。。）
