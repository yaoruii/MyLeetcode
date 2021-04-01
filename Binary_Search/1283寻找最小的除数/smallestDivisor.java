class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //去ceil的方法；
        //(x+n-1)/n: 因为如果正处，那么n-1被floor掉
        //如果不整除，x会多出来一部分m，1<m<n，n<(m+n-1)<2n-1,所以除过后多了一个1
        int n = nums.length;
        //寻找最小的，首先数组最大值满足<=threshold，再大没有必要
        int max = 0;
        for(int i: nums){
            if(i>max){
                max = i;
            }
        }
        int left =1, right = max;
        int mid =0;
        int sum = 0;
        while(left<=right){
            mid = (right-left)/2 + left;
            sum = helper(nums, mid);
            if(sum>threshold){
                //mid太小了
                left = mid+1;
            }
            else{
                //check 是否可以更小
                right = mid-1;
            }
        }
        return left;
    }
    private int helper(int[] nums, int div){
        int sum = 0;
        for(int n: nums){
            sum += (n+div-1)/div;
        }
        return sum;
    }
}
