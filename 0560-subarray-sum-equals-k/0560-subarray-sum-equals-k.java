import java.util.*;

class Solution {

    public int subarraySum(int[] nums, int k) {

        // Prefix Sum -> Frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 has occurred once
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            // Update running sum
            prefixSum += nums[i];

            // If (prefixSum - k) exists,
            // all those occurrences form valid subarrays
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }

            // Increase frequency of current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}