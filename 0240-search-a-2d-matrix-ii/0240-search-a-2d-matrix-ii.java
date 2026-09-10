class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int row = 0; row < rows; row++) {

            int low = 0;
            int high = cols - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (matrix[row][mid] == target) {
                    return true;
                }

                if (matrix[row][mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}