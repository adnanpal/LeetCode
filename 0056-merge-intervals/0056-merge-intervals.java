class Solution {
    public int[][] merge(int[][] intervals) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int n = intervals.length;
        ans.add(Arrays.asList(intervals[0][0],intervals[0][1]));

        for(int i = 1;i<n;i++){

            List<Integer> last = ans.get(ans.size()-1);

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            int previousEnd = last.get(1);

            if(currentStart<=previousEnd){
                last.set(1,Math.max(previousEnd,currentEnd));
            }else{
                ans.add(Arrays.asList(currentStart,currentEnd));
            }
            
        }
        
        int result [][] = new int [ans.size()][2];
        for(int i = 0;i<ans.size();i++){
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }
        return result;

    }
}