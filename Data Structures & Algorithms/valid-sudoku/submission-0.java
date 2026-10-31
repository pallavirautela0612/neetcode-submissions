class Solution {
    public boolean isValidSudoku(char[][] board) {

        Set<String> set = new HashSet<>();

        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                if(board[row][col] == '.') continue;

                String str1 = board[row][col] + " found in row " + row;
                String str2 = board[row][col] + " found in col " + col;
                String str3 = board[row][col] + " found in " + row/3 + "," + col/3;

                if (set.contains(str1) || set.contains(str2) || set.contains(str3)) {

                    return false;
                }

                set.add(str1);
                set.add(str2);
                set.add(str3);
            }
        }
        return true;
    }
}
