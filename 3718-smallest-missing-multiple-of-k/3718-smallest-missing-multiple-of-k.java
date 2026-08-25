class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) set.add(i);

        int j=1;

        while(j<=101){
            if(!set.contains(k*j)) return k*j;
            j++;
        }
        return -1;
    }
}