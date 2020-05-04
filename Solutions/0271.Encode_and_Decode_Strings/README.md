# 0271.Encode and Decode Strings (Easy)

## 题目

Design an algorithm to encode **a list of strings** to **a string**. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

```
string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
```

Machine 2 (receiver) has the function:
```
vector<string> decode(string s) {
  //... your code
  return strs;
}
```

So Machine 1 does:
```
string encoded_string = encode(strs);
```

and Machine 2 does:
```
vector<string> strs2 = decode(encoded_string);
```

`strs2` in Machine 2 should be the same as `strs` in Machine 1.

Implement the `encode` and `decode` methods.

**Note:**
+ The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
+ Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
+ Do not rely on any library method such as `eval` or serialize methods. You should implement your own encode/decode algorithm.

[Leetcode Link](https://leetcode.com/problems/encode-and-decode-strings/)

## 思路

这是一道tcp协议的传输方式的一道题。要点在于，传输的字符串必须在之前注明该字符串的长度为多少，然后用分隔符分隔开长度和传输的字符串。这样就可以确保字符串长度不会出错。

这里的解法是首先获取整个list的长度，用分隔符分隔。对于每个字符串，获取它的长度，分隔符分隔，接上该字符串。

`["a", "ab", "abc", "abcd"]` 转换为 `"4-1-a2-ab3-abc4-abcd"`。我们不必在上个字符串后和下个字符串的长度之间加分隔符。如果你想让转换可读性更高，那么可以考虑在这之间加上分隔符。

## 答案

```Java
public class Codec {
    public static final Character SPLITTER = '-';
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        int cnt = strs.size();
        sb.append(cnt);
        sb.append(SPLITTER);
        
        for (int i = 0; i < cnt; i++) {
            String str = strs.get(i);
            sb.append(str.length());
            sb.append(SPLITTER);
            sb.append(str);
        }
        
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char[] ch = s.toCharArray();
        List<String> res = new ArrayList<>();
        
        int cnt = 0;
        int idx = 0;
        
        while(ch[idx] != SPLITTER) {
            cnt *= 10;
            cnt += ch[idx++] - '0';
        }
        idx++;
        
        int len;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < cnt; i++) {
            len = 0;
            while(ch[idx] != SPLITTER) {
                len *= 10;
                len += ch[idx++] - '0';
            }
            idx++;
            
            sb.delete(0, sb.length());
            while (len-- > 0) {
                sb.append(ch[idx++]);
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
```

## 相关知识点

+ [String](/Topics/String/)

