import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] arr3 = new int[m + n];

        int left = 0;   // nums1 pointer
        int right = 0;  // nums2 pointer
        int index = 0;  // arr3 pointer

        // Compare elements from both arrays
        while (left < m && right < n) {

            if (nums1[left] <= nums2[right]) {

                arr3[index] = nums1[left];

                left++;
                index++;

            } else {

                arr3[index] = nums2[right];

                right++;
                index++;
            }
        }

        // Remaining elements of nums1
        while (left < m) {
            arr3[index] = nums1[left];

            left++;
            index++;
        }

        // Remaining elements of nums2
        while (right < n) {
            arr3[index] = nums2[right];

            right++;
            index++;
        }

        // Copy merged array back into nums1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = arr3[i];
        }
    }
}