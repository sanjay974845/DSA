class Solution {
    public String countAndSay(int n) {
        String current = "1";

        for (int round = 2; round <= n; round++) {
            StringBuilder next = new StringBuilder();
            int count = 1;

            for (int i = 1; i < current.length(); i++) {
                if (current.charAt(i) == current.charAt(i - 1)) {
                    count++;
                } else {
                    next.append(count).append(current.charAt(i - 1));
                    count = 1;
                }
            }

            next.append(count).append(current.charAt(current.length() - 1));

            current = next.toString();
        }

        return current;
    }
}

        
    
