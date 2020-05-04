class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            if (nums[m] < target) {
                l = m;
            } else if (nums[m] > target) {
                r = m;
            } else {
                return m;
            }
        }
        
        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return -1;
    }
}