class Solution {
    public String frequencySort(String s) {
        int len = s.length();
        if(len<=1) return s;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i< len;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        List<Character>[] buckets = new List[len+1];
        int fre;
        for(char key: map.keySet()){
            fre = map.get(key);
            if(buckets[fre]==null){
                buckets[fre] = new ArrayList<>();
            }
            buckets[fre].add(key);
        }
        //gather result
        StringBuilder res = new StringBuilder();
        for(int i = len; i>=0;i--){
            if(buckets[i]!= null){
                for(char c : buckets[i]){
                    for(int j = 0; j<i;j++)
                    res.append(c); 
                }
            }
        }
        return res.toString();
    }
}
