class RandomizedSet {
    HashMap<Integer,Integer> map;
    List<Integer> list;
    Random r;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
        
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;  /*duplicacy is not allowed*/
        }
        map.put(val,list.size()); /*storing value as list size*/
        list.add(val);
        return true; /*successfully added the element*/
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;    /*when key is not present element cannot be removed*/
        }
        int removeIdx = map.get(val);
        map.remove(val);
        
        if(removeIdx==list.size()-1){ /* if index given is last of list then*/
            list.remove(list.size()-1);
            return true;
        }
        list.set(removeIdx,list.get(list.size()-1)); /*swapped the removing number to last of the list*/
        list.remove(list.size()-1);
        map.put(list.get(removeIdx),removeIdx);
        return true;
    }
    
    public int getRandom() {
        int randomIdx = r.nextInt(list.size()); /*range from 0 to exclusive list size*/
        return list.get(randomIdx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */