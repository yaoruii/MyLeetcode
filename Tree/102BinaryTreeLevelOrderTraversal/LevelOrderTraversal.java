public class LevelOrderTraversal {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
            //BFS:
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){return res;}
            Queue<TreeNode> fringe = new LinkedList<>();
            fringe.offer(root);
            int num;
            TreeNode track;
            while(! fringe.isEmpty()){
                List<Integer> level = new ArrayList<>();//每次都要创建新的，和track不一样
                num = fringe.size();
                for(int i = 0; i<num; i++){//同时存在于队列中的所有元素都是同一层level的
                    track = fringe.poll();//从队列中移除结点v
                    level.add(track.val);//将v加入到该level的list中
                    if(track.left != null){
                        fringe.offer(track.left);
                    }
                    if(track.right != null){
                        fringe.offer(track.right);
                    }
                }
                //同一个level的遍历完了之后将这个list加入到res中
                res.add(level);
            }
            return res;


        }
    }
}
