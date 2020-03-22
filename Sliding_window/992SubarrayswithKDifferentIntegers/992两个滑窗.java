class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        //159那类题是至多K个元素，这类题是刚好K个元素
        int len = A.length;
        if(len < K) return 0;
        int sum = 0;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int left1 = 0; int right = 0;int left2 = 0;
        int track;
        while(right<len){
            track = A[right];
            map1.put(track, map1.getOrDefault(track,0)+1);
            map2.put(track, map2.getOrDefault(track,0)+1);
            while(map1.size()>=K && left1 <= right){
                //如果map==k了，进入while循环：
                //move on left,直到left到right这一对得到的子数列满足<k，left再往前当然也小，但是我们使用（right-left+1）把所有以right结尾，最左至多到left的子数列都包含进去了
                track = A[left1++];
                map1.put(track, map1.get(track)-1);
                map1.remove(track, 0);
            }
            while(map2.size()>K && left2<=right){
                track = A[left2++];
                map2.put(track, map2.get(track)-1);
                map2.remove(track, 0);
            }
            //运行到这一步，说明：
            //1,left1和right对应的map1中的这些元素，以right结尾的所有子字符串都小于K：
            //    1.1，因为(left1, right)小于K，所以再大的起点只会造成更小的size
            //2 left2和right对应的map2的元素，以right结尾的所有所有子字符串都小于等于K：
            //3，所以以right结尾的子字符串等于K的个数就是两者相减：
            sum += left1 - left2;
            //4,当前right的所有符合条件的结果找完了，进行下一个right：
            right++;
        }
        return sum;
       
    }
}
