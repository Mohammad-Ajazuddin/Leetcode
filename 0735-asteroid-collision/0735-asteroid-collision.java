// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         int count = 0;
//         int size = asteroids.length;
//         int i=0;
//         int j=i+1;
//         while(i<size-1 && j<size)
//         {
            
//             if(asteroids[i]>0 && asteroids[j]<0)
//             {
//                 if(-(asteroids[j])<asteroids[i])
//                 {
//                     asteroids[j] = 0;
//                     count++;
//                     if(i!=0)
//                     {
//                         i-=2;
//                         j--;
//                     }
//                     else{
//                         i--;
//                     }
//                 }
//                 else if(-(asteroids[j])>asteroids[i])
//                 {
//                     asteroids[i] = 0;
//                     count++;
//                     if(i!=0)
//                     {
//                         i-=2;
//                         j--;   
//                     }
//                 }
//                 else{
//                     asteroids[i] = 0;
//                     asteroids[j] = 0;
//                     count+=2;
//                     if(i!=0)
//                     {
//                         i-=2;
//                     }
//                     else{
//                         i--;
//                         j--;   
//                     }
//                 }
//             }
//             i++;
//             j++;
//         }
//         int[] emptyArray = new int[0];
//         if(size-count==0)
//         {
//             return emptyArray;
//         }
//         int[] result = new int[size-count];
//         j=0;
//         for(i=0;i<size;i++)
//         {
//             if(asteroids[i]==0)
//             {
//                 continue;
//             }
//             result[j++] = asteroids[i];
//         }
//         return result;
//     }
// }   256/275 testcases

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int size = asteroids.length;
        int j = 0;

        for (int i = 0; i < size; i++) {
            int asteroid = asteroids[i];
            while (j>0 && asteroids[j-1]>0 && asteroid<0 && asteroids[j-1] < Math.abs(asteroid)) 
            {j--;}

            if (j==0 || asteroid>0 || asteroids[j-1]<0) 
                asteroids[j++] = asteroid;
            else if(asteroids[j-1] == Math.abs(asteroid)) 
                j--;
        }
        
        int[] result = new int[j];
        System.arraycopy(asteroids, 0, result, 0, j);

        return result;
    }
}