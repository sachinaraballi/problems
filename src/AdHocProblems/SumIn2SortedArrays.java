package AdHocProblems;

import java.util.HashSet;

/**
 * 
 * @author sachinaraballi
 * 
 * Count pairs from two "sorted" arrays whose sum is equal to a given
 * value x
 * https://www.geeksforgeeks.org/count-pairs-two-sorted-arrays-whose-sum-equal-given-value-x/
 *
 */

public class SumIn2SortedArrays {
    static int[] A1;
    static int[] A2;
    static int x;

    public static void main(String[] args) {
        A1 = new int[] { 1, 2, 3, 4, 5, 7, 11 };
        A2 = new int[] { 2, 3, 4, 5, 6, 8, 12 };
        x = 9;

        // bruteforce method
        // O(mn)
        countPairs1();

        // Binary Search
        // O(mlogn)
        countPairs2();

        // two pointers
        // O(m + n)
        countPairs3();

        // Hashing
        // O(m + n)
        countPairs4();
    }

    /**
     * Using two loops pick elements from both the arrays and check whether the
     * sum of the pair is equal to x or not.
     */
    public static void countPairs1() {
        int count = 0;
        for (int i = 0; i < A1.length; i++) {
            for (int j = 0; j < A2.length; j++) {
                if (A1[i] + A2[j] == x) {
                    count++;
                }
            }
        }
        System.out.println("method1 = " + count);
    }

    /**
     * in second array key(x - A1[i]) will be searched through binary search logn
     */
    public static void countPairs2() {
        int count = 0;
        for (int i = 0; i < A1.length; i++) {
            int value = x - A1[i];
            int low = 0;
            int high = A2.length - 1;
            while (low <= high) {
                int mid = (low + high) >>> 1;
                if (A2[mid] == value) {
                    count++;
                    break;
                } else if (A2[mid] < value) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        System.out.println("method2 = " + count);
    }

    /**
     * This approach uses the concept of two pointers, one to traverse 1st array
     * from left to right and another to traverse the 2nd array from right to
     * left.
     */
    private static void countPairs3() {

        int count = 0;
        int n = A1.length - 1;
        int m = A2.length - 1;
        int l = 0;
        int r = m - 1;
        while (r >= 0 && l <= n) {
            if (A1[l] + A2[r] == x) {
                count++;
                l++;
                r--;
            } else if (A1[l] + A2[r] < x) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println("method3 = " + count);
    }

    /**
     * We store all first array elements in hash table. For elements of second
     * array, we subtract every element from x and check the result in hash
     * table. If result is present, we increment the count.
     */
    private static void countPairs4() {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A1.length; i++) {
            set.add(A1[i]);
        }
        for (int i = 0; i < A2.length; i++) {
            Integer value = x - A2[i];
            if (set.contains(value))
                count++;
        }
        System.out.println("method4 = " + count);
    }

}
