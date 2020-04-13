class Solution {
    public int row = 0;
    public int col = 0;
    public void solve(char[][] board) {
        //一个0，只要不是在边界，那么它肯定是被x或者另一个0包围者（上下左右四个框的值）
        //如何解决和边界0相连的0鉴别问题：对边界0运用bfs，这样先把与边界0在一个set的0变成e
        //然后，剩下的0一定不属于边界0，是需要变成1的，直接变就可以
        //dfs/bfs + union find
        //corner case
        //2d数组要这样处理corner case：首先自身不存在==null
        //其次，[]外部存在，内部长度为0
        if(board == null || board.length == 0) return;
        row = board.length; col = board[0].length;
        
        //找到边界0，对其运用bfs：
        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
        for(int r = 0; r < row; r++){
            if(board[r][0] == 'O') pairs.add(new Pair(r,0));
            if(board[r][col-1] == 'O') pairs.add(new Pair(r,col-1));
        }
        for(int c = 1; c< col-1; c++){
            if(board[0][c] == 'O') pairs.add(new Pair(0,c));
            if(board[row-1][c] == 'O') pairs.add(new Pair(row-1,c));
        }
        for(Pair<Integer, Integer> pair:pairs){
            bfs(board, pair.getKey(), pair.getValue());
        }
        for(int r = 0; r< row; r++){
            for(int c = 0; c< col; c++){
                if(board[r][c]=='O') board[r][c] ='X';
                else if(board[r][c]=='e') board[r][c] = 'O';
            }
        }
    }
    private void bfs(char[][] board, int r, int c){
        //以(r,c)为起点,union find+bfs
        //这是个啥，又不是mapQueue<Integer, Integer> fringe = new LinkedList<>();
        Queue<Pair<Integer, Integer>> fringe = new LinkedList<>();
        //是否还需要marked:被遍历过的邻居都变成e了，那么也不是0，不会形成cycle
        //HashMap<Pair<Integer, Integer>> marked = new HashMap<>();
        fringe.offer(new Pair(r, c));
        while(!fringe.isEmpty()){
            Pair<Integer, Integer> curr = fringe.poll();
            int rc = curr.getKey(); int cc = curr.getValue();
            if( board[rc][cc] != 'O') continue;
            board[rc][cc] = 'e';
            if(rc<row-1 && board[rc+1][cc] == 'O') fringe.offer(new Pair(rc+1, cc));
            if(rc>0 && board[rc-1][cc] == 'O') fringe.offer(new Pair(rc-1,cc));
            if(cc<col-1 && board[rc][cc+1] =='O') fringe.offer(new Pair(rc, cc+1));
            if(cc>0 && board[rc][cc-1] =='O') fringe.offer(new Pair(rc, cc-1));
            
        }
    }
}
