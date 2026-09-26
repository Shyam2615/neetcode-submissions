class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int total = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                int count = leftMax - height[left];
                if(count > 0){
                    total += count;
                }
                left++;
                if (height[left] > leftMax) {
                    leftMax = height[left];
                }
            } else {
                int count = rightMax - height[right];
                if(count > 0){
                    total += count;
                }
                right--;
                if (height[right] > rightMax) {
                    rightMax = height[right];
                }
            }
        }

        return total;
    }
}
