# 767. Reorganize String
```
Input: S = "aab"
Output: "aba"
```

```java
class Solution {
    public String reorganizeString(String S) {
        int[] s = new int[26];
        int len = S.length();
        for(int i =0; i<len; i++){
            s[S.charAt(i)-'a'] ++;
        }
        int max = 0; int letter = 0; 
        for(int i =0; i<26;i++){
            if(s[i]>max){
                max = s[i];
                letter = i;
            }
        }
        if(max>(len+1)/2) return "";
        char[] c = new char[len];
        //先把最多的元素放到数组中0，2，4...：因为元素最多且不超过(len+1)/2，所以，要先放进去
        //极端情况：a_a_a，or a_a_，奇数情况下，这是唯一的a的放置，偶数还可以放在1，3
        //如果不先把a放进去，比如：b_a_a，接下来放最后一个a：baa_a，失败
        //然后把剩下的元素放到数组中，不需要按照出现次数的顺序放入，每一次的放置都是step=2，
        //到头后，就从1-3-5开始，再次到头后，就是放置完了
        int idx = 0;
        while(s[letter]>0){
            c[idx] = (char) (letter+'a');
            idx +=2;
            s[letter]--;
        }
        for(int i = 0; i<26;i++){
            if(i==letter) continue;
            while(s[i]>0){
                if(idx>=len) idx = 1;//到头了，要从1-3-5-7.。重现开始
                c[idx] = (char)(i+'a');
                idx += 2;
                s[i]--;
            }
        }
        return String.valueOf(c);//valueOf()牛逼
    }
}
```
