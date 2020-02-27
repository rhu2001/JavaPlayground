package fa17.midterm1;

public class Problem3 {

    /** Solution:
     * (a)
     * A.g
     * B.h 42
     * (b)
     * 3
     * 42
     *
     */
    public static void test() {
        C.run();
    }
}

class A {
    int x = 3;
    void f() {
        B me = (B) this;
        System.out.println("(a)");
        g(this);
        System.out.println("(b)");
        System.out.println(x);
        System.out.println(me.x);
    }
    static void g(A x) {
        System.out.println("A.g");
        x.h();
    }
    void h() {
        System.out.println("A.h " + this.x);
    }
}
class B extends A {
    int x = 42;
    void h() {
        System.out.println("B.h " + this.x);
    }
}
class C {
    public static void run() {
        A p = new B();
        p.f();
    }
}