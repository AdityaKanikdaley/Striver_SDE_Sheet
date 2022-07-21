package Arrays_1;

import java.util.Arrays;

// https://www.youtube.com/watch?v=oaVa-9wmpns&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=3
// This problem is a variation of the popular Dutch National flag algorithm

// solution-1
// tc: O(N), sc: O(1)
// using algorithm
class UsingAlgorithm_012 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,0,1,1,2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length-1;
        int temp;

        while(mid <= high) {
            switch(nums[mid]) {
                case 0: {
                    temp = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp;

                    low++;
                    mid++;
                    break;
                }
                case 1: {
                    mid++;
                    break;
                }
                case 2: {
                    temp = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp;

                    high--;
                    break;
                }
            }
        }
    }
}

// solution-2
// tc: O(N) + O(N) = O(2N), sc: O(1)
// my solution
class MySolution_012 {
    public static void main(String[] args) {
        int[] nums = {0,1,2,0,1,1,2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;

        for(int i : nums) {
            if(i==0) count_0++;
            if(i==1) count_1++;
            if(i==2) count_2++;
        }

        for(int i=0; i<nums.length; i++) {
            if(count_0-- > 0) {
                nums[i] = 0;
                continue;
            }

            if(count_1-- > 0) {
                nums[i] = 1;
                continue;
            }

            if(count_2-- > 0) {
                nums[i] = 2;
                continue;
            }
        }
    }
}