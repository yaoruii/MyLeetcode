class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //4sum就是3sum的升级版，多一个loop为第二个元素
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len < 4) return res;
        Arrays.sort(nums);
        int i = 0; int left; int right; int sum; int t;
        while(i < len-3){
            if(i == 0 || (i>0 && nums[i] != nums[i-1])){
                for(int j = i+1; j< len-2;j++){
                    if(j==i+1 || j>1+i && nums[j] != nums[j-1]){
                        left = j+1; right = len-1; t = target - nums[i]-nums[j];
                        while(left< right){
                            sum = nums[left] + nums[right];
                            if(sum == t){
                                res.add(Arrays.asList(nums[i], nums[j], nums[left],nums[right]));
                                while(left<len-1&&nums[left] == nums[left+1]) left++;
                                while(right>1 && nums[right] == nums[right-1]) right--;
                                left++; right--;
                            }
                            else if(sum>t) right--;
                            else left++;
                        }
                    }
                }
            }
            i++;
               }
        return res;
               }
               }

   

               
