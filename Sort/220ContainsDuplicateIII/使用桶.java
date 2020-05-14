class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        //i和j的差值最多是K：所以至多k+1个元素
        //对k+1个元素进行排序，保持他们有序状态
        //bucket:
        if(nums==null || nums.length<=1) return false;
        if(k<=0 || t<0) return false;
        HashMap<Long, Long> map = new HashMap<>();
        long size =(long)t+1;
        for(int i =0; i<nums.length; i++){
            long num = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = (long) num/size;//防止t==0的情况
            if(map.containsKey(bucket)
               || map.containsKey(bucket-1) && num-map.get(bucket-1) <=t
               || map.containsKey(bucket+1) && map.get(bucket+1) - num <= t
              )
                return true;
            
            //如果同一个bucket没有元素，且相邻bucket也没有满足条件的元素，那么该元素需要放入到map中
            map.put(bucket,num);
            //该map维护k个元素，因为，为了使上边的if满足，第i个元素最多是第k+1个元素，这样才可以和map中的已有的元素进行比较
            //所以，此时，如果size>k,即k+1(i==k)，那么需要去掉一个，否则不需要去掉，可以继续加
            if(i>=k){
                //去掉window开头的那个元素：i-k
                long lastnum = (long) nums[i-k] - Integer.MIN_VALUE;
                long lastbucket = (long) lastnum/size;//防止t==0的情况
                //long lastbucket = (long)((long)(nums[i-k]-Integer.MIN_VALUE))/(t+1);
                map.remove(lastbucket);
            }
        }
        return false;
        
    }
}
