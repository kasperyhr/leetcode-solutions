# 0069. Sqrt(x) (Easy-)

## 题目

Implement int `sqrt(int x)`.

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**
```
Input: 4
Output: 2
```

**Example 2:**
```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

[Leetcode Link](https://leetcode.com/problems/sqrtx/)

## 思路

这道题我们要找到一个最大的整数数`y`使得`y * y <= x`。故，我们可以用二分法找`y`。

## 答案
```Java
class Solution {
    public int mySqrt(int x) {
        long l = 0;
        long r = x;
        long m;
        while (l + 1 < r) {
            m = l + (r - l) / 2;
            if (m * m < x) {
                l = m;
            } else if (m * m == x) {
                return (int) m;
            } else {
                r = m;
            }
        }
        
        if (r * r <= x) return (int) r;
        return (int) l;
    }
}
```

## 相关知识点

+ [Binary Search](/Topic/Binary_Search/)
