package fa11.midterm1;

public class TemplTest {
    public static void run() {
        Templ.s(new Grandchild(2));
    }
}

abstract class Templ {
    abstract int f();

    int g() {
        return 2 * f();
    }

    static void s(Templ x) {
        System.out.println(x.g());
    }
}

class Child extends Templ {
    Child(int z) {
        _z = z;
    }

    int f() {
        return _z;
    }

    int _z;
}

class Grandchild extends Child {
    Grandchild(int z) {
        super(z);
        _z = 5 * z;
    }

    int g() {
        return 3 * f();
    }

    int _z;
}