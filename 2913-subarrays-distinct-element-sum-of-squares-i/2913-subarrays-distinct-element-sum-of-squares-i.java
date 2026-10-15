class Solution {
    public int sumCounts(List<Integer> nums) {
        HashSet<Integer> set = new HashSet<>();
        int res=0;
        int n = nums.size();
        for(int i=0;i<n;i++){
            set.clear();
            for(int j=i;j<n;j++){
                set.add(nums.get(j));
                res+= (set.size())*(set.size());
            }
        }

        return res;
    }
}