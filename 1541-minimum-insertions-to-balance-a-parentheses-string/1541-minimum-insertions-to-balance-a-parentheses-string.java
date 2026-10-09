class Solution {
    public int minInsertions(String s) {
        int res = 0;
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance % 2 != 0) {
                    res++;
                    balance--;
                }
                balance += 2;
            } else {
                balance--;

                if (balance < 0) {
                    res++;
                    balance = 1;
                }
            }
        }

        return res + balance;
    }
}