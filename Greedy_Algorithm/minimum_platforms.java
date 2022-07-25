package Greedy_Algorithm;

import java.util.Arrays;

// refer: https://takeuforward.org/data-structure/minimum-number-of-platforms-required-for-a-railway/
/*
Time Complexity: O(NlogN)   (Sorting takes O(NlogN) and traversal of arrays takes O(n) so overall time complexity is O(NlogN)).
Space complexity: O(1)   (No extra space used).
 */

public class minimum_platforms {
    public static void main(String[] args) {
        int[] arr = {900, 945, 955, 1100, 1500, 1800};
        int[] dep = {920, 1200, 1130, 1150, 1900, 2000};
        int n = arr.length;
        int totalCount = findPlatform(arr, dep, n);
        System.out.println("Minimum number of Platforms required: " + totalCount);
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {

            if (arr[i] <= dep[j]) {
                plat_needed++;
                i++;
            } else if (arr[i] > dep[j]) {
                plat_needed--;
                j++;
            }

            if (plat_needed > result)
                result = plat_needed;
        }

        return result;
    }
}
