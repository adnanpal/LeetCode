import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        for (int left = 0; left < n - 3; left++) {

            // Skip duplicate first values
            if (left > 0 && nums[left] == nums[left - 1]) {
                continue;
            }

            for (int j = left + 1; j < n - 2; j++) {

                // Skip duplicate second values
                if (j != left + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int right = n - 1;

                while (k < right) {

                    long sum = (long) nums[left]
                             + nums[j]
                             + nums[k]
                             + nums[right];

                    if (sum == target) {

                        List<Integer> temp = new ArrayList<>();

                        temp.add(nums[left]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[right]);

                        ans.add(temp);

                        k++;
                        right--;

                        // Skip duplicate third values
                        while (k < right && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        // Skip duplicate fourth values
                        while (k < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    } else if (sum < target) {

                        k++;

                    } else {

                        right--;
                    }
                }
            }
        }

        return ans;
    }
}