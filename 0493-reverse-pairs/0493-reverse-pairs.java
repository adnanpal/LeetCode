class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] arr, int left, int right) {

        if (left >= right) {
            return 0;
        }

        int count = 0;

        int mid = left + (right - left) / 2;

        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);

        // Count reverse pairs
        count += countPairs(arr, left, mid, right);

        // Normal merge
        merge(arr, left, right, mid);

        return count;
    }

    public static int countPairs(int[] arr, int left, int mid, int right) {

        int count = 0;
        int j = mid + 1;

        // i is in the left half
        for (int i = left; i <= mid; i++) {

            // j is in the right half
            while (j <= right && (long) arr[i] > 2L * arr[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        return count;
    }

    static void merge(int[] arr, int left, int right, int mid) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        // Copy left half
        for (int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }

        // Copy right half
        for (int j = 0; j < n2; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;  // leftArray pointer
        int j = 0;  // rightArray pointer
        int k = left; // original array pointer

        // Merge two sorted halves
        while (i < n1 && j < n2) {

            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }

            k++;
        }

        // Remaining left elements
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Remaining right elements
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}