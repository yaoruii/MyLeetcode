class Solution {
    public int[][] merge(int[][] intervals) {
       //Given a collection of intervals，所以，每一行都是两个数，是一个区间
        if(intervals==null || intervals.length ==0) return intervals;
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        for(int i=0; i<n; i++){
            int min=i;
            for(int j=i+1;j<n;j++){
                if(intervals[j][0]<intervals[min][0]) min=j;
            }
            if(min!=i){
                int[] tmp = intervals[min];
                intervals[min] = intervals[i];
                intervals[i] = tmp;
            }
            int size = res.size();
            if(i==0 || intervals[i][0]>res.get(size-1)[1])
                res.add(intervals[i]);
           else{
                // res.add(new int[]{res.get(size-1)[0],Math.max(intervals[i][1],res.get(size-1)[1])});
                // res.remove(size-1);
               if(intervals[i][1] > res.get(size-1)[1]){
                   res.add(new int[]{res.get(size-1)[0],intervals[i][1]});
                   res.remove(size-1);
               }
            }  
        }
        // int s=res.size();
        // int[][] r = new int[s][2];
        // for(int i =0;i<s;i++){
        //     r[i]=res.get(i);
        // }
        return res.toArray(new int[res.size()][]);
        
    }
}
