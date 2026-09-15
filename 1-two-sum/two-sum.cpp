#include <vector>
#include <unordered_map>

class Solution {
public:
    std::vector<int> twoSum(std::vector<int>& nums, int target) {
        std::unordered_map<int, int> seen;
        
        for (int i = 0; i < nums.size(); ++i) {
            int complement = target - nums[i];
            
            // Check if complement has already been seen
            auto it = seen.find(complement);
            if (it != seen.end()) {
                return {it->second, i};
            }
            
            // Record the current number's index
            seen[nums[i]] = i;
        }
        
        return {};
    }
};