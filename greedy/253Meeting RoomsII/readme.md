# 253. Meeting Rooms II

```
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
```

找到，开这些会需要的最小数量的会议室数量。

## 分别排序 + heap

使用了252的分别排序，虽然打乱了区间但是据说结果是一样的。

**需要heap的原因：**

**回答：  
如果，此时已经开了n个会议室，那么就有n个最早可以使用时间（记录n个会议室的end time），下一场会议的开始时间肯定是和这n个中最小的end time比较，如果开始时间较大，那么就不需要为该会议新开会议室，否则，n个会议室都不空闲，需要开n+1个会议室**

```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length ==0) return 0;
        int n = intervals.length;
        int[] start = new int[n]; int[] end = new int[n];
        for(int i = 0; i<n;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res = 1; //int min = end[0];
        //还是需要一个min-heap的，使用一个min标记不行，因为，一个min只能追踪一个房间的，可能同时开了好多房间，需要记忆新增的房间的min
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(end[0]); int min;
        for(int i=1; i<n;i++){
            min = heap.peek();//所有房子中最早的end time
            if(start[i] < min){
                res++;   
               //因为我们开了一个新房间，所以，需要把这个新房间的end time(available time)给记下来
                //min = Math.min(min, end[i]);//这只能追踪一个房间，换到了新房间了，之前的丢失了
                heap.add(end[i]);
            }
            else{
                //我们没有开新房间，说明当前有一个房间的end time(available time)是小于等于开始时间
                //可以用旧房子，旧房子的end time需要更新了--被移走
                //min = end[i];
                heap.poll();
                heap.add(end[i]);//完成了这个房子的end time的更新
            }
        }
        return res;
        
    }
}
```
