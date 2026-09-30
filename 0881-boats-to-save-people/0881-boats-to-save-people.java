class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;

        int low =0;
        int high = n-1;

        int res=0;

        while(low<=high){
            if(people[high]+people[low]<=limit){
                high--;
                low++;
            }else{
                high--;
            }
            res++;
        }

        return res;
    }
}