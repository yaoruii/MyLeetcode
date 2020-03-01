public class isPowerOfTwo {

        public boolean isPowerOfTwo(int n) {
            //看看这个数是不是2的次方；
            if(n<=0){return false;}
            if(n ==1){return true;}
            if(n%2 != 0){return false;}
            //剩下的数就是>=2的偶数了，2.4.6，8.10.。。
            //想到了递归，如果n是2的次方，那么n/2也是2的次方，次方数小一，否则n也不是
            return isPowerOfTwo(n/2);
        }

}
