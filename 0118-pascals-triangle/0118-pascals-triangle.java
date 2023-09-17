class Solution {
    public static List<Integer> generateRow(int rowNum)
    {
        int result = 1;
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<rowNum;i++)
        {
            if(i==0)
            {
                temp.add(1);
            }
            else
            {
                result = result * (rowNum-i);
                result = result/i;
                temp.add(result);
            }
        }
        return temp;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i=1;i<=numRows;i++)
        {
            result.add(generateRow(i));
        }
        return result;
    }
}

//Using arrays
// import java.util.*;
// public class Solution {
//     public static int[] generateRow(int rowNum)
//     {
//         int[] temp = new int[rowNum];
//         int result = 1;
//         for(int i=0;i<rowNum;i++)
//         {
//             if(i==0)
//             {
//                 temp[i] = 1;
//             }
//             else
//             {
//                 result = result * (rowNum - i);
//                 result = result/i;
//                 temp[i] = result;
//             }
//         }
//         return temp;
//     }
//     public static int[][] pascalTriangle(int N) {
//         // Write your code here.
//         int[][] result = new int[N][];

//         for(int i=0;i<N;i++)
//         {
//             result[i] = generateRow(i+1);
//         }
//         return result;
//     }
// }