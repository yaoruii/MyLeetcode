class Solution {
    public int countComponents(int n, int[][] edges) {
        //如果使用bfs：
        //时间上不太好，但是空间上达到了100%
        //使用uniob find
        //时间空间：100%
        int[] id = new int[n];
        //刚开始这些结点都是独立的，有n个set,所以可以用n表示set的个数
        for(int i = 0; i< n; i++){
            id[i] = i;
        }
        //根据edges[]数组，将结点进行union，每加一个node到某一个set，n就--,最后n就是结果
        for(int[] edge: edges){
            int root1 = find(id, edge[0]);
            int root2 = find(id, edge[1]);
            if(root1 != root2){
                id[root2] = root1;//每进行一次union，总set的个数就--；
                n--;
            }
        }
        return n;
    }
    private int find(int[] id, int p){
        while(p != id[p]) {
            //p不是根结点root，将p的母结点改成其祖母结点：
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }
}
