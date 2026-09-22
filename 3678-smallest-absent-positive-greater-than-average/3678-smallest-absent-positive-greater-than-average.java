class Solution {
    public int smallestAbsent(int[] nums) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {
            sum+=i;
            set.add(i);
        }

        int avg = sum/nums.length;

        int idx = Math.max(1,avg+1);

        for(int i=idx;i<=100;i++){
            if(!set.contains(i)) return i;
        }

        return 101;
        
    }
}