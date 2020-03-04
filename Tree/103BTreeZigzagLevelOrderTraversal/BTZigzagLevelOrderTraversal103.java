public class BTZigzagLevelOrderTraversal103 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            //BFS：
            //这就是用的102的level-level的traversal的方法，还是按照顺序遍历的，只是存放的时候是不同的顺序，有人提到这种不是真正的ZigZag Level Order Traversal。我觉得有道理
        /*
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){return res;}
        TreeNode track;
        Queue<TreeNode> fringe = new LinkedList<>();
        fringe.offer(root);
        int num;
        boolean dir = true;
        while(!fringe.isEmpty()){
            num = fringe.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i< num; i++){
                track = fringe.poll();
                if(dir){
                    level.add(track.val);
                }
                else{
                   level.add(0,track.val);
                }
                if(track.left != null){
                    fringe.offer(track.left);
                }
                if(track.right != null){
                    fringe.offer(track.right);
                }
            }
            res.add(level);
            dir =!dir;
        }
        return res;*/
            //使用两个堆栈/队列去保存不同顺序的level:s1:0,2,4..s2:1,3,5,7...
            //不能用队列的原因是：一开始觉得先放入track.right,再放入track.left不就好了
            //但是这会造成我们把第二层按照s2=【20，9】进入了s2，然后对s2进行操作时，20先出来，新的放入【20】然后把【15，7】放入s1，同理最后变成s1=【15，7，1，2】（如果9的左是1，右是2），然后，15先出，没有孩子放入队列，最后的level-list=【15，7，1，2】而这是不对的
            //为什么堆栈可以：
            //第二层按照s2=【9，20】，20先出来，加入到level-list,然后把【7，15】放入s1,然后9出来，加入到level-list，最后s1=【7，15，2，1】，最后到第三层s1的时候，出来加入到list为【1，2，15，7】符合正常结果
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;
            Stack<TreeNode> s1 = new Stack<>();//存放level=0，2，4的
            Stack<TreeNode> s2 = new Stack<>();//存放level= 1，3，5的
            s1.push(root);
            TreeNode track;
            while(!s1.isEmpty()){
                List<Integer> level1 = new Stack<>();
                while(!s1.isEmpty()){
                    track = s1.pop();
                    level1.add(track.val);
                    if(track.left!= null) s2.push(track.left);//先放left，这样right就会先出来
                    if(track.right != null) s2.push(track.right);
                }
                res.add(level1);
                List<Integer> level2 = new Stack<>();
                while(!s2.isEmpty()){
                    track = s2.pop();//先出来的是20
                    level2.add(track.val);
                    if(track.right != null) s1.push(track.right);
                    if(track.left != null) s1.push(track.left);
                }
                if(!level2.isEmpty()) res.add(level2);
            }
            return res;
        }
    }
}
