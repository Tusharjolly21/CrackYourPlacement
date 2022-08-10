class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        for(int x:map.keySet()){
            pq.offer(x);
            if(pq.size()>k) pq.poll();
        }
        int[] ans = new int[pq.size()];
        int i = 0;
        while(!pq.isEmpty()){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}