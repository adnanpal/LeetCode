class Solution {
    public int findMin(int[] nums) {
        
        int n = nums.length;
        int high = n-1;
        int low = 0;

        while(low<=high){

            int mid = low+(high-low)/2;

            if(low == high){
                return nums[low];
            }
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return -1;
    }
}