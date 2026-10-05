class Solution {
    public boolean isIsomorphic(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            if (map.containsKey(sArray[i])) {

                
                if (map.get(sArray[i]) != tArray[i]) {
                    return false;
                }

            } else {

              
                if (map.containsValue(tArray[i])) {
                    return false;
                }

                map.put(sArray[i], tArray[i]);
            }
        }

        return true;
    }
}