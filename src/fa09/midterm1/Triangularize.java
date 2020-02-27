package fa09.midterm1;

import cs61b.IntList;

import java.util.Arrays;

/**
 * Problem 4.
 *
 * Set each R[k] to a sublist of L such that R[k] contains
 * <=k+1 elements and the concatentaion of all the  R[k] in order
 * gives a prefix of the original list L. Each list R[k] is made
 * as large as possible subject to these rules, with earlier lists
 * taking precedence. For example, if the original L contains
 * [ 1, 2, 3, 4, 5, 6, 7 ], and R has 6 elements, then on return R
 * contains [ [1], [2,3], [4,5,6], [], []]. If R had only 2
 * elements, then on return it would contain [[1], [2,3]].
 * May destroy the original contents of the IntList objects in L,
 * but does not create any new IntList objects.
 *
 * @author Professor Paul Hilfinger, Richard Hu
 */

public class Triangularize {
    static void triangularize (IntList[] R, IntList L) {
        for (int i = 0; i < R.length; i++) {
            int j = i;
            IntList end = L;
            while (j > 0 && end != null) {
                end = end.tail;
                j--;
            }
            IntList tempL = L;
            if (end != null) {
                L = end.tail;
                if (end.tail != null) {
                    end.tail = null;
                }
            } else {
                L = null;
            }
            R[i] = tempL;
        }
    }

    public static void triangularizeTests() {
        IntList L1 = IntList.list(1, 2, 3, 4, 5, 6, 7);
        IntList L2 = IntList.list(1, 2, 3, 4, 5, 6, 7);

        IntList[] R1 = new IntList[6];
        IntList[] R2 = new IntList[2];

        triangularize(R1, L1);
        triangularize(R2, L2);

        System.out.println(Arrays.deepToString(R1));
        System.out.println(Arrays.deepToString(R2));
    }
}
