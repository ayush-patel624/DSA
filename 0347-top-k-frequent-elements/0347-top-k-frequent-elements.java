class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(map.get(a),map.get(b))
        );

        for(int i : map.keySet()){
            if(pq.size()<k) pq.add(i);
            else{
                if(map.get(pq.peek())<map.get(i)){
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        int [] res = new int[k];
        int j=0;
        while(!pq.isEmpty()) res[j++]=pq.poll();
        return res;

    }
}