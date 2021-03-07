package NB20;

public class Main {

    public static class NQueenProblem {

        static int k = 1;

        /* A utility function to print solution */
        static void printSolution(int[][] board, int N) {
            System.out.printf("%d\n", k++);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.printf(" %d ", board[i][j]);
                System.out.print("\n");
            }
            System.out.print("\n");
        }


        static boolean isSafe(int[][] board, int row, int col,int N) {

            /* Check this row on left side */
            for (int i = 0; i < col; i++)
                if (board[row][i] == 1)
                    return false;

            /* Check upper diagonal on left side */
            for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
                if (board[i][j] == 1)
                    return false;

            /* Check lower diagonal on left side */
            for (int i = row, j = col; j >= 0 && i < N; i++, j--)
                if (board[i][j] == 1)
                    return false;

            return true;
        }

        /* A recursive utility function
        to solve N Queen problem */
        static boolean solveNQUtil(int[][] board, int col, int N) {
    /* base case: If all queens are placed
    then return true */
            if (col == N) {
                printSolution(board ,N);
                return true;
            }


            boolean res = false;
            for (int i = 0; i < N; i++) {
        /* Check if queen can be placed on
        board[i][col] */
                if (isSafe(board, i, col ,N)) {
                    /* Place this queen in board[i][col] */
                    board[i][col] = 1;

                    // Make result true if any placement
                    // is possible
                    res = solveNQUtil(board, col + 1, N) || res;

            /* If placing queen in board[i][col]
            doesn't lead to a solution, then
            remove queen from board[i][col] */
                    board[i][col] = 0; // BACKTRACK
                }
            }

    /* If queen can not be place in any row in
        this column col then return false */
            return res;
        }

        /* This function solves the N Queen problem using
        Backtracking. It mainly uses solveNQUtil() to
        solve the problem. It returns false if queens
        cannot be placed, otherwise return true and
        prints placement of queens in the form of 1s.
        Please note that there may be more than one
        solutions, this function prints one of the
        feasible solutions.*/
        static void solveNQ(int N) {
            int[][] board = new int[N][N];

            if (!solveNQUtil(board, 0 , N)) {
                System.out.print("Solution does not exist");
            }
        }

        public static void main(String[] args) {
            int N = 8;
            solveNQ(N);
        }
    }
}
