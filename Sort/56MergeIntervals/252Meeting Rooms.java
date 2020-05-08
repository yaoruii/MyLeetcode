class Solution {
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
}
