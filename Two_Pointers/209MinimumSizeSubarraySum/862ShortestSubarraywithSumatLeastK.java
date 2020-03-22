class Solution {
    public int shortestSubarray(int[] A, int K) {
        //最短的和至少为K的子数组：sum>=K
        //有点意思：[84,-37,32,40,95]
        int len = A.length;
        int left = 0; int right = 0; int sum = 0; int res = len+1;
        Deque<Integer> b = new LinkedList<>();//当前right再b中寻找和她配对的人
        int[] prefix = new int[len+1];
        while(right<= len){
            //为什么要包含len，因为prefix[i]是不包含i的元素的和，所以最后为了获取包含最后一个数的prefix，right要等于len！
            if(right<len){
                prefix[right+1] = prefix[right] +  A[right];
            }
            //如果即将被放进去的right对应的p，比队列的最后一个索引对应的数对应的小
            while(!b.isEmpty() && prefix[right]<= prefix[b.peekLast()]){
                //如果当前right作为起点和未来的某个right满足条件，那么当前last不是我们要的
                //如果当前right作为起点无法和某个right满足，当前last更加无法
                //所以当前last没有保留的必要
                //while循环下去，直到放入当前right后b是递增的
                b.pollLast();
            }
            while(!b.isEmpty() && prefix[right] - prefix[b.peekFirst()] >=K){
                //当前right和候选池中的第一个满足条件了，可以更新res了
                //第一个满足：后边的right即使再次满足，也不是最短的了
                //所以第一个作为left，已经完成使命，可以被抛弃
                res = Math.min(res, right - b.pollFirst());
                //后边的left还是有满足条件的可能：所以使用while循环，直到第一个元素无法满足 
            }
            
            //一路遍历right再把right同时变成潜在的“left”：加入到队列中，被以后的right挑选
            //但是放进去之前是需要一些操作使得队列满足一些条件的：上边的while循环。
            //运行到这里，说明；1，候选池的第一个元素都无法和当前的right配对
            //2，当前right的p比候选池的最后一个数的prefix大
            //把right加入到候选池，日后作为left被之后的right挑选
            b.offerLast(right); 
            right++;
        }
        if(res == len+1) return -1;
        return res;
        
    }
}
