class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //首先数组里面的元素都是正数，所以遇到一个subarray的乘积大于等于k之后，就可以停止了
        //int start = 0;
        int end = 0;
        int len = nums.length;
        int sum = 0;
        int track  =1;
        for(int start = 0; start< len; start++){
            if(start> end) {
                end = start;
                track = 1;
            }
            while( end < len && track * nums[end] < k){
                track = track * nums[end];
                end ++;
            }
            sum += end-start;//以start开头的subarray的个数。
            if(start < end) track = track/nums[start];//得到下一轮的起始track
        }
         return sum;
}
}
