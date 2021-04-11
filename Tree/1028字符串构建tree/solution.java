package paid;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;

    }
}

public class RecoverTreeFromPre { 
    public static void main(String[] args) {
        String str = "1-2--3--4-5--6--7";
        helper(str, 1);
        
    }
    public static TreeNode helper(String str, int base){
        int n = str.length();
        if(n==0) return null;
        if(n==1)  {
            System.out.print("root: "+ str.charAt(0)+'\n');
            return new TreeNode(str.charAt(0)-'0');

        }
        TreeNode root = new TreeNode(str.charAt(0)-'0');
        System.out.print("root: "+ root.val+'\n');
        //开始找开头为 base 个 - 的元素：
       
        int leftstart = base+1;
        int rightstart = leftstart;
        int currnum = 0;
        for(int i = rightstart+1; i<str.length(); i++){
            if(str.charAt(i)=='-'){
                currnum++;
            }else{
                if(currnum==base){
                    //此时的i就是rightstart
                    rightstart = i;
                    System.out.print("此时的right child 为："+ str.charAt(i)+'\n');
                    break;
                }else{
                    currnum=0;
                }
            }
        }
        String left ,right;
        if(rightstart == leftstart){
            //If a node has only one child, that child is guaranteed to be the left child.
            left= str.substring(leftstart);
            
        }else{
            left = str.substring(leftstart, rightstart-base);
            right = str.substring(rightstart);
            root.right = helper(right, base+1);
        }
        root.left = helper(left, base+1);
        return root;

        




    }
    
}
