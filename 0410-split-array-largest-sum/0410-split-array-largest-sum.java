class Solution {
    public int splitArray(int[] nums, int k) {
        return findNumber(nums,k);
    }

    public static int findNumber(int nums[], int k){
        
        int maximum = 0;
        int sum = 0;

        for(int num: nums){
            maximum = Math.max(num,maximum);
            sum += num;
        }

        int low = maximum;
        int high = sum;

        while (low < high){

            int mid = low+(high-low)/2;
            
            int newSum = 0;
            int groups = 1;

            for(int i = 0;i<nums.length;i++){
                if(newSum + nums[i] <= mid){
                    newSum += nums[i];
                }else{
                    groups++;
                    newSum = nums[i];
                }
            }
            if (groups <= k){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}