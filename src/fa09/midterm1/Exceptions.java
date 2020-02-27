package fa09.midterm1;

/**
 * Problem 2, part c.
 *
 * @author Professor Paul Hilfinger
 */

public class Exceptions {

    public static void run() {
        try {
            f (42, new IllegalArgumentException ());
        } catch (IllegalArgumentException e) {
            System.out.println ("main");
        }
    }

    static void  f(int n, IllegalArgumentException err) {
        if (n > 39) {
            try {
                f (n-1, err);
            } catch (IllegalArgumentException e) {
                System.out.printf ("f(%d) err%n", n);
            }
            System.out.printf ("f(%d)%n", n);
        } else {
            g (n, err);
        }
    }

    static void g (int n, IllegalArgumentException err) {
        if (n < 3)
            throw err;
        else f (n - 1, err);
    }

}