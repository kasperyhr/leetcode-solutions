# 0035. Search Insert Position (Easy-)

## 题目

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**
```
Input: [1,3,5,6], 5
Output: 2
```

**Example 2:**
```
Input: [1,3,5,6], 2
Output: 1
```

**Example 3:**
```
Input: [1,3,5,6], 7
Output: 4
```

**Example 4:**
```
Input: [1,3,5,6], 0
Output: 0
```

[Leetcode Link](https://leetcode.com/problems/search-insert-position/)

## 思路

这道题是要找到第一个大于等于target数的位置，如果没有则返回该array的长度（即最后）。故我们可以用binary search去实现。

## 答案
```Java
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
```

## 相关知识点

+ [Binary Search](/Topics/Binary_Search/)
