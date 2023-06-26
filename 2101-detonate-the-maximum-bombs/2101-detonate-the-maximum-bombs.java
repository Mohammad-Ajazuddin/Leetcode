// class Solution {
//     public int maximumDetonation(int[][] bombs) {
//         int maxDetonated = 0;

//         for (int i = 0; i < bombs.length; i++) {
//             int detonated = 0;
//             int x1 = bombs[i][0];
//             int y1 = bombs[i][1];
//             int r1 = bombs[i][2];

//             for (int j = 0; j < bombs.length; j++) {
//                 int x2 = bombs[j][0];
//                 int y2 = bombs[j][1];
//                 int r2 = bombs[j][2];
//                 double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

//                 if (distance <= r1+r2) {
//                     detonated++;
//                 }
//             }

//             maxDetonated = Math.max(maxDetonated, detonated);
//         }
//         return maxDetonated;
//     }
// } have to look. Got wrong answer. 88/162

class Solution {
    public void dfs(List<List<Integer>> gr, boolean[] visited, int[] count, int i) {
        visited[i] = true;
        count[0]++;
        for (int j : gr.get(i)) {
            if (!visited[j]) {
                dfs(gr, visited, count, j);
            }
        }
    }
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<List<Integer>> gr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            gr.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    long x1 = bombs[i][0];
                    long y1 = bombs[i][1];
                    long r1 = bombs[i][2];
                    long x = bombs[j][0];
                    long y = bombs[j][1];
                    long distanceSq = (x - x1) * (x - x1) + (y - y1) * (y - y1);
                    if (distanceSq <= r1 * r1) {
                        gr.get(i).add(j);
                    }
                }
            }
        }
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int[] count = new int[1]; // To pass as referrence
            boolean[] visited = new boolean[n];
            dfs(gr, visited, count, i);
            ans = Math.max(ans, count[0]);
        }
        return ans;
    }
}