class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = firstBound(nums,target,true);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = firstBound(nums,target,false);
        return new int[]{first,last};
        
    }
    private int firstBound(int nums[],int target, boolean isFirst){

        int n = nums.length;
        int high = n-1;
        int low = 0;
        int bound = -1;

        while(low<=high){

            int mid = low+(high-low)/2;

            if (nums[mid] == target){
                bound = mid;

                if(isFirst){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else if (target < nums[mid]){

                high = mid-1;

            }else{
                low = mid+1;
            }
        }
        return bound;
    }
}