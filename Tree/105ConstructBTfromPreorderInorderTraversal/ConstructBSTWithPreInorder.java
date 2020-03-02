public class ConstructBSTWithPreInorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
//心得：数据结构也同样重要，数组无法得到子数组，而将其转换为list可以，但是太慢
//而数组可以使用索引直接很紧，只需要一个start_pointer和end_pointer就可以完成子数组的事情，因为有了起始索引，我们基本上是得到了一个子数组，且不额外占用内存和操作
//使用map把inorder的元素和索引映射，节省了在inorder中寻找root的索引的操作
    class Solution {
        /*public TreeNode buildTree(int[] preorder, int[] inorder) {
            List<Integer> pre = Arrays.stream(preorder).boxed().collect(Collectors.toList());
            List<Integer> in = Arrays.stream(inorder).boxed().collect(Collectors.toList());
            return help(pre, in);

        }*/
        public TreeNode help( List<Integer> preorder, List<Integer> inorder){
            int len = preorder.size();
            if(len ==0 ){return null;}
            int root = preorder.get(0);
            TreeNode tree_root = new TreeNode(root);
            //找到root第一次在inorder[]中出现的位置索引
            int root_index = inorder.indexOf(root);
            //也就是说有root_index个元素在left tree中，我们要把这些元素的preorder找到
            //也就是在pre中从1开始，到root_index(包含)
            //int right_index = preorder.indexOf(inorder.get(root_index+1));
            //根据这两个索引，我们就可以得到：
            //left tree和right tree的各自的preorder,inorder
            tree_root.left = help(preorder.subList(1, root_index+1),inorder.subList(0, root_index) );
            tree_root.right = help(preorder.subList(root_index+1, len), inorder.subList(root_index+1, len));
            return tree_root;
        }
        //我采取了list特有的得到子列表的方法，导致要先转换成list,而且每次都会生成一个子list时间变长
        //实际上，使用pointer代表子数列的开始和起始位置即可，因为即使我们生成了子数列，我们也只是用到了preorder[0],剩下的全用于生成下一个子数列了，所以只需要找到我们用到的当前子数列的preorder[0]在原始数列中的位置即可，这样我们只需要一步读取数列元素即可得到root，之后改变这个pointer即可
        //改进：
        //有人用了hashmap去map元素和索引之间的关系，这样就不需要int root_index = inorder.indexOf(root);也不用产生新的子数列
        private HashMap<Integer, Integer> inmap = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder){
            if(preorder.length == 0 || inorder.length ==0 ){
                return null;
            }
            for(int i = 0;i< inorder.length;i++){
                inmap.put(inorder[i], i);//把元素放在keny的位置，因为我们只能通过key得到map的value，而我们想要的是索引，所以索引放在value位置
            }
            return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }


        private TreeNode helper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend){
            //相当于得到了preorder[pstart, pend](包含pend),inorder[istart,iend]和子数列一样
            if(pstart> pend || istart> iend){
                return null;
            }
            TreeNode root = new TreeNode(preorder[pstart]);
            //找到root第一次在inorder[]中出现的位置索引
            int root_index = inmap.get(root.val);
            //得到了root的索引，所以得到了left child有多少个元素
            int preleftend = root_index - istart + pstart;
            //有一个点很重要，本来我没有计算preleftend，我能计算的是leftnum= root_index - istart，这就导致在下边两个helper函数中我们用leftnum计算了两次preleftend，对这一点进行改进后，时间从2ms 变到了1ms；
            root.left = helper(preorder, pstart+1, preleftend, inorder, istart, root_index-1);
            root.right = helper(preorder, preleftend+1, pend, inorder, root_index+1, iend);
            return root;


        }

    }
}
