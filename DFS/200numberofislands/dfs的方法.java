class Solution {
    public int numIslands(char[][] grid) {
        //DFS
        int rn = grid.length;
        if(rn == 0) return 0;
        int cn = grid[0].length;
        int res = 0;
        if(cn == 0) return 0;
        for(int r = 0; r<rn; r++){
            for(int c = 0; c< cn; c++){
                if(grid[r][c]=='1'){
                    res++;
                    dfs(grid, r,c);
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int r, int c){
        int rn = grid.length;
        if(rn == 0) return;
        int cn = grid[0].length;
        if(r<0 || c<0 || rn<= r || cn <= c || grid[r][c] == '0')
            return ;
        //marked操作：
        grid[r][c] = '0';
        //遍历相邻的node：
        //if(grid[r][c-1]):不能这样，要直接调用dfs，因为不知道c-1或者c+1同理r+1,r-1的范围
        dfs(grid, r+1,c);
        dfs(grid, r-1,c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
    }
}
