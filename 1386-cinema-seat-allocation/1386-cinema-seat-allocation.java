import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            if (!map.containsKey(seat[0])) {
             map.put(seat[0], new HashSet<>());
            }
            map.get(seat[0]).add(seat[1]);
        }

        int res = (n - map.size()) * 2;

        for (int row : map.keySet()) {
            HashSet<Integer> seats = map.get(row);

            boolean left = true;
            boolean middle = true;
            boolean right = true;

            for (int col = 2; col <= 5; col++) {
                if (seats.contains(col)) {
                    left = false;
                    break;
                }
            }

            for (int col = 4; col <= 7; col++) {
                if (seats.contains(col)) {
                    middle = false;
                    break;
                }
            }

            for (int col = 6; col <= 9; col++) {
                if (seats.contains(col)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                res += 2;
            } else if (left || middle || right) {
                res += 1;
            }
        }

        return res;
    }
}