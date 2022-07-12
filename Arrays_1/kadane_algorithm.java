package Arrays_1;

// Kadane's algorithm : find the largest sum in contiguous subArray

class kadane_algorithm {

    public static int maxSubArray(int[] nums) {
        int result = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            result = Math.max(result, sum);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_sum = maxSubArray(a);
        System.out.println("Maximum contiguous sum is " + max_sum);
    }
}
