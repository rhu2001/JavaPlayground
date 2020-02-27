package fa17.midterm1;

import java.util.Arrays;

public class Problem2 {

    public static void test() {
        String[] A = { "A", "B", "C", "D", "E", "F", "G", "H" };
        int[] starts = { 1, 5, 2 };
        int[] lengs = { 2, 3, 4 };

        String[] result = new String[10];
        result = gather(A, starts, lengs);
        System.out.println(Arrays.toString(result));
    }

    /** Return an array containing subarrays of A concatenated
     * together. The kth such subarray starts at index STARTS[k]
     * in A and has length LENGS[k]. Assume that STARTS and LENGS
     * have the same length and that the indicated ranges are all
     * within the bounds of A.
     * For example, if A is
     *     { "A", "B", "C", "D", "E", "F", "G", "H" }
     * STARTS is
     *     { 1, 5, 2 }
     * and LENGS is
     *     { 2, 3, 4 }
     * then the result will be
     *     { "B", "C", "F", "G", "H", "C", "D", "E", "F" }
     *       |<---->|  |<--------->|  |<-------------->|
     */
    static String[] gather(String[] A, int[] starts, int[] lengs) {
        int N;
        N = 0;

        for (int e : lengs) {
            N += e;
        }
        String[] result = new String[N];
        int k;
        k = 0;
        for (int i = 0; i < starts.length; i++) {
            System.arraycopy(A, starts[i], result, k, lengs[i]);
            k += lengs[i];
        }
        return result;
    }
}
