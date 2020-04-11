class Solution {
    public int maxTurbulenceSize(int[] A) {
        int len = A.length;
        int[] com = new int[len-1];
        int right = 0; int left= 0; int res = 1;
        //注意A数组的长度的conern case
        if(len <=1) return len;
        // if(A[0] - A[1]>0) com[0] = 1;
        // else if(A[0] - A[1]<0) com[0] = -1;
        // else com[0] = -2;
        while(right<len-1){
            // com[right] = A[right] - A[right+1]?
            if(A[right] - A[right+1]>0) com[right] = 1;
            else if(A[right] - A[right+1]<0) com[right] = -1;
            else com[right] = -2;
            if(com[right] == -2 ){
                res = Math.max(res, right-left+1);
                left = right+1;
            }
            else if(right>0 &&com[right] + com[right-1] != 0){
                res = Math.max(res, right-left+1);
                left = right;
            }
            else{
                res = Math.max(res, right-left+2);
            }
            right++;
        }
        return res;
    }
}
