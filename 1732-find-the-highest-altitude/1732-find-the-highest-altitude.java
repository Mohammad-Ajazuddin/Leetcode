class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int highestAltitude = 0;
        int currentAltitude = 0;
        for(int i=0;i<n;i++)
        {
            currentAltitude+=gain[i];
            if(currentAltitude>highestAltitude)
            {
                highestAltitude = currentAltitude;
            }
        }
        return highestAltitude;
    }
}