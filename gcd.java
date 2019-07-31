import java.util.Scanner;

public class gcd {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int M = scanner.nextInt();

        System.out.println(gcd(K, M));
    }

    static int gcd(int K, int M) {
        int k = Math.max(K, M);
        int m = Math.min(K, M);
        while (m != 0) {
            int r = k % m;
            k = m;
            m = r;
        }
        return k;
    }
}

