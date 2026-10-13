class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res=0;
        int low=0;
        int high=0;
        HashSet<Character> set = new HashSet<>();
        int n =s.length();
        while(high<n){
            while(high<n && !set.contains(s.charAt(high))) {
                set.add(s.charAt(high));
                high++;     
            }
            res= Math.max(res,high-low);
            set.remove(s.charAt(low));
            low++;
        }
        return res;
    }
}