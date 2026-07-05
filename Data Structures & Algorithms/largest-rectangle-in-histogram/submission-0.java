class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int area = 0;

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] popped = stack.pop();
                start = popped[0];
                area = Math.max(area, ((i - popped[0]) * popped[1]));
            }
            stack.push(new int[]{start, heights[i]});
        }

        while(!stack.isEmpty()){
            int[] popped = stack.pop();
            area = Math.max(area, ((heights.length - popped[0]) * popped[1]));
        }
        return area;
    }
}
