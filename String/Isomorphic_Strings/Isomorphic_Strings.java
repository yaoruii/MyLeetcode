public class Isomorphic_Strings {
        public boolean isIsomorphic(String s, String t) {
            //自己的方法依旧太慢。。。
            //30ms.5%......
            //思考一下。。。。。。。。。。。。。
        /*
        int len = s.length();
        if(len == 0){return true;}
        //Set<Set> record = new HashSet<>();
        List<Integer> sr = new ArrayList<>();
        List<Integer> tr = new ArrayList<>();
        boolean[] marks = new boolean[len];
        boolean[] markt = new boolean[len];
        for(int i= 0; i< len;i++){
            if(marks[i] != markt[i]){return false;}
            if(! marks[i]){
                for(int j = i; j<len;j++){
                    if(s.charAt(i) == s.charAt(j)){
                        sr.add(j);
                        marks[j] = true;
                    }
                    if(t.charAt(i) == t.charAt(j)){
                        tr.add(j);
                        markt[j] = true;
                    }
                }
                if(!sr.equals(tr)){
                    return false;
                }
                sr.clear();
                tr.clear();
            }
        }
        return true;*/
            /*字符当索引法*/
            //4ms,88%
            int len = s.length();
            int[] sr = new int[256];
            int[] tr = new int[256];
            for(int i =0; i<len;i++ ){
                if(sr[s.charAt(i)] != tr[t.charAt(i)]){return false;}
                sr[s.charAt(i)] = i+1;
                tr[t.charAt(i)] = i+1;
            }
            return true;

        }
    }

