class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m*k) return -1;
        int min=bloomDay[0], max= min;
        for(int i =1; i<n; i++){
            if(bloomDay[i]>max){
                max = bloomDay[i];
            }else if(bloomDay[i]<min){
                min = bloomDay[i];
            }
        }
        int left = min, right = max;int mid = min;int num =0;
        while(left<=right){
            mid = (right-left)/2 +left;
            num = helper(bloomDay, mid, m, k);
            if(num<m){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        return left;
    }
    private int helper(int[] bloomDay, int target, int m, int k){
        //遍历数组，遇到小于等于target的就可以当起点了，并将变量flow+1，继续向下
        //到遇到一个bouquet的终点时，加完flow会等于k，这个时候形成了一个bouquet
        //将相关变量归0
        int flower = 0;
        int n = bloomDay.length;
        int num = 0;int i=0;
        while(i<n){
            if(bloomDay[i]<=target){
                flower++; 
                if(flower==k){
                    flower=0;
                    num++;
                }
            }
            else{
                flower =0;
            }
            i++;
        }
        return num;
    }
}
