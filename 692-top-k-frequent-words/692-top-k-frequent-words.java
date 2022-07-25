class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        for(String s:words)
            map.put(s,map.getOrDefault(s,0)+1);
        
        //custom comparator for comparing the words
        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));
        
        //add to the heap
        for(String word:map.keySet()){
            pq.add(word);
            if(pq.size()>k) pq.poll();
        }
         //add to the list
        List<String> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
            
        }
        Collections.reverse(list);
        return list;
        
    }
}