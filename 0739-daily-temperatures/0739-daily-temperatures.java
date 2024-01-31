// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int[] ans = new int[temperatures.length];
        
//         for(int i=0;i<temperatures.length-1;i++)
//         {
//             int counter = 0;
//             for(int j=i+1;j<temperatures.length;j++)
//             {
//                 counter++;
//                 if(temperatures[j]>temperatures[i])
//                 {
//                     ans[i] = counter;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }//TLE 47/48

class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return answer;
    }
}