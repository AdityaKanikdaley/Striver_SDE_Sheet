package Arrays_1;

// Question: https://leetcode.com/problems/next-permutation/
// tc: O(n), sc: O(1)
// YT: https://www.youtube.com/watch?v=LuLCLgMElus&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=10

import java.util.Arrays;

public class next_permutation {
    public static void main(String[] args) {
        int[] num = {1, 2, 3};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int i = nums.length - 2;

        //step-1
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;

        //step-2
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }

        //step-3
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
