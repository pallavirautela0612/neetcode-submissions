class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int left = 0; int right = rowLen * colLen -1;

        while (left <= right) {

            int mid = left + (right - left)/2;

            int row = mid/colLen ; int col = mid%colLen;

            if (target < matrix[row][col]) {

                right = mid-1;
            } else if (target > matrix[row][col]) {

                left = mid+1;
            } else {

                return true;
            }
        }
        
        return false;
    }
}
