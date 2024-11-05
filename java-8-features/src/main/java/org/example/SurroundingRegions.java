package org.example;

public class SurroundingRegions {
    public int[][] id;
    public int m, n;

    public SurroundingRegions(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        this.m = m;
        this.n = n;
        this.id = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (i == 0 | j == 0) {
                        id[i][j] = -1;
                        continue;
                    }
                    if (i == m - 1 | j == n - 1) {
                        id[i][j] = -1;
                        continue;
                    }
                    id[i][j] = (i * n) + j;
                }
                id[i][j] = (i * n) + j;
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(id[i][j] + " ");
//            }
//            System.out.println();
//        }

    }

    public int root(int i, int j) {
        if (id[i][j] == -1 | id[i][j] == i * n + j) return id[i][j];

        id[i][j] = root(id[i][j] / n, id[i][j] % n);
        return id[i][j];

    }

    public void union(int p_i, int p_j, int q_i, int q_j) {
        int root_p = root(p_i, p_j);
        int root_q = root(q_i, q_j);
        if (root_p > root_q) id[p_i][p_j] = root_q;
        else id[q_i][q_j] = root_q;
    }

    public char[][] result() {
        char[][] result_board = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (id[i][j] == -1) result_board[i][j] = 'O';
                else result_board[i][j] = 'X';
            }
        }
        return result_board;
    }

    public boolean check(int i, int j) {
        if ((i > -1) & (i < m) & (j > -1) & (j < n)) return true;
        else return false;
    }

    public void solve(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    if (check(i, j + 1)) {
                        if (board[i][j + 1] == 'O') union(i, j, i, j + 1);
                    }
                    if (check(i, j - 1)) {
                        if (board[i][j - 1] == 'O') union(i, j, i, j - 1);
                    }
                    if (check(i + 1, j)) {
                        if (board[i + 1][j] == 'O') union(i, j, i + 1, j);
                    }
                    if (check(i - 1, j)) {
                        if (board[i - 1][j] == 'O') union(i, j, i - 1, j);
                    }
                }
            }
        }
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(id[i][j] + " ");
//            }
//            System.out.println();
//        }
        char[][] result_board = result();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result_board[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        SurroundingRegions obj = new SurroundingRegions(board);
        obj.solve(board);
        System.out.println("--------------");
        char[][] board1 = {{'X'}};
        SurroundingRegions obj1 = new SurroundingRegions(board1);
        obj1.solve(board1);
        System.out.println("--------------");
        char [][] board2 = {{'X','X','X','X','X'},
                            {'X','O','O','O','X'},
                            {'X','O','X','O','X'},
                            {'X','O','O','O','X'},
                            {'X','X','X','X','O'}};
        SurroundingRegions obj2 = new SurroundingRegions(board2);
        obj2.solve(board2);
        System.out.println("--------------");
        char [][] board3 = {{'O','X','X','O','X'},
                            {'X','O','O','X','O'},
                            {'X','O','X','O','X'},
                            {'O','X','O','O','O'},
                            {'X','X','O','X','O'}};
        SurroundingRegions obj3 = new SurroundingRegions(board3);
        obj3.solve(board3);
    }
}
