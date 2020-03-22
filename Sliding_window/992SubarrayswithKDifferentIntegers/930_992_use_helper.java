class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        //求所有的和为s的子数列个数：求所有包含s个1的子数列的个数
        //和992是一样的，至多s个1很简单，只要当前right和left小于等于s，就可以right-left+1
        return helper(A, S) - helper(A, S-1);
        
    }
    public int helper(int[] nums, int s){
        int len = nums.length;
        int left = 0; int right = 0;int res = 0;
        //不需要再定义一个counter看当前有几个1了，可以直接再s上+/-
        while(right<len){
            if(nums[right] == 1) s--;
            while(s<0 && left<= right){//超过s个1了,需要改变left
                if(nums[left++] == 1) s++;
            }
            //至多s个1，所以当前right和left配对成功，求一下多少个子数列
            res += right - left +1;
            right++;
        }
        return res;
    }
    
}
