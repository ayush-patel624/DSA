class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int slow = nums[0];
        int fast = nums[0];

        while(fast!=0){
            slow = nums[slow];
            fast= nums[fast];
            fast= nums[fast];

            if(fast==slow){
                slow=nums[0];

                while(slow!=fast){
                    slow=nums[slow];
                    fast=nums[fast];
                }

                return slow;
            }
        }
        

        return -1;
    }
}