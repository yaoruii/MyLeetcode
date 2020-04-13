class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //BFS
        //预处理:
        int len = wordList.size();
        HashMap<String, List<String>> genericMap = new HashMap<>();
        int l ;
        for(String curr : wordList){
            l = curr.length();
            for(int i = 0; i< l; i++){
                String newWord = curr.substring(0,i) + "*" + curr.substring(i+1, l);
                List<String> value = genericMap.getOrDefault(newWord, new ArrayList<>());
                value.add(curr);
                genericMap.put(newWord, value);
            }
        }
        
        //do bfs:
        Queue<Pair<String, Integer>> fringe = new LinkedList<>();
        HashMap<String, Boolean> marked = new HashMap<>();
        marked.put(beginWord, true);//标记起点
        fringe.offer(new Pair(beginWord, 1));//将它加入队列
        while(! fringe.isEmpty()){
            Pair<String, Integer> curr = fringe.poll();//从队列中删去下一个顶点
            //寻找该顶点的“邻居”
            String word = curr.getKey();
            int level = curr.getValue();
            l = word.length();
            for(int i = 0; i< l; i++){
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, l);
                for(String node: genericMap.getOrDefault(newWord, new ArrayList<>())){
                    if(node.equals(endWord))//已经找到终点，结束：总路径= 当前步数+1
                        return level+1;
                    if(!marked.containsKey(node)){
                        marked.put(node, true);//标记它，因为他的最短路径已知
                        fringe.offer(new Pair(node, level+1));
                    }
                }
            }
        }
        return 0;
        
        
    }
}
