class Solution {
    public int numIslands(char[][] grid) {
        //BFS：
        if(grid == null || grid.length == 0)
            return 0;
        int rn = grid.length;
        int cn = grid[0].length;
        int res=0;
        if(cn == 0) return 0;
        int rtmp; int ctmp; int id;
        for(int r = 0; r< rn; r++){
            for(int c = 0; c< cn; c++){
                if(grid[r][c]=='1'){
                    res++;
                    //BFS:
                    //marked操作：
                    grid[r][c] = '0';
                    Queue<Integer> fringe = new LinkedList<>();
                    fringe.offer(r*cn + c);
                    while(!fringe.isEmpty()){
                        id = fringe.poll();
                        rtmp = id/cn;
                        ctmp = id%cn;
                        //所有距离为1的nodes都被放入到队列中，下次先遍历
                        if(rtmp-1>=0 && grid[rtmp-1][ctmp] == '1'){
                            grid[rtmp-1][ctmp] = '0';
                            fringe.offer(id-cn);
                        }
                        if(rtmp+1<rn && grid[rtmp+1][ctmp]=='1'){
                            grid[rtmp+1][ctmp] = '0';
                            fringe.offer(id+cn);
                        }
                        if(ctmp-1>=0 && grid[rtmp][ctmp-1]=='1'){
                            grid[rtmp][ctmp-1] = '0';
                            fringe.offer(id-1);
                        }
                        if(ctmp+1< cn && grid[rtmp][ctmp+1]=='1'){
                            grid[rtmp][ctmp+1] = '0';
                            fringe.offer(id+1);
                        }

                    }
                }
            }
        }
        return res;
    }
}
