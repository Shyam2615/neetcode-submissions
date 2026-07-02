class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temp.length];

        for(int i=0;i<temp.length;i++){
            int curr = temp[i];
            while(!stack.isEmpty() && curr > stack.peek()[0]){
                int[] top = stack.pop();
                res[top[1]] = i - top[1];
            }
            stack.push(new int[]{curr, i});
        }
        return res;
    }
}
