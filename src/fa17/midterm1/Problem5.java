package fa17.midterm1;

import cs61b.IntList;

public class Problem5 {

    public static void test() {
        IntList L = IntList.list(1, 4, 6, 20, 31);
        IntList T = insertVals(L, IntList.list(3, 10, 15, 25, 32, 33), (x, L1) -> L1 == null || x < L1.head);
        System.out.println(T.toString());
    }

    public static IntList insertVals(IntList L, IntList insertions,
                                     IntListPred pred) {
        if (insertions == null) {
            return null;
        } else if (pred.apply(insertions.head, L)) {
            return new IntList(insertions.head, insertVals(L, insertions.tail, pred));
        } else if (L == null) {
            return null;
        } else {
            return new IntList(L.head, insertVals(L.tail, insertions, pred));
        }
    }
}

interface IntListPred {
    /** Return true iff X and L satisfy (are true according to)
     * this predicate. */
    boolean apply(int x, IntList L);
}