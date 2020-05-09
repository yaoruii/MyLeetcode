class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return;
        int len = nums.length;
        boolean less = true;
        for(int i = 0;i<len-1;i++){
            if(less){
                if(nums[i]>nums[i+1]){
                    exch(nums, i, i+1);
                }
            }
            else{
                if(nums[i]<nums[i+1]){
                    exch(nums, i, i+1);
                }
                
            }
            less = !less;
        }
    }
    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i]= nums[j];
        nums[j] = tmp;
    }
}
