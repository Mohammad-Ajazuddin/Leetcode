class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int collectingTime = 0;
        int travelTime = 0;
        int n = garbage.length;
        int mtruck = 0, ptruck = 0, gtruck = 0;
        //to store max travel needed for each truck.
        //i,e ith house index if it contains the specific type of garbage
        for(int i=0;i<n;i++)
        {
            //anyhow the garbage will be collected by some trcuk.
            //so collecting time. 1 min each
            collectingTime += garbage[i].length();
            if(garbage[i].contains("M"))
            {
                mtruck = i;
            }
            if(garbage[i].contains("P"))
            {
                ptruck = i;
            }
            if(garbage[i].contains("G"))
            {
                gtruck = i;
            }
        }
        //travel time for each truck
        for(int i = 1;i<n;i++)
        {
            if(i<=mtruck)
            {
                travelTime += travel[i-1];
            }
            if(i<=ptruck)
            {
                travelTime += travel[i-1];
            }
            if(i<=gtruck)
            {
                travelTime += travel[i-1];
            }
        }
        return travelTime + collectingTime;
    }
}