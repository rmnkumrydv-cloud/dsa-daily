import java.util.*;

class Solution {

    class pair {
        int i1, i2, len;

        pair(int i1, int i2, int len) {
            this.i1 = i1;
            this.i2 = i2;
            this.len = len;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof pair)) return false;
            pair p = (pair) o;
            return i1 == p.i1 && i2 == p.i2 && len == p.len;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i1, i2, len);
        }
    }

    String s1, s2;
    HashMap<pair, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        this.s1 = s1;
        this.s2 = s2;
        return check(0, 0, s1.length());
    }

    private boolean check(int i1, int i2, int len) {

        pair key = new pair(i1, i2, len);

        if (map.containsKey(key)) return map.get(key);

        boolean same = true;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i1 + i) != s2.charAt(i2 + i)) {
                same = false;
                break;
            }
        }
        if (same) {
            map.put(key, true);
            return true;
        }

        int[] count = new int[26];
        for (int i = 0; i < len; i++) {
            count[s1.charAt(i1 + i) - 'a']++;
            count[s2.charAt(i2 + i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                map.put(key, false);
                return false;
            }
        }

        for (int k = 1; k < len; k++) {

            if (check(i1, i2, k) &&
                check(i1 + k, i2 + k, len - k)) {
                map.put(key, true);
                return true;
            }

            if (check(i1, i2 + len - k, k) &&
                check(i1 + k, i2, len - k)) {
                map.put(key, true);
                return true;
            }
        }

        map.put(key, false);
        return false;
    }
}