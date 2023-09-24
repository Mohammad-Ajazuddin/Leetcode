//bruteforce
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, new Comparator<int[]>()
                    {
                        public int compare(int[] a,int[] b)
                        {
                            return a[0] - b[0];
                        }
                    });
        
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];
            
            //skipping already merged intervals
            //{1,5}  now at {2,8} which is already merged
            //here start = 2 end = 8.
            //in result list(merged interval) {....,{1,8}}
            //so intervals with end<=(end of last merged interval) will be within interval so skip it as it is already merged
            if(!result.isEmpty() && end<=result.get(result.size()-1).get(1))
            {
                continue;
            }
            
            for(int j=i+1;j<n;j++)
            {// start  end  [j][0] [j][1]
                //{1 , 5}     {2  ,  8}   => {1,8} merged 2<=5
                if(intervals[j][0]<=end)
                {  //new end = 8 1-8 merged interval
                    end = Math.max(end,intervals[j][1]);
                }
                //{1,5} {7,10} two separate so cant be merged
                else
                {
                    break;
                }
            }
            result.add(Arrays.asList(start,end));//1 - 8
        }
        //return result.toArray(); doesnt work as here we have 2d
        
        int resSize = result.size();
        int[][] mergedIntervals = new int[resSize][2];
        
        for(int i=0;i<resSize;i++)
        {
            mergedIntervals[i][0] = result.get(i).get(0);
            mergedIntervals[i][1] = result.get(i).get(1);
        }
        return mergedIntervals;
    }
}