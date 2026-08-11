class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int left = 0;
        int right = m-1;
        int top = 0;
        int bottom = n-1;

        while(left<=right && top<=bottom){

            //left right
            for(int i = left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //top-bottom;
            for(int j = top;j<=bottom;j++){
                ans.add(matrix[j][right]);
            }
            right--;
            //right-left
            if(top<=bottom){
                for(int j = right;j>=left;j--){
                    ans.add(matrix[bottom][j]);
                }
                bottom--;
            }
            //left-up;
            if(left<=right){
                for(int j = bottom;j>=top;j--){
                    ans.add(matrix[j][left]);
                }
                left++;
            }
        }
        return ans;
        
    }
}