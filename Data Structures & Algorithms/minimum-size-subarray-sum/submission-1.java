class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int res = Integer.MAX_VALUE;
        int l = 0;
        int indexes = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            indexes++;
            while (sum >= target) {
                res = Math.min(res, indexes);
                sum -= nums[l];
                l++;
                indexes--;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}