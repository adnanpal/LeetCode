class Solution {
    public int beautySum(String s) {

        int totalBeauty = 0;

        for(int start = 0;start<s.length();start++){
            
            int freq [] = new int[26];

            for(int end = start;end<s.length();end++){

                freq[s.charAt(end)-'a']++;

                int maxFreq = 0;
                int minFreq = Integer.MAX_VALUE;

                for(int i = 0;i < 26; i++){

                    if (freq[i] > 0 ){
                        minFreq = Math.min(minFreq,freq[i]);
                        maxFreq = Math.max(maxFreq,freq[i]);
                    }
                }
                int beauty = maxFreq-minFreq;
                totalBeauty+=beauty;
            }
        }
        return totalBeauty;
        
    }
}