class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        if(k==0) return false;

        int low=0;
        int high=0;

        set.add(nums[high]);
        high++;

        while(high<nums.length && high<k){
            if(set.contains(nums[high])) return true;
            set.add(nums[high]);
            high++;
        }

        while(high < nums.length){
            if(set.contains(nums[high])) return true;
            set.add(nums[high]);
            set.remove(nums[low]);
            high++;
            low++;
        }

        return false;
    }
}