class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int res = 0;

        while (left < right) {

            int width = right - left;
            int h = Math.min(height[left], height[right]);

            int area = width * h;
            res = Math.max(res, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}