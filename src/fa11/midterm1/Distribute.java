package fa11.midterm1;

import cs61b.IntList;

import java.util.Arrays;

public class Distribute {

    public static void test() {
        IntList L1 = IntList.list(6, 7, 8, 9);
        IntList[] R1 = {IntList.list(1, 2), IntList.list(3, 4, 5), new IntList()};

        distribute(L1, R1);
        System.out.println(Arrays.deepToString(R1));
    }

    /** Distribute the elements of L to the lists in R round-robin
     * fashion. That is, if m = R.length, then the first item in L
     * is appended to R[0], the second to R[1], ..., the mth item
     * to R[m-1], the m+1st to R[0], etc. So if R starts out containing
     * the IntList sequences [1, 2], [3, 4, 5], and [], and L starts out
     * containing [6, 7, 8, 9], then distribute(L, R) causes R to end up
     * containing [1, 2, 6, 9], [3, 4, 5, 7], and [9]. May destroy the
     * original list L. Must not create any new IntList elements. */
    static void distribute(IntList L, IntList[] R) {
        if (R.length > 0) {
            int index = 0;
            while (L != null) {
                if (index == R.length) {
                    index = 0;
                }
                putToEnd(R[index], L.head);
                index += 1;
                L = L.tail;
            }
        }
    }

    private static void putToEnd(IntList L, int e) {
        if (L.head == 0 && L.tail == null) {
            L.head = e;
        } else if (L.tail == null) {
            L.tail = new IntList(e, null);
        } else {
            putToEnd(L.tail, e);
        }
    }
}