// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int MOD = (int)1e9+7;
//         long sum = 0L;
//         int n = arr.length;
//         for(int i=0;i<n;i++)
//         {
//             PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//             sum += arr[i];
//             minHeap.add(arr[i]);
//             for(int j=i+1;j<n;j++)
//             {
//                 minHeap.add(arr[j]);
//                 sum += minHeap.peek();
//             }
//         }
        
//         return (int) (sum%MOD);
//     }
// }//TLE 77/87 Testcases


// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int MOD = (int)1e9+7;
//         long sum = 0L;
//         int n = arr.length;
//         for(int i=0;i<n;i++)
//         {
//             sum += arr[i];
//             int currMin = arr[i];
//             for(int j=i+1;j<n;j++)
//             {
//                 if(currMin>arr[j])
//                 {
//                     currMin = arr[j];
//                 }
//                 sum+=currMin;
//             }
//         }
//         return (int) (sum%MOD);
//     }
// } TLE 86/87


//Monotonic stack
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7;
        long sum = 0L;
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];

        // Finding the nearest smaller element to the left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Finding the nearest smaller element to the right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum = (sum + (long) arr[i] * (i - left[i]) * (right[i] - i)) % MOD;
        }

        return (int) sum;
    }
}
