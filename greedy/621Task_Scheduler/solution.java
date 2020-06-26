class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] nums = new int[26];//26个字母
        int max = 0;
        for(char task: tasks){
            nums[task -'A'] ++;
            max = Math.max(max, nums[task-'A']);
        }
        List<Character> most = new ArrayList<>();
        for(int i = 0; i<26;i++){
            if(nums[i]==max) most.add((char)(i+'A'));
        }
        int nummost = most.size();
        int partnum = max-1;//被分割为这么多块
        int emptynum = partnum *(n-nummost +1);//放置好所有出现最多次的元素后空的slots数量
        //如果nummost大于n，也就是为n+1：
        //1，会将空位填满，从上边的等式也可以看出来为0
        //2，之后的元素，出现次数都会小于max，所以，只需要将他们无限次地放入到每一个part的末尾即可
        //3，因为此时，我们已经满足最低要求。
        int resttask = tasks.length - max * nummost;
        int numidle = Math.max(0, emptynum-resttask);
        return tasks.length + numidle;
    
    }
}
