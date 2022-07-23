package Arrays_1;

// tc: O(N)
// sc: O(1)

public class stocks_buy_sell {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("Max profit: " + _maxProfit(prices));
    }

    private static int _maxProfit(int[] prices) {
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++) {
            minSoFar = Math.min(minSoFar, prices[i]);
            int profit = prices[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}
