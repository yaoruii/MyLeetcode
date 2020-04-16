class Solution {
    public class Unionfind{
        public int[] id;
        public int[] size;
        public int row; public int col;public int num;public int count;
        public Unionfind(char[][] grid){
            row = grid.length;col = grid[0].length;
            num = row*col;
            id = new int[num]; size = new int[num];
            for(int r=0; r< row; r++){
                for(int c = 0; c< col; c++){
                    if(grid[r][c]=='1'){
                        id[r*col + c] = r*col+c;
                        size[r*col+c] = 1;
                        count++;
                    }
                }
            }
        }
        public int count(){
            return count;
        }
        public int find(int p){
            while(p != id[p]){
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }
        public void union(int p, int q){
            int root1 = find(p);
            int root2 = find(q);
            if(root1 == root2) return;
            if(size[root1] < size[root2]) {id[root1]=root2;size[root2] += size[root1];}
            else {id[root2]= root1;size[root1]+=size[root2];}
            count--;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length == 0) return 0;
        Unionfind set = new Unionfind(grid);
        int row = grid.length;int col = grid[0].length;
        for(int r=0; r<row;r++){
            for(int c=0;c<col;c++){
                if(grid[r][c] =='1'){
                    grid[r][c] ='0';
                    if(r<row-1 && grid[r+1][c] == '1') set.union(r*col+c, r*col+c+col);
                    if(r>0 && grid[r-1][c] =='1') set.union(r*col+c, r*col+c-col);
                    if(c<col-1 && grid[r][c+1] =='1') set.union(r*col+c, r*col+c+1);
                    if(c>0 && grid[r][c-1]=='1') set.union(r*col+c, r*col+c-1);
                }
            }
        }
        return set.count();
        
    }
}
