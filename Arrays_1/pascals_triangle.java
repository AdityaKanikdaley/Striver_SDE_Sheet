package Arrays_1;

import java.util.ArrayList;
import java.util.List;

// Question: https://leetcode.com/problems/pascals-triangle/

public class pascals_triangle {
    public static void main(String[] args) {
        int numRows = 5; // Constraints: 1 <= numRows <= 30
        List<List<Integer>> triangle = generate(numRows);
        for (List<Integer> e : triangle)
            System.out.println(e);
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // add 1st 1
        List<Integer> first_row = new ArrayList<>();
        first_row.add(1);
        triangle.add(first_row);

        // calculate rest
        for (int i = 1; i < numRows; i++) {
            List<Integer> curList = new ArrayList<>();

            // add leftmost 1
            curList.add(1);

            // add middle 1s
            for (int j = 1; j < i; j++) {
                int curRes = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                curList.add(curRes);
            }

            // add rightmost 1
            curList.add(1);

            // add current list to triangle
            triangle.add(curList);
        }

        return triangle;
    }
}
