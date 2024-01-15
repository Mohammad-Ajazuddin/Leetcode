class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> loserFreq = new HashMap<>();
        
        int n = matches.length;
        
        for(int i=0;i<n;i++)
        {
            loserFreq.put(matches[i][1],loserFreq.getOrDefault(matches[i][1],0)+1);
        }
        
        HashSet<Integer> zeroLoss = new HashSet<>();
        List<Integer> oneLoss = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0;i<n;i++)
        {
            int winner = matches[i][0];
            int loser = matches[i][1];
            
            if(!loserFreq.containsKey(winner))
            {
                zeroLoss.add(winner);
            }
            if(loserFreq.get(loser)==1)
            {
                oneLoss.add(loser);
            }
        }
        List<Integer> zeroLossList = new ArrayList<>(zeroLoss);
        Collections.sort(zeroLossList);
        Collections.sort(oneLoss);
        
        result.add(zeroLossList);
        result.add(oneLoss);
        
        return result;
    }
}