# 0704. Binary Search (Easy-)

## 题目

Given a **sorted** (in ascending order) integer array `nums` of `n` elements and a `target` value, write a function to search `target` in `nums`. If `target` exists, then return its index, otherwise return `-1`.

**Example 1:**
```
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
```

**Example 2:**
```
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
```

**Note:**

1. You may assume that all elements in `nums` are unique.
2. `n` will be in the range `[1, 10000]`.
3. The value of each element in `nums` will be in the range `[-9999, 9999]`.

[Leetcode Link](https://leetcode.com/problems/binary-search/)

## 思路

题目很明确是binary search，那么套模版就行了。

## 答案
```Java
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
```
