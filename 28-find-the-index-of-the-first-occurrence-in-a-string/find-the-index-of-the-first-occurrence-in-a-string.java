class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        if (m == 0) {
            return 0;
        }

        int[] lps = buildLPS(needle);

        int i = 0; // pointer into haystack
        int j = 0; // pointer into needle

        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    return i - j; // full match found
                }
            } else if (j > 0) {
                j = lps[j - 1]; // fall back using the failure function
            } else {
                i++; // no match at all, move haystack pointer
            }
        }

        return -1;
    }

    private int[] buildLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        int len = 0; // length of current matching prefix/suffix
        int i = 1;

        while (i < m) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }

        return lps;
    }
}

        
    
