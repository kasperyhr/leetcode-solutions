# 0136. Single Number (Easy)

## 题目

Given a **non-empty** array of integers, every element appears *twice* except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**
```
Input: [2,2,1]
Output: 1
```

**Example 2:**
```
Input: [4,1,2,1,2]
Output: 4
```

[Leetcode Link](https://leetcode.com/problems/single-number/)

## 思路

这道题显然我们可以用一个Hash Set去记录出现过一次的数字，如果第二次出现，那么我们可以从这个Hash Set当中去除。最后只剩下一个。不过题目希望我们用O(1)的空间记录，显然这样就不符合了。

如果学过位运算的话，我们知道两个相同的数异或会得到0。而且异或符合交换律，结合律。

那么我们可以把array当中的所有的数字异或，那么就会得到单独剩下的数字。

## 答案
```Java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num: nums) {
            res ^= num;
        }
        
        return res;
    }
}
```

## 相关知识点

+ [Bit Manipulation](/Topics/Bit_Manipulation)
