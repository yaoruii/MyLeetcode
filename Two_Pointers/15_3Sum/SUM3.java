class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //tag: array + two pointers
        //two pointers
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;
        int i = 0;
        int left;
        int right;
        int target;
        int sum;
        //要加上==，因为要考虑到当前虽然是0，但是前方可能也有俩0等着它呢。
        while( i< len && nums[i]<=0){
            if(i == 0 || (i>=1 && nums[i] != nums[i-1])){
                left = i+1; right = len-1; target = 0-nums[i];
                while(left < right){
                    sum = nums[left] + nums[right];
                    if(sum == target) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        //后边了能还有元素和为target
                        //但是要略过和当前left,right相等的元素
                        while(left< len-1 && nums[left] == nums[left +1]) left++;
                        while(right>0 && nums[right] == nums[right -1]) right--;
                        left++; right--;
                    }
                    else if(sum > target) right--;
                    else left++;
                }
            }
            i++;
        }
        return res;
    }
}
