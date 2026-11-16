class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0; // next write position

        for (int num : nums) {
            // Write if fewer than 2 kept so far, or num differs from the
            // element two slots behind the write position
            if (k < 2 || num != nums[k - 2]) {
                nums[k++] = num;
            }
        }
        return k;
    }
}

        
    
