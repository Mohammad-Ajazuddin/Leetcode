class RandomizedSet {
    
    private List<Integer> list;
    //to store elements
    private HashMap<Integer,Integer> map;
    //to keep track of elements and corresponding index

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
        {
            return false;
            //already element exists
        }
        //else inset element
        list.add(val);//First ele,size 1 so ind 0
        map.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
        {
            return false;
            //no such ele to be removed
        }
        //finding index of ele to be removed
        int index = map.get(val);
        //as this value is to be removed
        //updating this with last element
        list.set(index,list.get(list.size()-1));
        //updating last ele's index in map
        map.put(list.get(list.size()-1),index);
        //removing the ele entry from map
        map.remove(val);
        //as last ele is added at index, removing it from last index
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        Random r = new Random();
        return list.get(r.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */