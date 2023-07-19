// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//         int count = 0;
//         int skipIndex = -1;
//         int size = intervals.length;
//         int set = 0;
//         for(int i=0;i<size-1;i++)
//         {
//             set = 0;
//             if(i==skipIndex)
//             {
//                 continue;
//             }
//             for(int j=i+1;j<size;j++)
//             {
//                 if(intervals[j][0]>=intervals[i][0] && intervals[j][0]<intervals[i][1])
//                 {
//                     count++;
//                     if(set!=1)
//                     {
//                         skipIndex=j;
//                         set = 1;
//                     }
//                 }
//             }
//         }
//         return count;
//     }
// }
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals based on the end time in ascending order
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 0; // Number of intervals to be removed
        int end = Integer.MIN_VALUE; // The end time of the last selected interval

        // Iterate through the sorted intervals
        for (int[] interval : intervals) {
            int start = interval[0];

            // If the current interval overlaps with the last selected interval, increment the count
            if (start < end) {
                count++;
            } else {
                // Update the end time to the end of the current interval
                end = interval[1];
            }
        }

        return count;
    }
}
