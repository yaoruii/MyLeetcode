class Solution {
    public int findCircleNum(int[][] M) {
        //从i = 0-n-1,j = i+1-n-1遍历？
        //如果使用union find
        int n = M.length;
        int res = n;
        int[] id = new int[n];
        for(int i = 0; i< n; i++){
            id[i] = i;
        }
        for(int i = 0; i<n; i++){
            for(int j = i+1; j< n; j++){
                if(M[i][j] == 1){
                    int root1 = find(id, i);
                    int root2 = find(id, j);
                    if(root1 != root2){
                        id[root2] = root1;
                        res--;
                    }
                }
            }
        }
        return res;
    }
    public int find(int[] id, int p){
        while(p != id[p]){
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
