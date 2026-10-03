import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.isEmpty() || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        int totalLen = wordLen * numWords;
        int n = s.length();

        if (n < totalLen) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> windowCount = new HashMap<>();

            for (int right = offset; right + wordLen <= n; right += wordLen) {
                String word = s.substring(right, right + wordLen);

                if (wordCount.containsKey(word)) {
                    windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowCount.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }

                    if (count == numWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    windowCount.clear();
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return result;
    }
}

        
    
