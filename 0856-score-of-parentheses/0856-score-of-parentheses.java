class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(0);
            } else {
                int x = st.pop();

                if (x == 0) {
                    x = 1;              
                } else {
                    x = 2 * x;          
                }

                st.push(st.pop() + x);
            }
        }

        return st.pop();

    }
}