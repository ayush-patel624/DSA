class Solution {
    public int minMoves(int[] nums) {
        int min = nums[0];
        for(int i : nums) min = Math.min(i,min);
        int res=0;

        for(int i : nums) res += i-min;

        return res;
    }
}