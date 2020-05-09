class Solution {
    public void wiggleSort(int[] nums) {
        if(nums==null || nums.length==0 || nums.length==1) return;
        /*超时了！！
        int len = nums.length;int index ;
        if(len%2==0) index= len-1;
        else index = len-2;
        int max;
        List<Integer> fuck = new ArrayList<>();
        while(index>0){
            max = 0;
            for(int j =1; j<len;j++){
                if(nums[max]<nums[j] && !fuck.contains(j)) max=j;
            }
            exch(nums, max,index);
            fuck.add(index);
            index -=2; 
        }
    }*/
        //看了答案，最简单直接的方法：把数组排序，然后交换
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 1; i< len-1; i= i+2){
            exch(nums, i, i+1);
        }
    } 
    private void exch(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
