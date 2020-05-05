class Solution {
    public int maximumGap(int[] nums) {
        //Try to solve it in linear time/space.
        //the maximum difference between the successive elements in its sorted form.
        int len = nums.length;
        if(len<2) return 0;
        if(len == 2) return Math.abs(nums[0]-nums[1]);
        //桶排序之前记的笔记找不到了，再总结学习一下
        int min = nums[0]; int max = nums[0];
        for(int num : nums){
            if(num > max) max = num;
            if(num< min) min = num;
        }
        if(min == max) return 0;
        int gap = (int)Math.ceil((double)(max-min)/(len-1));
        int[] bucketMin = new int[len-1];
        int[] bucketMax = new int[len-1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, -1);//元素都是非负的
        int index;
        for(int i=0;i<len; i++){
            //为什么不把最大值和最小值放入到buckets中：
            //因为如果gap刚好可以除尽的话，max计算出的index=len-1,超出了数组的边界
            //if(nums[i] == min || nums[i]==max) continue;
            if(nums[i]==max) continue;
            index =(nums[i]-min)/gap;
            bucketMin[index] = Math.min(bucketMin[index],nums[i]);
            bucketMax[index] = Math.max(bucketMax[index],nums[i]);
        }
        int maxgap = -1;
        int previousmax = min;//min看成编号为-1的bucket的最大值
        for(int i = 0; i<len-1;i++){
            //不把min/max放进去后，无论怎样的数据分布，都会有空的bucket
            //所以对于空的bucket，要特殊处理：
            if(bucketMax[i] == -1) continue;//空的bucket，跳过
            maxgap = Math.max(maxgap, bucketMin[i]-previousmax);
            //maxgap = Math.max(maxgap,bucketMin[i]-bucketMax[i-1]);//这样不行，可能有空bucket
            previousmax = bucketMax[i];
        }
        //数组的最大值这个边界也要考虑进去
        maxgap = Math.max(maxgap, max-previousmax);//因为是相邻的元素，所以max和最后的bucketMax[i]是相邻的
        return maxgap;
    }
}
