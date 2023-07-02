// class Solution {
//     public int maximumRequests(int n, int[][] requests) {
//         int[] from = new int[n];
//         int[] to = new int[n];
//         int ans = 0;
//         for(int i=0;i<n;i++)
//         {
//             from[i] = 0;
//             to[i] = 0;
//         }
//         int reqs = requests.length;
//         for(int i=0;i<reqs;i++)
//         {
//             from[requests[i][0]]+=1;
//             to[requests[i][1]]+=1;
//         }
        
//        for(int i=0;i<n;i++)
//        {
//            if(from[i]>=to[i])
//            {
//                ans+=to[i];
//            }
//        }
//         return ans;
//     }
// }// 40/117 something is going on in my mind hahah...

class Solution {
    private int m;
    private int result = Integer.MIN_VALUE;

    private void solve(int idx, int count, int n, int[] resultant, List<List<Integer>> requests) {
        if (idx == m) {
            boolean allZero = true;
            for (int x : resultant) {
                if (x != 0) {
                    allZero = false;
                    break;
                }
            }

            if (allZero) {
                result = Math.max(result, count);
            }
            return;
        }

        int from = requests.get(idx).get(0);
        int to = requests.get(idx).get(1);

        resultant[from]--;
        resultant[to]++;
        solve(idx + 1, count + 1, n, resultant, requests);

        resultant[from]++;
        resultant[to]--;
        solve(idx + 1, count, n, resultant, requests);
    }

    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;

        int[] resultant = new int[n];
        Arrays.fill(resultant, 0);

        solve(0, 0, n, resultant, convertToList(requests));

        return result;
    }

    private List<List<Integer>> convertToList(int[][] requests) {
        List<List<Integer>> converted = new ArrayList<>();
        for (int[] request : requests) {
            converted.add(Arrays.asList(request[0], request[1]));
        }
        return converted;
    }
}
