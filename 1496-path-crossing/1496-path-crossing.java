// class Solution {
//     public boolean isPathCrossing(String path) {
//         int[][] coordinates = new int[path.length()+1][path.length()+1];
//         int prevX = 0;
//         int prevY = 0;
//         int currX = 0;
//         int currY = 0;
//         for(int i=0;i<path.length();i++)
//         {
//             coordinates[i][0] = prevX;
//             coordinates[i][1] = prevY;
//             if(path.charAt(i)=='N')
//             {
//                 currY++;
//                 prevY = currY;
//                 int j = 0;
//                 while(j<i)
//                 {
//                     if(coordinates[j][1]==currY)
//                     {
//                         if(coordinates[j][0]==currX)
//                         {
//                             return true;
//                         }
//                     }
//                     j++;
//                 }
//             }
//             else if(path.charAt(i)=='E')
//             {
//                 currX++;
//                 prevX=currX;
//                 int j = 0;
//                 while(j<i)
//                 {
//                     if(coordinates[j][1]==currY)
//                     {
//                         if(coordinates[j][0]==currX)
//                         {
//                             return true;
//                         }
//                     }
//                     j++;
//                 }
//             }
//             else if(path.charAt(i)=='S')
//             {
//                 currY--;
//                 prevY = currY;
//                 int j = 0;
//                 while(j<i)
//                 {
//                     if(coordinates[j][1]==currY)
//                     {
//                         if(coordinates[j][0]==currX)
//                         {
//                             return true;
//                         }
//                     }
//                     j++;
//                 }
//             }
//             else if(path.charAt(i)=='W')
//             {
//                 currX--;
//                 prevX = currX;
//                 int j = 0;
//                 while(j<i)
//                 {
//                     if(coordinates[j][1]==currY)
//                     {
//                         if(coordinates[j][0]==currX)
//                         {
//                             return true;
//                         }
//                     }
//                     j++;
//                 }
//             }
//         }
//         return false;
//     }
// } GOT MLE

class Solution {
    public boolean isPathCrossing(String path) {
        List<int[]> coordinates = new ArrayList<>();
        int prevX = 0;
        int prevY = 0;
        int currX = 0;
        int currY = 0;

        for (int i = 0; i < path.length(); i++) {
            coordinates.add(new int[]{prevX, prevY});

            if (path.charAt(i) == 'N') {
                currY++;
                prevY = currY;
                int j = 0;
                while (j < i) {
                    if (coordinates.get(j)[1] == currY && coordinates.get(j)[0] == currX) {
                        return true;
                    }
                    j++;
                }
            } else if (path.charAt(i) == 'E') {
                currX++;
                prevX = currX;
                int j = 0;
                while (j < i) {
                    if (coordinates.get(j)[1] == currY && coordinates.get(j)[0] == currX) {
                        return true;
                    }
                    j++;
                }
            } else if (path.charAt(i) == 'S') {
                currY--;
                prevY = currY;
                int j = 0;
                while (j < i) {
                    if (coordinates.get(j)[1] == currY && coordinates.get(j)[0] == currX) {
                        return true;
                    }
                    j++;
                }
            } else if (path.charAt(i) == 'W') {
                currX--;
                prevX = currX;
                int j = 0;
                while (j < i) {
                    if (coordinates.get(j)[1] == currY && coordinates.get(j)[0] == currX) {
                        return true;
                    }
                    j++;
                }
            }
        }
        return false;
    }
}
