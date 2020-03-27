class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<inform> minheap = new PriorityQueue<>();
        for(int i = 0; i< n; i++) minheap.offer(new inform(matrix[0][i], 0, i));
        int count = 0;
        inform track;
        while(count < k-1){
            track = minheap.poll();
            count++;//count=x:已经有x个元素被poll()出去了，所以count最大为k-1的时候退出
            if(track.row == n-1) continue;//此时的track在最后一排，唯一会比它大的在右侧
            //所以不需要把下一行的元素（并且并没有下一行的元素）放进去
            minheap.offer(new inform(matrix[track.row +1][track.col], track.row+1, track.col));
        }
        return minheap.poll().val;
    }
    public class inform implements Comparable<inform>{
        int val;
        int row;
        int col;
        public inform(int v, int r, int c){
            val = v;
            row = r;
            col = c;
        }
        @Override
        public int compareTo(inform obj){
            if(this.val < obj.val) return -1;
            else if(this.val > obj.val) return 1;
            else return 0;
            
        }
    }
}
