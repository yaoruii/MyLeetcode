class Solution {
    public int row = 0;
    public int col = 0;
    public int area = 0;
    public int maxAreaOfIsland(int[][] grid) {
        //给的tag是dfs,那就先用dfs写一写啊
        if(grid == null || grid.length == 0) return 0;
        row = grid.length; col = grid[0].length;
        int res = 0;
        for(int r = 0; r< row; r++){
            for(int c = 0; c< col; c++){
                if(grid[r][c] == 1){
                    area = 0;
                    dfs(grid, r,c);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
        
    }
    public void dfs(int[][] grid, int r, int c){
        //在最开始使用一个if语句用来筛选不合格的邻居，和在后边使用if语句，唯一的区别和好处：
        //不用在后边r+1，r-1判断索引是否越界了
        if(r < 0 || r >= row || c<0 || c >= col || grid[r][c] == 0) return;
        grid[r][c] = 0;//标记？
        area +=1;//面积增加1
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
        dfs(grid, r, c+1);
        dfs(grid, r, c-1);
        //对于从maxAreaOfIsland来的dfs对应的r、c来说，
        //当执行到这一步时，和r、c相连的所有的1，都变成了0，area也执行了++的操作。
        //之后，就会回到maxAreaOfIsland函数那里，所以，此时的area就是我们要的结果。
    }
}
