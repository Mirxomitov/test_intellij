import java.util.ArrayList;
import java.util.List;

public class GCD {
    public static void main(String[] args) {

        int a = 52;
        int b = 390;
//        System.out.println(gcdSubtraction(a, b));
//        System.out.println(gcdEuclid(a, b));
//        System.out.println(gcdEuclid2(a, b));
//        System.out.println(gcdStandard(a, b));
    }

    static int gcdStandard(int num1, int num2) {

        List<Integer> primeDivisors1 = primeDivisors(num1);
        List<Integer> primeDivisors2 = primeDivisors(num2);

        System.out.println(primeDivisors1);
        System.out.println(primeDivisors2);

        int right = 0;
        int left = 0;

        int gcd = 1;

        while (left < primeDivisors1.size() && right < primeDivisors2.size()) {

            int divisor1 = primeDivisors1.get(left);
            int divisor2 = primeDivisors2.get(right);

            if (divisor1 == divisor2) {
                gcd *= divisor1;

                left++;
                right++;
            } else if (divisor1 > divisor2) {
                right++;
            } else {
                left++;
            }
        }

        return gcd;
    }

    private static List<Integer> primeDivisors(int num) {
        List<Integer> primeDivisors = new ArrayList<>();
        for (int i = 2; i < num / 2; i++) {

            while (num % i == 0) {
                primeDivisors.add(i);
                num /= i;
            }
        }

        if (num != 1) primeDivisors.add(num);

        return primeDivisors;
    }

    private static int gcdEuclid(int num1, int num2) {

        while (num2 != 0) {
            int remainder = num1 % num2;

            num1 = num2;
            num2 = remainder;
        }

        return num1;
    }

    private static int gcdEuclid2 (int num1, int num2) {
        if(num2 == 0) return num1;
        return gcdEuclid2(num2, num1 % num2);
    }

    private static int gcdSubtraction(int num1, int num2) {
        while (num1 != num2) {
            if (num1 > num2) num1 -= num2;
            else num2 -= num1;
        }

        return num1;
    }


}
