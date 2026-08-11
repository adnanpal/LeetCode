class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0;i<numRows;i++){

            List<Integer> current = new ArrayList<>();

            current.add(1);

            if(i>0){

                List<Integer> previous = ans.get(i-1);

                for(int j = 1;j<i;j++){
                    current.add(previous.get(j-1)+previous.get(j));
                }
                current.add(1);

            }
            ans.add(current);
        }
        return ans;
        
    }

}