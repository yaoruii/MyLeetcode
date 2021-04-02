class Solution {
    public int shipWithinDays(int[] weights, int D) {
        //要按照在weights数组内的顺序来ship
        //capacity=sum的话，就可以在一天内送完，而D>=1，所以此时一定是满足的
        int n = weights.length;
        int sum = 0;int max = 0;
        for(int weight: weights){
            sum += weight;
            max = Math.max(max, weight);
        }
        int left = max, right = sum; int mid = max;
        int days;
        while(left<= right){
            mid = (right-left)/2 + left;
            days = helper(weights, D, mid);
            if(days>D){
                //超了：
                left = mid+1;
            }
            else{
                //check是否可以更小
                right = mid-1;
            }
        }
        return left;
        
    }
    private int helper(int[] weights, int d, int capacity){
        int days = 0;
        int currSum =0;
        for(int i =0; i<weights.length; i++){
            currSum += weights[i];
            if(currSum > capacity){
                //i处的package不能当天运走了，一天结束：
                days++;
                /*
                //currsum 等于weight[i]
                currSum = weights[i];//但是有可能此时光weights[i]自己就超过了capacity，所以不能这样写，直接i-1吧
                */
                //如果weight[i]自己就超过capacity，那么这个capacity肯定是不对的，所以二分的左边界是max值
                //所以改正left后，就不会有单独一个重量大于capacity了，可以直接按原方法了：
                //currSum = weights[i];
                //这样还是有问题，如果此时weights[i]是最后一个，那么就该最后一天就没有被加进去：退出循环了
                //所以还是直接i--来的好！
                i--;
                currSum = 0;//记得归0.。。。
            }
        }
        return days+1;//最后一个元素还是没有合理判断，因为可能最后一个元素所在的group（多大都有可能）一直没超过，就没加
        
    }
}
