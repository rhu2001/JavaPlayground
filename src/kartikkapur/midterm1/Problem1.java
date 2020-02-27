package kartikkapur.midterm1;

public class Problem1 {
    public static void run() {
        new Juice();
    }
}

class Juice {
    public OJ o1;
    public static OJ o2;

    public Juice() {
        o1 = new OJ(1, 2);
        o1.z = new OJ(5, 6);
        o2 = new OJ(3, 4);
        o2.z = new OJ(7, 8);
        pulpify();
        vitaminSeed();
        appleImposter();
    }

    public void pulpify() {
        o1.x[1] = o2.x[1];
        checkVals();
    }

    public void vitaminSeed() {
        o1.x[0] = o1.z.x[0];
        checkVals();
        o2.x[0] = o2.z.x[1];
        checkVals();
        o1.z = o2;
    }

    public void appleImposter() {
        o1.x[1] = o2.x[0];
        o2.x[0] = o1.x[1];
        o2.x[1] = o1.z.x[0];
        checkVals();
    }

    public void checkVals() {
        System.out.println("o1.x[0]: " + o1.x[0]);
        System.out.println("o1.x[1]: " + o1.x[1]);
        System.out.println("o2.x[0]: " + o2.x[0]);
        System.out.println("o2.x[0]: " + o1.x[1]);
        System.out.println();
    }
}

class OJ {
    int[] x;
    OJ z;
    OJ(int x, int y) {
        this.x = new int[2];
        this.x[0] = x;
        this.x[1] = y;
    }
}
