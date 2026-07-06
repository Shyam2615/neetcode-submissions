class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int ROW = matrix.length;
        int COL = matrix[0].length;

        int top=0, bot = ROW - 1;

        while(top <= bot){
            int row = (top + bot)/2;
            if(target > matrix[row][COL-1]){
                top = row + 1;
            } else if(target < matrix[row][0]){
                bot = row - 1;
            } else {
                break;
            }
        }

        if(!(top <= bot)){
            return false;
        }

        int row = (top + bot) / 2;

        int start = 0, end = COL - 1;
        while(start <= end){
            int mid = (start + end) / 2;
            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}