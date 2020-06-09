# 252. Meeting Rooms

```
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Input: [[0,30],[5,10],[15,20]]
Output: false
```

去找到一个人是否能够参加所有的会议 ==== 确定是否存在重叠的区间：overlapping problems。

## 常规方法：
和452一样，对会议进行排序，不过区别是**按照开始时间，因为，先开始的会议，先去参与，结束后，才能去参与下一个会议，所以，后开始的会议的开始时间如果都大于等于当前会议的结束时间，那么这个人就能够赶上所有的会议，否则，就不能赶上所有会议，所以，按照开始时间对会议进行排序，非常符合现实生活中的思路**

```java
//此时，数组已经按照开始时间排好序：
int end= a[0][1];//第一场结束时间
for(int i = 1; i<n;i++){
  if(a[i][0]<end) return false;//开始时间小于当前会议的结束时间
  //否则，就可以继续参加第i场会议，然后i++
  end = a[i][1];
}
```

## 将区间打乱：开始和结束都排序，排序后的起终时间按照索引进行配对：

```java
public boolean canAttendMeetings(int[][] intervals) {
        if(intervals==null && intervals.length == 0) return true;
        int n = intervals.length;
        int[] start = new int[n]; int[] end = new int[n];
        for(int i = 0; i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int s =0; int e = 0;
        while(e<n-1){
            if( end[e] > start[e+1]) return false;//等于是可以赶上的，和56题的区别
            e++;
        }
        return true;
    }
```

分别排序会打乱原来的区间范围以及分布，但是得到的结果是一样的，证明略。。。
