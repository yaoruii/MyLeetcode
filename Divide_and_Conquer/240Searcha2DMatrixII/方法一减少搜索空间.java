class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rn = matrix.length;
        if(rn == 0) return false;
        int cn = matrix[0].length;
        if(cn == 0) return false;
        int row = rn-1;
        int col = 0;
        while(0<= row && row < rn && 0<=col && col< cn){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) col++;
            else row--;
        }
        return false;
   
    }
}
