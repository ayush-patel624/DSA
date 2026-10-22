class Solution {
    public long continuousSubarrays(int[] nums) {
        long res=0;
        int n = nums.length;
        if(n==1) return 1;
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        int high=0;
        int low=0;

        while(high<n){
            min.add(nums[high]);
            max.add(nums[high]);

            while(!max.isEmpty() && max.peek()-min.peek() > 2){
                min.remove(nums[low]);
                max.remove(nums[low]);
                low++;
            }

            res+= high-low+1;
            high++;
        }
        return res;
    }
}