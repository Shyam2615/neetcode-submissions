class Solution {
    public int maxArea(int[] heights) {
        //Brute force
        int area = 0;

        for(int i=0;i<heights.length - 1;i++){
            for (int j=i+1;j<heights.length;j++){
                int currarea = (j-i) * Math.min(heights[j], heights[i]);
                area = Math.max(currarea, area);
            }
        }

        return area;
    }
}