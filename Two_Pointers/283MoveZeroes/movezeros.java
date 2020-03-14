class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        int end = 0;
        int len = nums.length;
        while(start <len && nums[start] != 0) start++;
        end = start +1;
        //刚开始先定位到第一个0，如果没有那么就直接结束了
        while(start <len && end< len){
            while(end < len && nums[end] == 0) end++;
            //退出while循环，说明此时的end指向的元素不为0
            //退出while循环，还有可能是因为end>=len了。
            if(end >= len) break;
            nums[start] = nums[end];
            nums[end] = 0;
            //不对：start = end;
            start +=1;
            end +=1;
        }
        
  }
        
}
