class Solution {
    public int trap(int[] height) {
        int n = height.length - 1;
        int rightMax = height[n];
        int leftMax = height[0];

        int right = n;
        int left = 0;
        int count = 0;

        while (left < right) {
            if (leftMax <= rightMax) {
                int water = leftMax - height[left];
                if (water > 0) {
                    count += water;
                }
                left++;
                leftMax = Math.max(leftMax, height[left]);
            } else {
                int water = rightMax - height[right];
                if (water > 0) {
                    count += water;
                }
                right--;
                rightMax = Math.max(rightMax, height[right]);
            }
        }

        return count;
    }
}