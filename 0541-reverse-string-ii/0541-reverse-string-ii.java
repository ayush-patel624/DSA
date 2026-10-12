
class Solution {
    public String reverseStr(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);

        for (int start = 0; start < n; start += 2 * k) {
            int low = start;
            int high = Math.min(start + k - 1, n - 1);

            while (low < high) {
                char temp = sb.charAt(low);
                sb.setCharAt(low, sb.charAt(high));
                sb.setCharAt(high, temp);

                low++;
                high--;
            }
        }

        return sb.toString();
    }
}
