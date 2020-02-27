package fa17.midterm1;

import java.util.Arrays;

public class Problem6 {

    public static void test() {

        DefaultChooser dc = new DefaultChooser();
        String[] strs = new String[]{"9999", "8888", "7777", "6666", "5555", "4444", "3333", "2222,", "1111"};

        System.out.println(Arrays.deepToString(dc.choose(strs[0], strs[1])));

        BadJudge bj = new BadJudge(dc);
        System.out.println(Arrays.deepToString(bj.choose(strs[0], strs[1])));

        System.out.println(maxString(strs));
    }

    /** Part (c)
     *
     * Return the best value in A according to C. A must be non-empty.
     * */
    public static Object best(Object[] A, Chooser C) {
        if (A.length == 1) {
            return A[0];
        } else {
            Object[] rest = new Object[A.length - 1];
            System.arraycopy(A, 0, rest, 0, A.length - 1);
            return C.chosen(A[A.length - 1], best(rest, C));
        }
    }

    /** Part (d)
     *
     * Return the largest value in WORDS, as determined by the
     * .compareTo method on Strings. */
    static String maxString(String[] words) {
        return (String) best(words, new partD());
    }
}

interface Chooser {
    /** Return either { X, Y } or { Y, X }. The first value of
     * returned array is called the chosen value, and the second
     * is the other value. This method may throw an exception if
     * X and Y do not have the proper dynamic types for this Chooser. */
    Object[] choose(Object x, Object y);
    /** Returns the chosen value from X and Y. */
    Object chosen(Object x, Object y);
    /** Returns the other (non-chosen) value from X and Y. */
    Object other(Object x, Object y);
}

class DefaultChooser extends Judge {
    @Override
    public Object[] choose(Object x, Object y) {
        return new Object[]{ x, y };
    }
}

/** Part (a)
 */
abstract class Judge implements Chooser {
    @Override
    public Object chosen(Object x, Object y) {
        return choose(x, y)[0];
    }
    @Override
    public Object other(Object x, Object y) {
        return choose(x, y)[1];
    }
}

/** Part (b)
 *
 * extends Judge must precede implements Chooser
 */
class BadJudge extends Judge implements Chooser {
    Chooser C;

    public BadJudge(Chooser C) {
        this.C = C;
    }

    @Override
    public Object[] choose(Object x, Object y) {
        Object[] r = C.choose(x, y);
        Object temp = r[0];
        r[0] = r[1];
        r[1] = temp;
        return r;
    }
}

/** Part (d)
 */
class partD extends Judge {
    @Override
    public Object[] choose(Object x, Object y) {
        Object[] rv = new Object[2];
        if (((String) x).compareTo((String) y) >= 0) {
            rv[0] = x;
            rv[1] = y;
        } else {
            rv[1] = x;
            rv[0] = y;
        }
        return rv;
    }
}