class Solution {
    TreeNode track;
    double t;
    public int closestValue(TreeNode root, double target) {
        t = target;
        mindis(root);
        return track.val;
    }
    public double mindis(TreeNode root){
        double dis = root.val - t;
        if( dis >0 && root.left != null){
            //dis = Math.min(Math.abs(dis), Math.abs(mindis(root.left)));
            if(Math.abs(dis) < Math.abs(mindis(root.left))){
                track = root;
            }
            else dis = mindis(root.left);
        }
        else if(dis<0 && root.right != null){
            //dis = Math.min(Math.abs(dis), Math.abs(closestValue(root.right)));
            if(Math.abs(dis) < Math.abs(mindis(root.right))){
                track = root;
            }
            else dis = mindis(root.right);
        }
        else{
            track = root;
        }
        
        return dis;
    }
}
