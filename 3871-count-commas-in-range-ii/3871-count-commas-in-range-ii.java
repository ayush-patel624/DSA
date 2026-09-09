class Solution {
    public long countCommas(long n) {
    long total = 0;
    int length = Long.toString(n).length();
    for (int digits = 4; digits <= length; digits++) {
        long start = (long) Math.pow(10, digits - 1);
        long end = Math.min(n, (long) Math.pow(10, digits) - 1);
        if (start > end) continue;
        long count = end - start + 1;
        total += count * ((digits - 1) / 3);
    }
    return total;
}
}