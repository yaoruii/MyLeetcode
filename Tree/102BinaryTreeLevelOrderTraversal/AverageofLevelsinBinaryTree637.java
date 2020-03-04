public class AverageofLevelsinBinaryTree637 {
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
        public List<Double> averageOfLevels(TreeNode root) {
        /*BFS
        List<Double> res = new ArrayList<>();
        if(root == null){return res;}
        Queue<TreeNode> fringe = new LinkedList<>();
        fringe.offer(root);
        int nums;
        TreeNode track;
        //double sum ;
        long sum;//长整型才可以caver int型数据的相加
        while(! fringe.isEmpty()){
            nums = fringe.size();
            sum =0;
            for(int i =0; i< nums; i++){
                track = fringe.poll();
                //sum += (double)track.val/(double)(nums);//怎样求平均才能保证不越界？
                sum += track.val;
                if(track.left!= null){
                    fringe.offer(track.left);
                }
                if(track.right!= null){
                    fringe.offer(track.right);
                }
            }
            res.add(sum*1.0 / nums);
        }
        return res;*/
            //DFS
            List<Double> res = new ArrayList<>();
            List<Integer> count = new ArrayList<>();
            helper(root, res, count, 0);
            for(int i =0; i< res.size(); i++){
                res.set(i, res.get(i)/count.get(i));
            }
            return res;



        }
        public void helper(TreeNode root, List<Double> sum, List<Integer> count, int level){
            if(root == null){return;}
            if(sum.size()==level){
                sum.add(root.val*1.0);//从一开始计算sum的时候就是加的double数据
                count.add(1);
            }
            else if(sum.size() > level){//当穷尽完一条branch后（最左边的）我们到另一条branch后就会执行这个语句
                sum.set(level, sum.get(level)+root.val);
                count.set(level, count.get(level)+1);
            }
            helper(root.left, sum, count, level+1);
            helper(root.right, sum, count, level+1);
        }

    }
}
