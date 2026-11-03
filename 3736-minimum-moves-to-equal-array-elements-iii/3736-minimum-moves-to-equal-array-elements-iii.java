class Solution {
    public int minMoves(int[] nums) {
        int highest=Integer.MIN_VALUE;
        for(int i : nums) highest=Math.max(i,highest);

        int res=0;
        for(int i : nums) res+= highest-i;

        return res;
    }
}