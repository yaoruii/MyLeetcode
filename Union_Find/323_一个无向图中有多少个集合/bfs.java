public int countComponents(int n, int[][] edges) {
        //如果使用bfs：
        //时间上不太好，但是空间上达到了100%
        Queue<Integer> q = new LinkedList<>();
        boolean[] marked = new boolean[n];
        int res = 0; int e = edges.length;
        for(int i =0; i< n; i++){
            if(marked[i] == false){
                //以i为源，进行bfs：
                res++;
                marked[i] = true;
                q.offer(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int j = 0; j< e; j++){
                        //这个for循环是为了找当前curr的邻居，所以不能用i
                        if(edges[j][0] == curr && !marked[edges[j][1]]){
                            q.offer(edges[j][1]);
                            marked[edges[j][1]] = true;
                        }
                        else if (edges[j][1] == curr && !marked[edges[j][0]]){
                            q.offer(edges[j][0]);
                            marked[edges[j][0]] = true;
                        } 
                    }
                }
            }
        }
        return res;
        }
