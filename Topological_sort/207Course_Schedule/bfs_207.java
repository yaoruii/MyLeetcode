class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites){
        //这道题是判断给定的graph是否是有向无环图？？因为只有在DAG有拓扑顺序
        if(numCourses <= 1) return true;
        if(prerequisites==null || prerequisites.length == 0) return true;
        //int[][] graph = new int[numCourses][numCourses];
        List<Set<Integer>> graph = new ArrayList<>();
        for(int i =0; i<numCourses;i++) graph.add(new HashSet<>());
        int[] indegree = new int[numCourses];
        int numedges = prerequisites.length;
        for(int[] edge:prerequisites){
            //to take edge[0] need edge[1]:1-->>0
            indegree[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> s = new LinkedList<>();//存放入度为0的node
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0) s.offer(i);
        }
        //Stack<Integer> res = new Stack<>();
        while(!s.isEmpty()){
            int node = s.poll();//先选择一个叶子即可
            //找到这个node指向的孩子们，将指向的边去掉
            Set<Integer> set = graph.get(node);
            numedges -= set.size();//删去nodeoutgoing的边
            //res.push(node);//将node放入到排序结果中
            for(int next: set){//将所有的node指向的孩子的indegree-1,并且判断indegree是否为0
                if(--indegree[next] ==0) s.offer(next);
            }             
        }
        if(numedges != 0) return false;
        else return true;
        
    }
}
