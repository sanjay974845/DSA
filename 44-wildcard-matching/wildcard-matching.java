class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        int i = 0, j = 0;
        int starIdx = -1;
        int match = 0;

        while (i < n) {
            if (j < m && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < m && p.charAt(j) == '*') {
                starIdx = j;
                match = i;
                j++;
            } else if (starIdx != -1) {
                j = starIdx + 1;
                match++;
                i = match;
            } else {
                return false;
            }
        }

        while (j < m && p.charAt(j) == '*') {
            j++;
        }

        return j == m;
    }
}
   
        
   
