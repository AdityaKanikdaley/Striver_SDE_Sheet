package Arrays_1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// Question Link: https://leetcode.com/problems/set-matrix-zeroes/
// YT: https://www.youtube.com/watch?v=M65xBewcqcI&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=8

// Brute force: my solution: TC: O(M x N), SC: O(M + N)O(M+N).
class MySolution_setMatZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroes(matrix);
        print(matrix);
    }

    private static void print(int[][] matrix) {
        for (int[] e : matrix) {
            System.out.println(Arrays.toString(e));
        }
    }

    private static void setZeroes(int[][] matrix) {

        List<Integer> i_s = new LinkedList<>();
        List<Integer> j_s = new LinkedList<>();

        // add i's and j's indices to list then call setZero for every element of list
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    i_s.add(i);
                    j_s.add(j);
                }
            }
        }

        // calling for every element of list
        for (int i = 0; i < i_s.size(); i++) {
            setZero(matrix, i_s.get(i), j_s.get(i));
        }
    }

    private static void setZero(int[][] matrix, int i, int j) {

        for (int col = 0; col < matrix[0].length; col++)
            matrix[i][col] = 0;

        for (int row = 0; row < matrix.length; row++)
            matrix[row][j] = 0;
    }
}


/*
import java.util.ArrayList;
import java.util.List;

// O(1) Space, Efficient Solution
public class set_matrix_zeros {
    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        int[] a = {1,2,3};

        list.add(a);
        list.add(a);
        list.add(a);
        System.out.println(list);

    }
}

 */