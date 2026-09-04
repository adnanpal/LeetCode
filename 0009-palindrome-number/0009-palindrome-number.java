class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }else{
            return reverse(x);
        }
    }
    public static boolean reverse(int x){
        int orignal = x;
        int reversed = 0;

        while(x!=0){
            int digit = x%10;
            reversed = reversed*10+digit;
            x/=10;
        }
        if( reversed == orignal){
            return true;
        }else{
            return false;
        }
    }
}