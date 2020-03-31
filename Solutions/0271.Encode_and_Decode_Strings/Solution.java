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