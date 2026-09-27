class Solution {
    public int search(int[] nums, int target) {
        int peak = findPivot(nums);
        if(peak == -1){
            return orderAgnosticBS(0, nums.length - 1, nums, target);
        }

        if(nums[peak] == target){
            return peak;
        }

        if(nums[0] <= target ){
            return orderAgnosticBS(0, peak, nums, target);
        } else {
            return orderAgnosticBS(peak + 1, nums.length - 1, nums, target);
        }
    }

    public int orderAgnosticBS(int start, int end, int[] nums, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end-start) / 2;
            if(mid < end && nums[mid ] > nums[mid + 1]){
                return mid;
            }
            if(mid > start && nums[mid] < nums[mid - 1]){
                return mid - 1;
            }
            if(nums[mid] < nums[start]){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
