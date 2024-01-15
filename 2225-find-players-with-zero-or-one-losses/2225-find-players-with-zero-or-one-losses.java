// class Solution {
//     public List<List<Integer>> findWinners(int[][] matches) {
//         HashMap<Integer,Integer> loserFreq = new HashMap<>();
        
//         int n = matches.length;
        
//         for(int i=0;i<n;i++)
//         {
//             loserFreq.put(matches[i][1],loserFreq.getOrDefault(matches[i][1],0)+1);
//         }
        
//         HashSet<Integer> zeroLoss = new HashSet<>();
//         List<Integer> oneLoss = new ArrayList<>();
//         List<List<Integer>> result = new ArrayList<>();
        
//         for(int i=0;i<n;i++)
//         {
//             int winner = matches[i][0];
//             int loser = matches[i][1];
            
//             if(!loserFreq.containsKey(winner))
//             {
//                 zeroLoss.add(winner);
//             }
//             if(loserFreq.get(loser)==1)
//             {
//                 oneLoss.add(loser);
//             }
//         }
//         List<Integer> zeroLossList = new ArrayList<>(zeroLoss);
        
//         Collections.sort(zeroLossList);
//         Collections.sort(oneLoss);
        
//         result.add(zeroLossList);
//         result.add(oneLoss);
        
//         return result;
//     }
// } 87 ms 107mb

//one more approach
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] losses = new int[100001];

        for (int i = 0; i < matches.length; i++) {
            int win = matches[i][0];
            int loss = matches[i][1];

            if (losses[win] == 0) {
                losses[win] = -1;
            } 

            if (losses[loss] == -1) {
                losses[loss] = 1;
            } else {
                losses[loss]++;
            }
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < losses.length; i++) {
            if (losses[i] == -1) {
                zeroLoss.add(i);
            } else if (losses[i] == 1) {
                oneLoss.add(i);
            }
        }

        result.add(zeroLoss);
        result.add(oneLoss);

        return result;
    }
}//21 ms