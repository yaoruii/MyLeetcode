public class UniqueBinarySearchTree {

        public int numTrees(int n) {
            //BST tree的特性就是：root的左侧都是比root小的元素，root右侧都是比root大的元素
            //所以选定root后，左侧都是哪些元素，右侧都是哪些元素都是定了的
            //这些元素各自组成新的tree，成为root的left和right，而新的tree有多少可直接递归计算
            //因为左侧的元素是1-root-1,右侧的元素是root+1 - n，也是按照顺序来的
            //base case:
            if(n==1){return 1;}
            if(n==2){return 2;}
            int[] mem = new int[n+1];
            mem[1] = 1;//n=1的时候
            mem[2] = 2;//n =2的时候
            mem[0]= 1;//用于计算
            for(int i = 3;i<= n; i++){
                mem[i] = 0;//刚开始还没开始计算赋值，所以让所有值都是-1
            }
            //可以用DP保存下来计算的结果？
//         for(int root = 1; root<=n; root++){

//         }
            return numTrees(n, mem);
        }
        public int numTrees(int n, int[] mem){
            ///如果已经计算过n的结果，直接返回，反之进行计算，而DP不需要重复计算结点，提高了效率
            if(mem[n] != 0){return mem[n];}
            if(n <=2 ){
                mem[n] = n;
                mem[0]= 1;
            }
            else{//1,2,3,4,5....n
                // int left = 0;
                // int right = 0;
                //int res =0;
                for(int root = 1; root<= n; root++){
                    //res += numTrees(root-1, mem)*numTrees(n-root, mem);
                    mem[n] = mem[n]+numTrees(root-1, mem)*numTrees(n-root, mem);
                }
                //mem[n] = res;//因为

            }
            return mem[n];

        }

}
