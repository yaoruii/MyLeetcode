class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        if(len <= 1) return len;
        int left = 0; int right = 0; int max = 0;
        boolean flip = true;//还有翻牌的机会
        int track = 0;
        int zeros= 0;
        int k = 1;//至多一个0
        /*要以right为pointer去遍历整个数组*/
        /*
        while(right < len && left < len && left<= right){
            if(nums[right] == 1) right ++;
            else if(flip){
                right++;
                flip = !flip;
                track = right;
            }
            else{
                max= Math.max(max, right-left);
                left = track;
                flip = !flip;
            }
            
        }
        //159题最后也是：退出while循环后还要再计算一次res，这不太好吧。
        max = Math.max(max, right - left);
        return max;*/
        //本质上还是209变形题：滑窗法
        while(right < len){
            if(nums[right]==0){
                //遇到0了，更新0的个数
                zeros++;
            }
            //看看现在几个0了，符不符合条件：符合就更新max,继续配对合适的right
            //不符合就进入while循环，配对结束：不需要更新max，因为符合的时候一直都在更新
            while(zeros>k && left<= right){
                /*这一个if语句 + while循环其实相当于我的方法中的：
                不满足条件后，移动left到当前窗口0的下一个位置：
                即：left=track
                */
                if(nums[left++] == 0) zeros--;//把left的更细写在[]中，美啊
                //因为无论nums[left]和0什么关系，它都要++，所以写进去很简洁
            }
            max = Math.max(max, right - left +1);
            right++;   
        }
        return max;
        
    }
}
