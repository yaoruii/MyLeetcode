class Solution {
    public void wallsAndGates(int[][] rooms) {
        //bfs/dfs的题目中如何定义邻居是题目的关键
        //这道题是找对短路径，源是每一个INF，目标是0，相邻的node是inf或者0，-1表示不可到达
        //妈呀，我觉得这道题可以从0出发bfs?啊====>>>> 不可以，超时了
        if(rooms == null || rooms.length == 0) return;
        int row = rooms.length;int col = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r< row; r++){
            for(int c = 0; c<col; c++){
                if(rooms[r][c] == 0){
                    q.add(new int[]{r,c});
                }
            }
        }
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int rc = pair[0];int cc = pair[1];
            int level = rooms[rc][cc];
            if(rc < row-1 && rooms[rc+1][cc] == 2147483647){
                rooms[rc+1][cc] = level+1;
                q.offer(new int[]{rc+1, cc});
            }
            if(rc > 0 && rooms[rc-1][cc] == 2147483647){
                rooms[rc-1][cc] = level+1;
                q.offer(new int[]{rc-1, cc});
            }
            if(cc < col-1 && rooms[rc][cc+1] == 2147483647){
                rooms[rc][cc+1] = level+1;
                q.offer(new int[]{rc, cc+1});
            }
            if(cc >0 && rooms[rc][cc-1] == 2147483647){
                rooms[rc][cc-1] = level+1;
                q.offer(new int[]{rc, cc-1});
            }
        }
        
    }
    
    
}
