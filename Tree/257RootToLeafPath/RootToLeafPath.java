public class RootToLeafPath {
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> paths = new ArrayList<>();
            if(root == null){
                return paths;
            }

            //String r = root.val.toString();
            //int如何转换为string，已经遇到过很多次了，请长记性。
            String r = String.valueOf(root.val);
            if(root.left == null && root.right == null){
                paths.add(r);
                return paths;
            }
            List<String> subpaths ;
            if(root.left!= null){
                subpaths= binaryTreePaths(root.left);//left有可能是null
                subpaths.addAll(binaryTreePaths(root.right));
            }
            else{
                subpaths = binaryTreePaths(root.right);
            }
            for(String s: subpaths){
                if(s != null){
                    paths.add(r +"->" +s);
                }
            }
            return paths;

        }
    }
}
