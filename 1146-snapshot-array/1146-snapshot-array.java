class SnapshotArray {
    List<Map<Integer, Integer>> listOfSnaps; //snap 1,snap 2....where each snap stores the current array state
    
    public SnapshotArray(int length) {
        listOfSnaps = new ArrayList<>();
        listOfSnaps.add(new HashMap<>());
    }
    
    public void set(int index, int val) {
        int snapId =listOfSnaps.size() - 1; // when 1 snap is done length =1 so Id =0
        listOfSnaps.get(snapId).put(index,val); // say at 0th snap we are storing at particular index a value.
        //so that we can refer back at so and so snap at particular index what was the value.
    }
    
    public int snap() {
        listOfSnaps.add(new HashMap<>());//Node with index and value
        return listOfSnaps.size()-2;
    }
    
    public int get(int index, int snap_id) {
        //value of provided snap id will be in map of snap ids
        //or somewhere possibly in previous snaps when it was changed
        for(int i=snap_id;i>=0;i--)
        {
            if(listOfSnaps.get(i).containsKey(index))
            {
                return listOfSnaps.get(i).get(index);
            }
        }
        //if not found
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */