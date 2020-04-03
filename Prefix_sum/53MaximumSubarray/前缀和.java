class Solution {
    public int maxSubArray(int[] nums) {
        //前缀和？
        int len = nums.length;
        if(len ==0) return 0;
        int min_pre = 0; int pre=0;
        int sum = nums[0];
        for(int i = 0; i< len; i++){
            min_pre = Math.min(min_pre, pre);
            pre += nums[i];
            sum = Math.max(sum, pre - min_pre);
        }
        return sum;
       
        
    }
}
