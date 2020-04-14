class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length == 0) return matrix;
        int row = matrix.length; int col = matrix[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[row][col];
        for(int r = 0; r< row;r++){
            for(int c = 0; c< col; c++){
                if(matrix[r][c] == 0)
                q.offer(new int[]{r, c});
                //res[r][c] = 0;
            }
        }
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int rc = pair[0];int cc = pair[1];
            int level = res[rc][cc];
            if(rc < row-1 && matrix[rc+1][cc] == 1 && res[rc+1][cc] == 0){
                res[rc+1][cc] = level+1;
                q.offer(new int[]{rc+1, cc});
            }
            if(rc > 0 && matrix[rc-1][cc] == 1 && res[rc-1][cc] == 0){
                res[rc-1][cc] = level+1;
                q.offer(new int[]{rc-1, cc});
            }
            if(cc < col-1 && matrix[rc][cc+1] == 1 && res[rc][cc+1] == 0){
                res[rc][cc+1] = level+1;
                q.offer(new int[]{rc, cc+1});
            }
            if(cc >0 && matrix[rc][cc-1] == 1 && res[rc][cc-1] == 0){
                res[rc][cc-1] = level+1;
                q.offer(new int[]{rc, cc-1});
            }
            
        }
        return res;
        
    }
}
