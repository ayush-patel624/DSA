class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        helper(0,n,0,"");
        return res;
    }

    void helper(int c , int n , int balance,String s){
        if(c==2*n){
            if(balance==0) res.add(s);
            return;
        }

        if(balance<0) return;

        StringBuilder sb = new StringBuilder(s);
        sb.append('(');
        helper(c+1,n,balance+1,sb.toString());
        StringBuilder sb2 = new StringBuilder(s);
        sb2.append(')');
        helper(c+1,n,balance-1,sb2.toString());
    }
}