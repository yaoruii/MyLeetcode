class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int len = nums.length;
        int hi = len-1;
        if(len == 0) return new int[]{-1,-1};
        int[] res = new int[2];
        // find left of the bounary
        int mid ;
        while(lo < hi){
            mid = lo + (hi - lo)/2;
            if(nums[mid] >= target) hi = mid;
            else{
                lo = mid+1;
            }
        }
        if(nums[lo] == target) res[0] = lo;
        else {
            res[0] = -1;
        }
        hi = len-1;
        while(lo < hi){
            mid = lo + (hi-lo+1)/2;
            if(nums[mid]<= target) lo = mid;
            else hi = mid-1;
        }
        if(nums[lo] == target) res[1] = lo;
        else res[1] = -1;
        
        return res;
    }
}
