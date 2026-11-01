import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        int i = 0;

        while (i < n) {
            // 1. find the last word index that fits on this line
            int j = i;
            int lineLen = 0;   // total letters, no spaces
            while (j < n && lineLen + words[j].length() + (j - i) <= maxWidth) {
                lineLen += words[j].length();
                j++;
            }
            // words[i..j-1] go on this line
            int count = j - i;
            int gaps = count - 1;
            StringBuilder sb = new StringBuilder();

            if (j == n || gaps == 0) {
                // last line or single word: left-justify
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) sb.append(' ');
                }
                while (sb.length() < maxWidth) sb.append(' ');
            } else {
                // full justify
                int totalSpaces = maxWidth - lineLen;
                int each = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spaces = each + (k - i < extra ? 1 : 0);
                        for (int s = 0; s < spaces; s++) sb.append(' ');
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}

        
    
