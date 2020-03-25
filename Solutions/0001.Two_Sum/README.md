# 0001.Two Sum

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**
```markdown
Given nums = [2, 7, 11, 15], target = 9,

Because nums[**0**] + nums[**1**] = 2 + 7 = 9,

return [**0, 1**].
```

这道题是最经典的一道题，任何学过算法的同学接触的第一道题就是这道。用一个hash table去存，key是这个index对应的数，value是这个index。

```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int i;
        for (i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}
```

Topic: [Hash Table](/Hash_Table/)

[Leetcode Link](https://leetcode.com/problems/two-sum/)
