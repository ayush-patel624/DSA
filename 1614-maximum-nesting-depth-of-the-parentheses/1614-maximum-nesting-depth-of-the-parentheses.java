class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int res=0;

        for(char c : s.toCharArray()){
            if(c=='(') st.push(c);
            if(c==')') st.pop();
            res=Math.max(res,st.size());
        }

        return res;
    }
}