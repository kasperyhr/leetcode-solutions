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