class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        int len = strs.length;
        if(len == 0) return res;
        
        //HashMap<char[], List<String>> map = new HashMap<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String i : strs){
            char[] c = i.toCharArray();
            //c.sort();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(map.containsKey(key)){
                map.get(key).add(i);
            }
            else{
                List<String> value = new LinkedList<>();
                value.add(i);
                map.put(key, value);
            }  
        }
        res.addAll(map.values());
        return res;
        
    }
}
