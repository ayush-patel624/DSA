
import java.util.*;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int low = 0, high = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (high < s.length()) {
            char c = s.charAt(high);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c)
                    && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            high++;

            while (formed == required) {
                if (high - low < minLen) {
                    minLen = high - low;
                    start = low;
                }

                char leftChar = s.charAt(low);

                if (need.containsKey(leftChar)
                        && window.get(leftChar).intValue()
                           == need.get(leftChar).intValue()) {
                    formed--;
                }

                window.put(leftChar, window.get(leftChar) - 1);
                low++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
