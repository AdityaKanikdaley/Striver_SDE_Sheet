package Dynamic_Programming;

import java.util.Arrays;

/*
Time Complexity: O(N*W)
                 Reason: There are N*W states therefore at max ‘N*W’ new problems will be solved.
Space Complexity: O(N*W) + O(N)
                 Reason: We are using a recursion stack space(O(N)) and a 2D array ( O(N*W)).
 */
class Recursive {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5;

        int n = wt.length;
        System.out.println("The Maximum value of items, thief can steal is " +
                knapsack(wt, val, n, W));
    }

    static int knapsack(int[] wt, int[] val, int n, int W) {

        int[][] dp = new int[n][W + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return knapsackUtil(wt, val, n - 1, W, dp);
    }

    static int knapsackUtil(int[] wt, int[] val, int ind, int W, int[][] dp) {

        if (ind == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[ind][W] != -1) //not visited
            return dp[ind][W];

        int notTaken = 0 + knapsackUtil(wt, val, ind - 1, W, dp);

        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W)
            taken = val[ind] + knapsackUtil(wt, val, ind - 1, W - wt[ind], dp);

        return dp[ind][W] = Math.max(notTaken, taken);
    }
}

// ***********************************************************************************************

/*
Time Complexity: O(N*W)
                 Reason: There are two nested loops
Space Complexity: O(N*W)
                  Reason: We are using an external array of size ‘N*W’. Stack Space is eliminated.
 */
class Iterative {
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int W = 5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "
                + knapsack(wt, val, n, W));
    }

    static int knapsack(int[] wt, int[] val, int n, int W) {

        int[][] dp = new int[n][W + 1];

        //Base Condition
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = val[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {

                int notTaken = 0 + dp[ind - 1][cap];

                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap)
                    taken = val[ind] + dp[ind - 1][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W];
    }
}