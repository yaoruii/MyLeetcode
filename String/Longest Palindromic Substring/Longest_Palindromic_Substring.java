public class Longest_Palindromic_Substring {
        public String longestPalindrome(String s) {
            //和上一道找最长不重复的子字符串是否是同一种算法？
            //kkkkk，最后返回的是子字符串
        /*我的方法：遍历：498ms,6.83%!!!!!1
        int len = s.length();
        int start = 0, end = 0;
        String res ="";
        int palin_end = 0;
        while(palin_end < len && start < len){
            while(end<len){
            if(s.charAt(end)==s.charAt(start)&&isPalin(s.substring(start,end+1))){
                //res = Math.max(res, end-start+1);
                res = res.length() > (end-start+1)? res : s.substring(start,end+1);
                palin_end = end;//mark this index which is current longestsub's end
            }
            end ++;
            }//此时固定一个start，end从(start+1)or(上一轮回文结束的地方)遍历到了最后
            //之后移动start，进行下一轮的遍历
            //此时的end如何赋值：
            start ++;
            if(palin_end == len-1){
                break;
            }
            else if(palin_end < start){
                end = start +1;
            }
            else {
                end = palin_end;
            }
        }
        return res;
    }
    public boolean isPalin(String s){
        int len = s.length();
        if(len == 1){return true;}
        for(int i = 0; i< len/2; i++){
            if(s.charAt(i) != s.charAt(len - i-1)){
                return false;
            }
        }
        return true;*/
            /*动态编程*/
            //100ms, 25.77%
            //把最后从table中寻找最长索引的过程放在赋值的过程：86ms,30.32%
        /*
        int len = s.length();
        if(s == null || len <=1){return s;}
        int[] max = new int[2];
        max[0] = 0;
        max[1] = 0;
        boolean[][] isPalin = new boolean[len][len];
        for(int i = 0; i< len; i++){
            isPalin[i][i] = true;
        }
        for(int i =0; i<len-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalin[i][i+1] = true;
                max[0]=i;
                max[1]=i+1;
            }
            // else{
            //     isPalin[i][i+1] = false;//boolean型数组初始化为false
            // }
        }

        for(int n = 2; n< len; n++){
            for(int i =0; i+n< len; i++){
                if(s.charAt(i) == s.charAt(i+n) && isPalin[i+1][i+n-1]){
                    isPalin[i][i+n] = true;
                     if((max[1] - max[0])< n){
                         max[0] = i;
                         max[1] = i+n;
                }
            }
        }
        }
        return s.substring(max[0], max[1]+1);*/
            /*从中心扩展*/
            //23ms，68.94%
            int len = s.length();
            if(s == null || len <=1){return s;}
            int start = 0;
            int max =0;
            int len1,len2;
            for(int i = 0; i < len; i++){
                len1 = expend(s, i, i);
                len2 = expend(s, i, i+1);
                if(max < Math.max(len1, len2)){
                    start= (len1>len2)? (i - len1/2) : (i - len2/2+1);
                    max = Math.max(len1, len2);
                }
            }
            return s.substring(start, start+max);


        }
        public int expend(String s, int left, int right){
            while(0 <= left && right< s.length() && s.charAt(left) == s.charAt(right)){
                left --;
                right ++;
            }
            return (right-1)-(left+1)+1;//返回以i为中心的最长的回文的长度
        }

    }

