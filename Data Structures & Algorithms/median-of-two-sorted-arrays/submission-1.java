class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < nums2.length ){
            if(nums1[i] > nums2[j]){
                merge[k] = nums2[j];
                j++;
            } else {
                merge[k] = nums1[i];
                i++;
            }
            k++;
        }

        while(i < nums1.length){
            merge[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length){
            merge[k] = nums2[j];
            j++;
            k++;
        }

        return findMedian(merge);
        
    }

    public double findMedian(int[] nums){
        if(nums.length % 2 == 0){
            int start = 0;
            int end = nums.length - 1;

            int mid = start + (end - start) / 2;
            System.out.println("mid" + nums[mid] + "mid + 1" + nums[mid + 1]);
            return (nums[mid] + nums[mid + 1]) / 2.0;
        } else {
            return nums[nums.length / 2];
        }
    }
}
