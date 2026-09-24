class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []> pq = new PriorityQueue<>(
            (a,b)-> {
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            }
        );

        for(int i=0;i<nums.length;i++) pq.add(new int[]{nums[i],i});

        for(int i=0;i<k;i++){
            if(pq.isEmpty()) break;
            int [] curr = pq.remove();
            nums[curr[1]] = nums[curr[1]]*multiplier;
            pq.add(new int[]{nums[curr[1]],curr[1]});
        }

        return nums;
    }
}