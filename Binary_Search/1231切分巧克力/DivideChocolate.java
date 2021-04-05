package paid;
public class DivideChocolate{
    public static int maximizeSweetness(int[] sweetness, int K) {
        /**
         * 自己吃最少的 ---- 切分后最小值M
         * 使得自己能吃到的最大 ---- 满足条件的最大的M
         * 所以：其他人的X>M
         * 二分法：M在min(array) - sum(array)之间二分，寻找满足条件的
         * 条件：
         * 1，可以分成K+1份，大于等于M
         * 2，无法满足：M过大，减少right
         * 3，可以满足，且最小值大于M，M较小，增大left
         */
        if(sweetness==null || sweetness.length==0){
            return 0;
        }
        int n = sweetness.length;
        //求最小值和sum:
        int min = Integer.MAX_VALUE, sum =0;
        for(int sweet: sweetness){
            sum += sweet;
            min = Math.min(min,sweet);
        }
        if(n== K+1){
            return min;//一人一个
        }
        int left = min, right = sum, mid = left;
        int count =0; int currMin = Integer.MAX_VALUE;int currSum =0;
        int result = 0;
        while(left<= right){
            mid = (right-left)/2 + left;
            count = 0;
            currMin = Integer.MAX_VALUE;
            //开始分：
            currSum =0;
            for(int i =0; i<n; i++){
                currSum += sweetness[i];
                if(currSum>=mid){
                    //可以切成一份了：最优就是每一个都只多一点或者一样 ==>> 自己可以吃到的最大
                    currMin = Math.min(currMin, currSum);
                    count++;
                    //分好一份，sum归0
                    currSum =0;
                }
                if(count>=K+1){
                    //已经切成K+1份了，每一份都大于等于mid
                    //当前最小值才是自己会吃到的那个甜度：
                    //为什么不是mid(right)：
                    //mid/right只是一个门槛，切分是几个正整数相加，不可能刚好等于mid的，最后肯定返回最小的值
                    //而门槛的作用是：这个门槛再大一点，就没办法满足题目条件了
                    result = Math.max(result, currMin);
                    break;
                }
            }
            if(count==K+1){
                //mid可以，看看更大可不可以：
                left = mid+1;
            }
            else{
                //mid太大了，切不了k+1份：
                right = mid-1;
            }

        }
        return result;

    }
    public static void main(String[] args) {
        //sweetness = [1,2,3,4,5,6,7,8,9]
        int[] sweetness = new int[]{1,2,2,1,2,2,1,2,2};
        System.out.print(maximizeSweetness(sweetness, 2));
    }
}

