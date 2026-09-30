class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for(int i:nums1) set.add(i);

        for(int i : nums2){
            if(set.contains(i)) set2.add(i);
        }

        int n = set2.size();

        int [] sol = new int[n];
        int k=0;

        for(int i : set2) sol[k++]=i;

        return sol;
    }
}