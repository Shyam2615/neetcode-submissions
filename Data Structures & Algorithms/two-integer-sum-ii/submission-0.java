class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i = 0; i< nums.length;i++){
            if(hash.containsKey(target - nums[i])){
                return new int[]{hash.get(target - nums[i]), i + 1};
            }
            else {
                hash.put(nums[i], i + 1);
            }
        }
        return new int[nums.length];
    }
}
