class Solution {
    public int minAddToMakeValid(String s) {
        int res=0;
        int balance=0;

        for(char c:s.toCharArray()){
            if(c=='(') balance++;
            else balance--;

            if(balance<0){
                res+=1;
                balance=0;
            }
        }
        res+=balance;
        return res;
    }
}