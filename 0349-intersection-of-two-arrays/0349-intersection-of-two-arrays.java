class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int count = 0;

        for (int i = 0; i < nums1.length; i++) {

            int target = nums1[i];

            if (binarySearch(nums2, target)) {

                // avoid duplicate elements
                if (count == 0 || temp[count - 1] != target) {
                    temp[count] = target;
                    count++;
                }
            }
        }

        int[] result = new int[count];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static boolean binarySearch(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

}