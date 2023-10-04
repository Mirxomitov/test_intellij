public class Power {
    public static void main(String[] args) {

        int a = 2;
        int b = 10;
        int mod = 20;

        System.out.println(pow(a, b));
        System.out.println(powMod(a, b, mod));
        System.out.println(binPowRec(a, b));
        System.out.println(binPowSupper(a, b));
        System.out.println(binPowSupperMod(a, b, mod));
    }

    static int pow(int num, int pow) {

        int res = 1;

        for (int i = 1; i <= pow; i++) {
            res *= num;
        }

        return res;
    }

    static int powMod(int num, int pow, int mod) {

        int res = 1;

        for (int i = 0; i < pow; i++) {
            res = (res * num) % mod;
        }

        return res;
    }

    static int binPowRec(int num, int pow) {
        if (pow == 0) return 1;
        if (pow == 1) return num;

        int left = binPowRec(num, pow / 2);
        int mid = pow % 2 == 0 ? 1 : num;

        return left * left * mid;

    }

    static int binPowSupper(int num, int pow) {
        int res = 1;

        while (pow > 0) {

            if (pow % 2 == 1) {
                res *= num;
            }

            num *= num;
            pow >>= 1;
        }

        return res;
    }

    static int binPowSupperMod(int num, int pow, int mod) {
        int res = 1;

        while (pow > 0) {

            if (pow % 2 == 1) {
                res = res * num % mod;
            }

            num = num * num % mod;
            pow >>= 1;
        }

        return res;
    }
}
