class Solution {
    public int[] twoSum(int[] nums, int target) {
        //不能直接这样子，因为它要返回索引
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        int complement;
        for(int i =0; i< len; i++){
            complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
        
        
    }
}
