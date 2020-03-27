class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //bs还有一种是无序时搜索范围，绝了，明日总结
        int n = matrix.length;
        //int cn = matrix[0].length;
        //初始的范围是该数组的【最小值】和【最大值】
        int lo = matrix[0][0]; int hi = matrix[n-1][n-1]; int mid;
        while(lo <= hi){
            mid = lo + (hi-lo)/2;
            //计算该数组中<=mid的元素个数
            int count = 0; 
            //追踪<=mid的数中最大的那个数，如果有K个数<=mid，那么最大的那个数就是最后的结果
            //不能等于0啊，因为可能数组里面有负数啊
            int maxele = Integer.MIN_VALUE;
            int c = n-1;
            for(int r = 0; r< n && count <=k; r++){
                while(c>=0 && matrix[r][c] > mid) c--;
                if(c>=0){
                    //说明是遇到<=mid的元素了才退出while循环的，否则就是一行都没有遇到
                    count += (c+1);
                    maxele = Math.max(maxele, matrix[r][c]);
                }
                //这一行不需要了：
                //因为下一行对应的c+1列一定比该行的c+1列的数大，既然该行的c+1大于mid，下一行的c+1也会大于mid，所以c不需要重新赋值，可以直接搞。
                //c = n-1;
            }
            if(count == k) return maxele;
            else if(count < k) lo = mid+1;
            else hi = mid-1;
        }
        //此时lo = hi +1:上一步是lo=hi=mid
        //1,if lo +1:mid(hi) 对应的count < k
        //2,if hi -1:mid(lo)对应的count>k
        //所以，lo是结果，存在重复值。
        //为什么lo一定存在于矩阵中：
        //hi 只比 lo小1，所以一定存在lo=hi+1在矩阵中，才能使得，<= lo的个数大于了k。
        return lo;
        
        
    }
}
