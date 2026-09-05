class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int minDay = 0;
        int sum = 0;

        for(int weight: weights){
            minDay = Math.max(weight, minDay);
            sum += weight;
        }
        int maxDay = sum;

        while( minDay < maxDay){

            int mid = minDay+(maxDay-minDay)/2;

            int requiredDays = 1;
            int currentWeight = 0;

            for (int weight: weights){
                if (currentWeight + weight <= mid){
                    currentWeight+=weight;

                }else{
                    requiredDays++;
                    currentWeight = weight;
                }
            }
            
            if(requiredDays<=days){
                maxDay = mid;

            }else if (requiredDays > days){
                minDay = mid+1;
            }
        }
        return minDay;
    }
}