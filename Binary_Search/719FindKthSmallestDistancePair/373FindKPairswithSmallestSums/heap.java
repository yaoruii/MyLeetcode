class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //这道题给的tag是heap，今天也还没写heap，先用heap写了】
        PriorityQueue<int[]> minheap = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                int ar = nums1[a[0]] + nums2[a[1]];
                int br = nums1[b[0]] + nums2[b[1]];
                return Integer.compare(ar,br);
            }
        });
        List<List<Integer>> res = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        //n1和n2的大小没有note说明，所以：
        if(n1 == 0 || n2 == 0) return res;
        for(int i = 0; i< n2; i++){
            minheap.offer(new int[]{0, i});
        }
        int[] track ;
        //k的个数也没有说明，所以可能超出所有可能的pair的总和
        while(k>0 && !minheap.isEmpty()){
            track = minheap.poll();
            res.add(Arrays.asList(nums1[track[0]], nums2[track[1]]));//此时的最小值
            if(track[0]< n1-1)
                minheap.offer(new int[]{track[0]+1, track[1]});
            k--;
        }
        return res;
    }
}
