class Solution {
    public int[] id;
    public int count= 0;
    public int[] size;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        if(positions==null || positions.length==0) return list;
        id = new int[m*n]; size = new int[m*n];
        // for(int r = 0; r<m;r++){
        //     for(int c = 0; c<n; c++){
        //         id[r*n+c] = r*n+c;
        //     }
        // }
        int[][] grid = new int[m][n];
        
        for(int[] position:positions){
            int r = position[0]; int c= position[1];
            if(grid[r][c] == 0){
                //有可能这里的值已经是1了，之前已经操作过一边了,所以不需要再count++等操作了。
                count++;grid[r][c] = 1;
                id[r*n+c] = r*n+c; size[r*n+c] = 1;
                if(r<m-1 && grid[r+1][c] == 1) union(r*n+c, r*n+c+n);
                if(r>0 && grid[r-1][c] == 1) union(r*n+c, r*n+c-n);
                if(c < n-1 && grid[r][c+1] ==1) union(r*n+c, r*n+c+1);
                if(c>0 && grid[r][c-1] ==1) union(r*n+c, r*n+c-1);
            }
            list.add(count);
        }
        return list;
    }
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j) return;
        if(size[i] < size[j]) {id[i] = j; size[j] +=size[i];}
        else{id[j] = i; size[i] += size[j];}
        count--;
        
    }
    public int find(int p){
        while(p != id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
