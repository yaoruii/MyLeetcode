class Solution {
    public void sortColors(int[] nums) {
        //难道不可以当成是单纯的排序吗？肯定可以，但是估计这样的话performance会很差
        //先试试
        //果然单纯的排序会很差，11%
        //学习了排序算法后再回来写
        int len = nums.length;
        /*int tmp;
        for(int i = 0; i< len; i++){
            for(int j = i; j>0 && nums[j] < nums[j-1] ; j--){
                tmp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = tmp;
            }
        }*/
        //学完了算法课里面的排序后
        //follow up里面提到的counting sort才n的时间复杂度，上边的选择排序是n的平方
        //counting sort:已知只有0/1/2这三个数了
        int red =0;int white = 0; int blue = 0;
        for(int i =0; i< len; i++){
            if(nums[i] == 0) red++;
            else if(nums[i]==1) white++;
            else blue++;
        }
        for(int i=0; i<len;i++){
            if(i<red) nums[i] = 0;
            else if(red<=i && i< white+red) nums[i]=1;
            else nums[i]=2;
        }
        
        
        
    }
}
