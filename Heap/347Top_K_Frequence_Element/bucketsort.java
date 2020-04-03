class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //这些题都好神奇啊。。
        //把map存在heap中？
        HashMap<Integer, Integer> map = new HashMap<>();
        //get the value-frequence map
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        //不是把map存在heap中，是把map中的一对对基于value进行桶排序
        //此处，桶的序号就是每个元素出现的频率
        //map的键值对的个数==number of unique elements.
        int len = nums.length;
        //一个元素最多出现len次，所以长度要为len+1，这样才有索引为len的空
        List<Integer>[] buckets = new List[len+1];
        int fre;
        //put value in buckets based on frequence
        for(int key : map.keySet()){
            fre = map.get(key);
            if(buckets[fre] == null)
                buckets[fre] = new ArrayList<>();
            buckets[fre].add(key);
        }
        //gather result
        List<Integer> res = new ArrayList<>();
        for(int i = len; i>=0 ; i--){
            if(buckets[i] != null){
                res.addAll(buckets[i]);
            }
            //是k个元素，出现次数相同的n个元素就占了n个配额
            //比如，1和2都出现了10次，那么top2是1和2,在buckets[10]中就一下子加入完了
            if(res.size()>=k) break;
        }
        return res;
    }  
}
