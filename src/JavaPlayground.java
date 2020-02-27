import fa09.midterm1.Exceptions;
import fa09.midterm1.G;
import fa09.midterm1.Triangularize;
import fa11.midterm1.Distribute;
import fa11.midterm1.Sum;
import fa11.midterm1.TemplTest;
import fa17.midterm1.*;
import sp18.midterm1.Combine;
import sp20.dis.examprep.MaxPool;

/**
 * Playground to mess around with Java features.
 *
 * @author Richard Hu
 */

public class JavaPlayground {
    public static void main(String[] args) {
        kartikkapur.midterm1.Problem1.run();
        Top x = new Bottom();
        System.out.println(x.s);
        System.out.println(((Bottom) x).s);
    }
}

class Top {
    String s = "top";

    void f() {
        System.out.println("Top");
    }
}

class Bottom extends Top {
    String s = "bottom";

    void f() {
        System.out.println("Bottom");
    }
}