class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        // firt sort the original nums so that we could apply the sliding window properly
        Arrays.sort(nums);
        // in range [0, N-1], min dist is 0, max dist is the dist between max and min num in nums
        int N = nums.length;
        int lo = 0, hi = nums[N - 1] - nums[0];
        while (lo <= hi) {
            // check if mid might be the kth dist
            int mid = lo + (hi - lo) / 2;
            // sliding window: for each `end` index, find the `start` so that
            // 1) in subarray [start, end], max dist == nums[end] - nums[start] <= m
            // 2) [start, end] is the longest subarray, which means start is min index satisfying condition 1
            int count = 0, maxDist = 0;
            for (int start = 0, end = 0; end < N; end++) {
                while (nums[end] - nums[start] > mid) start++;  // adjust start to satisfy conditions
                if (start < end) {
                    count += end - start;          // count num of pair ending with `end` and with dist <= m
                    maxDist = Math.max(maxDist, nums[end] - nums[start]); // mid might not be the exact dist, we need to keep the real dist along the way
                }
            }
            if (count == k) return maxDist;
            else if (count < k) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
