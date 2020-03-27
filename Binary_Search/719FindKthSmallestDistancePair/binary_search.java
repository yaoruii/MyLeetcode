class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        //应该是允许重复的距离也算数的
        int n = nums.length;
        Arrays.sort(nums);
        int lo = 0; int hi = nums[n-1] - nums[0]; int mid;
        while(lo <= hi){
            //traversal search space
            mid = lo + (hi - lo)/2;
            int count = 0; int maxdis = 0;//dis是正数，排序后符合
            int right = 1;
            //计算该mid下的count(mid)
            for(int left = 0; left< n; left++){
                while(right < n && nums[right] <= nums[left] +mid){
                    right++;
                }
                //如果是因为right==n退出的，说明所有的数都<=右侧，都算进去
                //细节：因为是pair，所以要除去left处的元素自身
                count += right - left -1;
                maxdis = Math.max(maxdis, nums[right-1] - nums[left]);
            }
            if(count == k) return maxdis;
            else if(count < k) lo = mid+1;
            else hi = mid-1; //为什么不能为mid：
            //为mid后，当hi = lo=mid后，就困在这里了。
        }
        return lo;
    }
}
