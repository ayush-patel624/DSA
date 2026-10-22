
class Solution {
    public int maximumLength(String s) {
        int n = s.length();
        int ans = -1;

        for (int len = 1; len <= n; len++) {
            int[] count = new int[26];
            int left = 0;

            for (int right = 0; right < n; right++) {
                if (s.charAt(right) != s.charAt(left)) {
                    left = right;
                }

                if (right - left + 1 >= len) {
                    count[s.charAt(right) - 'a']++;

                    if (count[s.charAt(right) - 'a'] >= 3) {
                        ans = Math.max(ans, len);
                    }
                }
            }
        }

        return ans;
    }
}
