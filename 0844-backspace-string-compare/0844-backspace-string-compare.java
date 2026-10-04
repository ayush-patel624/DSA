class Solution {

    public boolean backspaceCompare(String s, String t) {

        int p = s.length() - 1;
        int q = t.length() - 1;

        while (p >= 0 || q >= 0) {

            p = nextValidIndex(s, p);

            q = nextValidIndex(t, q);

            if (p < 0 && q < 0) {
                return true;
            }

            if (p < 0 || q < 0) {
                return false;
            }

            if (s.charAt(p) != t.charAt(q)) {
                return false;
            }

            p--;
            q--;
        }

        return true;
    }

    private int nextValidIndex(String s, int i) {

        int skip = 0;

        while (i >= 0) {

            if (s.charAt(i) == '#') {
                skip++;
            }
            else if (skip > 0) {
                skip--;
            }
            else {
                break;
            }

            i--;
        }

        return i;
    }
}