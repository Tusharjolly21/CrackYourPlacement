class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> map;
    List<Integer> list;
    Random r;

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
        r = new Random();
    }

    public boolean insert(int val) {
        HashSet<Integer> set;
        boolean flag;
        if (map.containsKey(val)) {
            set = map.get(val);
            flag = false;
        } else {
            set = new HashSet<>();
            flag = true;
        }
        set.add(list.size());
        list.add(val);
        map.put(val,set);
        return flag;
    }

    public boolean remove(int val) {
        HashSet<Integer> set;
        if(map.containsKey(val)){
            set = map.get(val);
        }else{
            return false;
        }
        int removeIdx = -1;
        for(Integer i:set){
            removeIdx = i;
            break;
        }
        set.remove(removeIdx);
        map.put(val,set);
        if(map.get(val).size()==0){
            map.remove(val);
        }
        
        if(removeIdx==list.size()-1){
            list.remove(list.size()-1);
        }else{
        list.set(removeIdx,list.get(list.size()-1));
        list.remove(list.size()-1);
            int newVal = list.get(removeIdx);
            HashSet<Integer> temp = map.get(newVal);
            temp.remove(list.size());
            temp.add(removeIdx);
            map.put(newVal,temp);
        }
        return true;
        
    }

    public int getRandom() {
        int randomIdx = r.nextInt(list.size());
        return list.get(randomIdx);
    }
}
/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
