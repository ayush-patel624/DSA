
import java.util.*;

class Solution {
    boolean check(HashMap<Character, Integer> map,
                  HashMap<Character, Integer> checkMap) {

        for (char c : map.keySet()) {
            if (map.get(c) > checkMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public String minWindow(String s, String t) {
        int low = 0, high = 0;
        int res = Integer.MAX_VALUE;
        String f = "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> checkMap = new HashMap<>();

        while (high < s.length()) {
            checkMap.put(s.charAt(high),
                checkMap.getOrDefault(s.charAt(high), 0) + 1);
            high++;

            while (check(map, checkMap)) {
                if (high - low < res) {
                    res = high - low;
                    f = s.substring(low, high);
                }

                char c = s.charAt(low);
                checkMap.put(c, checkMap.get(c) - 1);
                if (checkMap.get(c) == 0) {
                    checkMap.remove(c);
                }
                low++;
            }
        }

        return f;
    }
}
