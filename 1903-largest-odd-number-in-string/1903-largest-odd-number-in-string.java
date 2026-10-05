class Solution {
    public String largestOddNumber(String num) {

        int numbers [] = new int [num.length()];
        String result = "";

        for(int i = 0;i<num.length();i++){
            numbers[i] = Character.getNumericValue(num.charAt(i));
        }

        for (int i = num.length()-1;i>=0;i--){

            if ( numbers[i] % 2 != 0){
                result = num.substring(0,i+1);
                break;
            }
        }
        return result;

        
    }
}