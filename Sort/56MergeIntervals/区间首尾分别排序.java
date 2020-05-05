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
        int s =0;int e= 0;
        while(e<n){
            if(e==n-1 || end[e]<start[e+1]){
                res.add(new int[]{start[s], end[e]});
                s= e+1;
            }
            e++;
        }
        return res.toArray(new int[res.size()][2]);
    }
}
