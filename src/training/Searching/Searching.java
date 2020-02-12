package training.Searching;

import java.util.Arrays;

public class Searching {
    public static void main(String[] args) {
        int[] grid = {
                0, 0, 0, 0, 0, 2, 1, 0, 0,
                0, 0, 4, 0, 0, 8, 7, 0, 0,
                0, 2, 0, 3, 0, 0, 9, 0, 0,
                6, 0, 2, 0, 0, 3, 0, 4, 0,
                0, 0, 0, 0, 0, 0, 0, 0, 0,
                0, 5, 0, 6, 0, 0, 3, 0, 1,
                0, 0, 3, 0, 0, 5, 0, 8, 0,
                0, 0, 8, 2, 0, 0, 5, 0, 0,
                0, 0, 9, 7, 0, 0, 0, 0, 0};
        print(grid);

        int[] work = grid.clone();
        if (solve(work, 0))
            print(work);
    }

    public static void print(int[] grid) {
        for (int i = 0; i < 81; i += 9)
            System.out.println(Arrays.toString(Arrays.copyOfRange(grid, i, i + 9)));
        System.out.println();
    }

    public static boolean solve(int[] grid, int cell) {
        while (cell < 81 && grid[cell] > 0)
            cell++;
        if (cell == 81)
            return true;

        for (int i = 1; i <= 9; i++) {
            grid[cell] = i;
            if (isColumnValid(grid, cell % 9))
                if (isRowValid(grid, cell / 9))
                    if (isBlockValid(grid, cell % 3 * 3, cell / 9 % 3 * 3))
                        if (isValid(grid) && solve(grid, cell + 1))
                            return true;
        }
        grid[cell] = 0;
        return false;
    }

    private static final int[] freqs = new int[10];

    public static boolean isValid(int[] grid) {
        for (int i = 0; i < 9; i++) {
            if (!isRowValid(grid, i))
                return false;
            if (!isColumnValid(grid, i))
                return false;
            if (!isBlockValid(grid, i % 3 * 3, i / 3 * 3))
                return false;
        }
        return true;
    }

    public static boolean isRowValid(int[] grid, int row) {
        Arrays.fill(freqs, 0);

        for (int i = 0; i < 9; i++) {
            int cell = grid[row * 9 + i];
            if (cell > 0 && ++freqs[cell] > 1)
                return false;
        }
        return true;
    }

    public static boolean isColumnValid(int[] grid, int col) {
        Arrays.fill(freqs, 0);

        for (int i = 0; i < 9; i++) {
            int cell = grid[i * 9 + col];
            if (cell > 0 && ++freqs[cell] > 1)
                return false;
        }
        return true;
    }

    public static boolean isBlockValid(int[] grid, int x, int y) {
        Arrays.fill(freqs, 0);

        for (int i = 0; i < 9; i++) {
            int cell = grid[(y + i / 3) * 9 + (x + i % 3)];
            if (cell > 0 && ++freqs[cell] > 1)
                return false;
        }
        return true;
    }
}