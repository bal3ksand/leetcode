/* https://leetcode.com/problems/koko-eating-bananas/ */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = 0;
        for (int pile : piles) {
            l += pile / h;
            r = Math.max(r, pile);
        }
        while (l < r) {
            int m = l + (r - l) / 2;
            if (hoursToEat(piles, m) <= h)
                r = m;
            else
                l = m + 1;
        }
        return r;
    }
    public long hoursToEat (int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles)
            hours += (long) Math.ceil((double) pile / speed);
        return hours;
    }
}