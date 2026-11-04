import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        for (String token : path.split("/")) {
            if (token.isEmpty() || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.isEmpty()) stack.pollLast();
            } else {
                stack.addLast(token);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append('/').append(dir);
        }
        return sb.toString();
    }
}

        
    
