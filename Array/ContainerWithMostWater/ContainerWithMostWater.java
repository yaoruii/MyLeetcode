public class ContainerWithMostWater {

        public int maxArea(int[] height) {
            //我的遍历的方法：n2的时间复杂度
            //342ms，11.54%
        /*int len = height.length;//细节
        int area =0;//细节，先初始化才能被调用
        for(int i = 0; i < len; i++){
            for(int j = i+1; j< len;j++){
                area = Math.max(area, Math.min(height[i],height[j])*(j-i));
            }
        }
        return area;*/
            //改进：
            //看了hint2，先找最长的宽度的container，然后妥协宽度，去探索是否area更大了
        /*写错了!!!!!!
        学习了别人的方法后，自己开始尝试写下代码*/
            //代码写对了，第一遍刷所以没有思路想不出来的时候要先去看解析
            //2ms,95.53%
            int len = height.length;
            int left = 0;
            int right = len-1;//right永远大于left，小于了也没意义，在之前就遍历过来
            int area = 0;
            while(left< right){
                area = Math.max(area,Math.min(height[left], height[right]) * (right-left));
                if(height[left] <= height[right]){
                    //我们要移动短的，但是不需要移到比它长的线，只需要移动一步，哪怕短了
                    left++;
                }
                else{
                    right--;
                }
            }
            return area;





        }
    }

