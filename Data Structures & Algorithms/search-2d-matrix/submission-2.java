class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int targetRow = -1;
        int leftRow = 0, rightRow = matrix.length-1;
        while(leftRow <= rightRow){
            int mid = (leftRow + rightRow) / 2;
            if(matrix[mid][0] == target) return true;
            if(matrix[mid][0] < target){
                targetRow = mid;
                leftRow = mid + 1;
            }else{
                rightRow = mid - 1;
            }
        }
        System.out.println(targetRow);
        if(targetRow == -1) return false;

        int targetCol = -1;
        int leftCol = 0, rightCol = matrix[0].length-1;
        while(leftCol <= rightCol){
            int mid = (leftCol + rightCol) / 2;
            if(matrix[targetRow][mid] == target) return true;
            if(matrix[targetRow][mid] > target){
                rightCol = mid - 1;
            }else{
                leftCol = mid + 1;
            }
        }
        return false;
    }
}
