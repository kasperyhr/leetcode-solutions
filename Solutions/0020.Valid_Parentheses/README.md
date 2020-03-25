# 0020.Valid Parentheses

## 题目
Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**

```
Input: "()"
Output: true
```

**Example 2:**

```
Input: "()[]{}"
Output: true
```

**Example 3:**

```
Input: "(]"
Output: false
```

**Example 4:**

```
Input: "([)]"
Output: false
```

**Example 5:**

```
Input: "{[]}"
Output: true
```

[Leetcode Link](https://leetcode.com/problems/valid-parentheses/)

## 思路

这道题经典的stack题。

只要碰到左括号的时候放到stack中，如果碰到右括号，那么就和stack的peek进行比较。如果不匹配则return false。如果匹配则pop。

边界条件：
1. 在peek的时候可能没有元素，则返回false
2. 最后loop出来的时候要检测整个stack是否是empty的。如果不是empty的，那么就要返回false

## 答案

```Java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                
                if (ch == ')' && stack.peek() != '(') return false;
                if (ch == ']' && stack.peek() != '[') return false;
                if (ch == '}' && stack.peek() != '{') return false;
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
}
```

## 相关知识点
+ [Stack](/Stack/)
