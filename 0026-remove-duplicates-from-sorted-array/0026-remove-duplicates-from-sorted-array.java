class Solution {
    public int removeDuplicates(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) continue;
            
            map.put(nums[i],count);
            count++;
        }

        for(int i : map.keySet()){
            nums[map.get(i)]=i;
        }

        return map.size();
    }
}