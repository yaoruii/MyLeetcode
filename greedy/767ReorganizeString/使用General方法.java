class Solution {
    public String reorganizeString(String S) {
        //之前用的是其他的方法，做完358后，尝试用358的通用方法方法做一下，相当于K=2
        //统计每一个字母出现的次数，并按照次数的大小放入到heap中
        int[] nums = new int[26]; int len = S.length();
        
        int k = 2;
        for(int i =0;i<len; i++){
            nums[S.charAt(i)-'a'] ++;
            //if(!pq.contains(S.charAt(i))) pq.offer(S.charAt(i));
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(new Comparator<Character>(){
            @Override
            public int compare(Character a, Character b){
                return nums[b-'a'] - nums[a-'a'];
            }
        }
        );
        for(int i = 0;i<26;i++){
            if(nums[i]>0 && !pq.contains((char)(i+97))) pq.offer((char)(i+97));
        }
        Queue<Character> queue = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            char currmost = pq.poll();
            res.append(currmost);
            nums[currmost-'a']--;
            queue.offer(currmost);
            if(queue.size()==k){//已经有K个字母被放进去，队首的字母可以被放出来了
                char first = queue.poll();
                if(nums[first-'a']>0) pq.offer(first);//下一次被啥时候放置，看自己的剩余次数
            }
        }
        return res.length()==len ? res.toString():"";
    }
}
