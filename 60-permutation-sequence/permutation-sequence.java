import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // factorials: fact[i] = i!
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        List<Integer> digits = new ArrayList<>();
        for (int i = 1; i <= n; i++) digits.add(i);

        k--;  // convert to 0-indexed
        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            sb.append(digits.remove(index));
            k %= fact[i];
        }
        return sb.toString();
    }
}

        
    
