class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        double lo = Integer.MAX_VALUE;double hi = Integer.MIN_VALUE;
        double mid;
        for(int n : nums){
            lo = Math.min(lo, n);
            hi = Math.max(hi, n);
        }
        double error = Double.MAX_VALUE;
        //使用一个prev_mid和接下来while循转被验证的mid差距为error，很小就不再继续找了
        double prev_mid = hi;
         //The answer with the calculation error less than 10-5 ok
        while(error> 0.00001){
            mid = lo + (hi - lo)/2;
            if(check(nums, mid, k)){
                //即存在平均值大于等于mid的子数组，往前继续探索，寻找最大
                lo = mid;
            }
            else hi = mid;
            error = Math.abs(prev_mid - mid);
            prev_mid = mid;  
        }
        return lo;
       
    }
    public boolean check(int[] nums, double mid, int k){
        double sum = 0, prefix = 0, min_prefix = 0;
        for(int i = 0; i< k; i++){
            sum += nums[i] - mid;
        }
        if(sum > 0) return true;
        //继续往前加，并且探索减去最小前缀平均值是否大于mid
        for(int i= k; i< nums.length; i++){
            sum += nums[i] - mid;
            prefix += nums[i-k] - mid;
            min_prefix = Math.min(min_prefix, prefix);
            if(sum >=0 || sum >= min_prefix){
                return true;
            }
        }
        return false;
        
        
    }
}
