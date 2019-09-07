import java.math.BigInteger;

public class AlgebraTest {

    public static void main(String[] args) {
        int n = 2;

        n = n << 1; // Multiply n with 2
        System.out.println("n mulitiply by 2 :: " + n);

        n = n >> 1; // Divide n by 2
        System.out.println("n divide by 2 :: " + n);

        BigInteger ab = new BigInteger("23");
        BigInteger cd = new BigInteger("46");

        BigInteger gcd = ab.gcd(cd);

        System.out.println("gcd of " + ab + " and " + cd + " is " + gcd);

        BigInteger lcm = (ab.multiply(cd)).divide(gcd);

        System.out.println("LCM of " + ab + " and " + cd + " is " + lcm);

        String successKey = "succ-".concat("0582352");
        String failKey = "fail-".concat("3458029352");

        System.out.println("successkey:: "+ successKey + " :: failkey :: "+ failKey);

    }
}
