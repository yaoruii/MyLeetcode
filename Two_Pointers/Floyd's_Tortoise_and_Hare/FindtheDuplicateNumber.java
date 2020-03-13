class Solution {
    public int findDuplicate(int[] nums) {
        //There is only one duplicate number in the array,
        //but it could be repeated more than once.
        int hare = nums[0];
        int tortoise = nums[0];
        //使用do while循环，先执行一次再做判断
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];//移动两步
        }while( tortoise != hare);
        //为什么不可以直接返回？
        //2,5,9,6,9,3,8,9,7,1] 返回的是7
        //return hare;
        int ptr2 = hare;
        int ptr1 = nums[0];
        // do{
        //     ptr1 = nums[ptr1];
        //     ptr2 = nums[ptr2];
        // } while(ptr1 != ptr2);
        //这里不能用do whilw了，因为本来两者就指向不同的value了，最开始肯定不一样
        while(ptr1 != ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }
}
