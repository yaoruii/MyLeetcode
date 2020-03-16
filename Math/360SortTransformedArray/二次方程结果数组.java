class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        /*1ms，31%
        int len = nums.length;
        int[] res = new int[len];
        int track;
        for(int i = 0; i<len;i++){
            track = nums[i];
            res[i] = a * track*track + b*track + c;
        }
        Arrays.sort(res);
        return res;*/
        //如何改进？一开始就先计算下数组元素的范围？
        int len = nums.length;
        int[] res = new int[len];
        int left = 0; int right = len-1;
        int index = a >0 ? right : left ;
        int lres = 0; int rres = 0;
        while(left <= right){
            lres = cal(nums[left], a,b,c);
            rres = cal(nums[right], a, b, c);
            if(a>0){
                //res[index] = Math.max(lres, rres);
                if(lres > rres){
                    res[index] = lres;
                    left ++;
                }
                else{
                    res[index] = rres;
                    right --;
                }
                index--;
            }
            else{
                if(lres < rres){
                    res[index] = lres;
                    left ++;
                }
                else{
                    res[index] = rres;
                    right --;
                }
                index++; 
            }
        }
        return res;
    }
    public int cal(int x, int a, int b, int c){
        return a * x*x + b*x + c ;
    }
}
