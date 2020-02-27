package sp18.midterm1;

public class Combine {
    public static void test() {
        int[] l1 = {1, 2, 3, 4};
        System.out.println(combine(new ComFunc() {
            @Override
            public int apply(int a, int b) {
                return a + b;
            }
        }, l1));

        System.out.println(combine(new ComFunc() {
            @Override
            public int apply(int a, int b) {
                return a * b;
            }
        }, l1));
    }

    public static int combine(ComFunc f, int[] x){
        if (x.length == 0) {
            return 0;
        }
        if (x.length == 1) {
            return x[0];
        }
        return result(f, x, 0);
    }

    private static int result(ComFunc f, int[] x, int i) {
        if (i == x.length - 1) return x[i];
        if (i + 1 == x.length - 1) return f.apply(x[i], x[i + 1]);
        return f.apply(f.apply(x[i], x[i + 1]), result(f, x, i + 2));
    }
}

interface ComFunc {
    int apply(int a, int b);
}