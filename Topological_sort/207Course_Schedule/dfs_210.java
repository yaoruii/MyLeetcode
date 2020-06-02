class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //使用dfs：因为207使用的bfs，可以直接拿过来用了，没啥意思喽
        // If it is impossible to finish all courses, return an empty array.
        //所以，不仅要得到拓扑顺序，还要在这个过程中判断是否是DAG
        if(numCourses==0) return null;
        int[] res = new int[numCourses];
        if(numCourses==1){
            res[0] = 0;
        }
        else{
            Stack<Integer> s = new Stack<>();
            Set<Integer> visited = new HashSet<>();
            Set<Integer> fake = new HashSet<>();
            //使用恰当的方式represent该graph
            List<Set<Integer>> graph = new ArrayList<>();
            for(int i = 0; i<numCourses;i++){
                graph.add(new HashSet<>());
            }
            for(int[] edge: prerequisites){
                //1 --->>> 0
                graph.get(edge[1]).add(edge[0]);
            }
            for(int i = 0; i<numCourses; i++){
                boolean flage = dfs(i, visited, graph, s,fake);
                if(!flage) return new int[0];
            }
            for(int i =0;i<numCourses;i++){
                res[i] = s.pop();
            } 
        }
        return res;
    }
    private boolean dfs(int node, Set<Integer> visited, List<Set<Integer>> graph, Stack<Integer> res,Set<Integer> fake){
        if(visited.contains(node)) return true;
        if(fake.contains(node)) return false;
        fake.add(node);//node被标记为fake，如果最终没有通过一个环再次到达node，再标记为visited
        //寻找未被参观的outgoing的nodes：
        Set<Integer> next = graph.get(node);
        for(int i : next){
            boolean flage = dfs(i, visited, graph, res,fake);
            if(! flage) return false;
        }
        fake.remove(node);
        visited.add(node);//这两步用于洗白node
        res.push(node);//将node加入到排序结果中
        return true;
    }
}
