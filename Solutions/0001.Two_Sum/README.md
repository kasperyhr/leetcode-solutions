# 0001.Two Sum

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

Topic: [Hash Table](../Hash_Table)
[Leetcode Link](https://leetcode.com/problems/two-sum/)
