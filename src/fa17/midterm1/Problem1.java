package fa17.midterm1;

import cs61b.IntList;

import java.util.Arrays;

public class Problem1 {
    /** Part (a)
     *
     * Solution: 4, 2
     * Run runPartA() for box-and-pointer diagram
     */
    public static void runPartA() {
        IntList a = IntList.list(1, 2, 3);
        IntList b = a;
        a.head = 4;

        System.out.println(b.head);
        a = a.tail;
        a.tail = new IntList(7, b);

        System.out.println(b.tail.tail.tail.tail.head);

        System.out.println("a: " + a.toString());
        System.out.println("b: " + b.toString());
    }

    /** Part (b)
     *
     * Solution: 2, true, false
     * Run runPartB() for box-and-pointer diagram
     */
    public static void runPartB() {
        int[][] A = new int[3][2];
        int[][] B = new int[3][];
        int[] C = new int[] { 1, 2 };

        for (int i = 0; i < 3; i += 1) {
            for (int j = 0; j < 2; j += 1) {
                A[i][j] = i + j;
            }
        }
        for (int i = 0; i < 3; i += 1) {
            B[i] = A[i];
        }

        A[0][1] += 1;

        System.out.println(B[0][1]);

        System.out.println(A[1] == B[1]);

        System.out.println(A[1] == C);

        System.out.println("A: " + Arrays.deepToString(A));
        System.out.println("B: " + Arrays.deepToString(B));
        System.out.println("C: " + Arrays.toString(C));
    }

    /** Part (c)
     *
     * Debug runPartC() for box-and-pointer
     */
    public static void runPartC() {
        IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8);

        IntList p, n;
        p = A;
        while (p != null) {
            n = p.tail.tail;
            p.tail.tail = p;
            p = n;
        }
        System.out.println(A.toString());
    }
}
