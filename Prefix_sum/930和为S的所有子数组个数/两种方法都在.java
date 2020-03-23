class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        //求所有的和为s的子数列个数：求所有包含s个1的子数列的个数
        //和992是一样的，至多s个1很简单，只要当前right和left小于等于s，就可以right-left+1
        //return helper(A, S) - helper(A, S-1);
        //使用prefix sum
        //牛逼啊
        //使用prefix[]数组是记录每个索引对应的prefix_sum
        //使用map是为了记录我们之前看到过几次当前索引的prefix：看到过n次就代表有n个i对应的prefix[i]+s == prefix[j],我们将n加到res上即可，然后将prefix[j]+s放入到map中，因为我们见过了prefix[j]+s，未来的新的j如果满足prefix[new_j] == prefix[j]+s,说明：p[new_j] - p[j] = s，new_j和j是我们的答案，有几个prefix[j]+s就是有几个j，res就加几个
        int len = A.length;
        int[] prefix = new int[len+1];
        for(int i = 0; i< len; i++){
            prefix[i+1] = prefix[i] + A[i];
        }
        HashMap<Integer, Integer> seen = new HashMap<>();
        int res = 0;
        for(int pre : prefix){
            res += seen.getOrDefault(pre,0);
            seen.put(pre+S, seen.getOrDefault(pre+S,0)+1);
        }
        return res;
        
        
    }
    public int helper(int[] nums, int s){
        int len = nums.length;
        int left = 0; int right = 0;int res = 0;
        //不需要再定义一个counter看当前有几个1了，可以直接再s上+/-
        while(right<len){
            if(nums[right] == 1) s--;
            while(s<0 && left<= right){//超过s个1了,需要改变left
                if(nums[left++] == 1) s++;
            }
            //至多s个1，所以当前right和left配对成功，求一下多少个子数列
            res += right - left +1;
            right++;
        }
        return res;
    }
    
}
