package fa09.midterm1;

/**
 * Problem 2, part d.
 *
 * @author Professor Paul Hilfinger
 */

abstract class F {
    abstract int a (int x);

    F c (F g) {
        System.out.println ("F.c");
        return new C(this, g);
    }

    F r (int n) {
        System.out.println("F.r");
        if (n <= 1)
            return this;
        else return this.c (r(n - 1));
    }

    F c2 () {
        return this.r(2);   //Goes to G.r because the dynamic type of f is G
    }

    static class C extends F {
        private F f, g;
        C (F f, F g) { this.f = f; this.g = g; }
        int a (int x) { return f.a(g.a(x)); }
    }

}

public class G extends F {
    int i ;
    F r (int n) { System.out.println("G.r"); return new G (n * i); }
    G (int i) {this.i = i; }
    int a (int x) { return x + i; }
    public static void run() {
        F f = new G (21);
        System.out.println (f.c2().a(0));
    }
}
