import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(s);
        queue.offer(s);

        boolean foundAtThisLevel = false;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String current = queue.poll();

                if (isValid(current)) {
                    result.add(current);
                    foundAtThisLevel = true;
                }

                if (foundAtThisLevel) {
                    continue; // don't bother generating further removals from this string
                }

                for (int j = 0; j < current.length(); j++) {
                    char c = current.charAt(j);
                    if (c != '(' && c != ')') {
                        continue;
                    }

                    String next = current.substring(0, j) + current.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            if (foundAtThisLevel) {
                break;
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false;
                }
            }
        }

        return balance == 0;
    }
}

        
    
