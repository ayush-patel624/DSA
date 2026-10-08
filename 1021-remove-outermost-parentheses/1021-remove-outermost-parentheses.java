class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance=0;

        for(char c : s.toCharArray()){
            if(balance!=0 && !(balance==1 && c==')')) sb.append(c);

            if(c=='(') balance++;
            else balance--;
        }
        return sb.toString();
    }

    
}