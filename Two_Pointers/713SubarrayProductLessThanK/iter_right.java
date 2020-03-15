public int numSubarrayProductLessThanK(int[] nums, int k) {
       if(k <= 1) return 0;
        int left = 0; int track = 1; int sum = 0; int len = nums.length;
        for(int right = 0; right < len; right++){
            track = track * nums[right];
            while(track >= k) track = track/nums[left++];
            //无论是跳出了while循环，还是压根没有进while循环，我们以right为末尾的寻找结束了
            sum += right - left + 1;
        }
        return sum;//beautiful啊
    }
