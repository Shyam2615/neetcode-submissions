class Solution {
    public int findMin(int[] nums) {
        return nums[findPivot(nums) + 1];
    }

    public int findPivot(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2;
            if(mid < right && nums[mid] > nums[mid + 1]){
                return mid;
            }
            if(mid > left && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[left] > nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
