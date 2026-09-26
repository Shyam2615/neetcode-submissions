class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 0;
        int end = piles[piles.length - 1];

        while (start <= end) {
            int mid = start + (end - start) / 2;
            long time = 0;
            for (int pile : piles) {
                time += (int) Math.ceil((double) pile / mid);
            }

            if (time <= h) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}