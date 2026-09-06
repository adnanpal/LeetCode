class Solution {
    public int maxDistance(int[] position, int m) {

        Arrays.sort(position);

        int low = 1;
        int high = position[position.length-1] - position[0];

        while(low<=high){

            int mid = low+(high-low)/2;

            if(canPlace(position,mid,m)){
                low = mid+1;

            }else{
                high = mid-1;
            }
        }

        return high;

    }
    public static boolean canPlace(int [] position,int distance, int m){

        int balls = 1;
        int lastPosition = position[0];

        for(int i = 1;i < position.length;i++){

            if(position[i] - lastPosition >= distance){

                balls++;
                lastPosition = position[i];
            }

            if (balls >= m){
                return true;
            }
        }
        return false;
    }
}