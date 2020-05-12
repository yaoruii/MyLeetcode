class Solution {
    public int hIndex(int[] citations) {
        //该数组中大于等于h的元素个数刚好有h个。
        //0<= h <= n
        //index h if h of his/her N papers have at least h citations each（至少是h）
        //the other N − h papers have no more than h citations each.（不多于h）
        if(citations==null || citations.length==0) return 0;
        Arrays.sort(citations);
        int n = citations.length;int h;
        //有n个大于等于最小值，有1个大于等于最大值，
        if(citations[n-1]<=1) return citations[n-1];
        if(citations[0] >=n) return n;
        //大于等于第i个元素的个数：n-i，i是索引
        //所以，h首先是n-i，其次这个数大于a[i-1]，小于等于a[i]就可以
        for(int i =1; i<n;i++){
            h = n-i;//h个文章大于等于a[i]处的引用。
            //注意：！！剩下的n-h个元素是不大于即可，即使等于也是ok的
            if(citations[i-1]<=h && h<=citations[i]) return h;
        }
        return 0;
    }
    //hash table要怎么用？？
    
}
