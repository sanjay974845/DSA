class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;   // 0 -> 0, 1 -> 1

        int left = 1, right = x / 2;
        int answer = 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {      // mid * mid <= x, without overflow
                answer = mid;          // mid is a valid floor candidate
                left = mid + 1;        // try something larger
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}

       
    
