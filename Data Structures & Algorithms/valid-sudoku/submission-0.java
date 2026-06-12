class Solution {
    static final int N = 9;

    public boolean isValidSudoku(char[][] board) {
        // 행 확인하기
        if(isThereInValidRow(board)) return false;

        // 열 확인하기
        if(isThereInValidCol(board)) return false;

        // 3x3 박스 확인하기
        if(isThereInValidBox(board)) return false;

        return true;
    }

    boolean isThereInValidBox(char[][] board){
        for(int row = 0; row < N; row += 3){
            for(int col = 0; col < N; col += 3){
                if(isInvalidBox(row, col, board)) return true;
            }
        }
        return false;
    }

    boolean isInvalidBox(int startRow, int startCol, char[][] board){
        int cur = 0;
        for(int row = startRow; row < startRow + 3; row++){
            for(int col = startCol; col < startCol + 3; col++){
                if(board[row][col] == '.') continue;

                int num = getNum(board[row][col]);
                if((cur & (1 << num)) == (1 << num)) return true;
                cur |= (1 << num);
            }
        }
        return false;
    }

    boolean isThereInValidCol(char[][] board){
        for(int col = 0; col < N; col++){
            int cur = 0;
            for(int row = 0; row < N; row++){
                if(board[row][col] == '.') continue;

                int num = getNum(board[row][col]);
                if((cur & (1 << num)) == (1 << num)) return true;
                cur |= (1 << num);
            }
        }
        return false;
    }

    boolean isThereInValidRow(char[][] board){
        for(int row = 0; row < N; row++){
            int cur = 0;
            for(int col = 0; col < N; col++){
                if(board[row][col] == '.') continue;

                int num = getNum(board[row][col]);
                if((cur & (1 << num)) == (1 << num)) return true;
                cur |= (1 << num);
            }
        }
        return false;
    }

    int getNum(char c){
        return c - '0';
    }
}
