class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || target <= nums[0])
            return 0;
        int l = 0;
        int r = nums.length - 1;
        int m;
        while(l + 1 < r){
            m = l + (r - l) / 2;
            if(nums[m] < target){
                l = m;
            } else{
                r = m;
            }
        }
        
        if(nums[l] >= target){
            return l;
        } else if (nums[r] >= target) {
            return r;
        } else {
            return nums.length;
        }

    }
}