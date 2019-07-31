import java.util.HashSet;
import java.util.Scanner;

public class ShortHash {
    public static void execute() {
        HashSet s = new HashSet();
        for (short i=0;i<100;i++) {
            s.add(i);s.remove(i-1);
        }
        System.out.println(s.size());
    }

    public static void main(String... args) {
        ShortHash.execute();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++) a[a_i] = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int m = in.nextInt();
            System.out.println(a[(n - (k % n)+ m) % n]);
        }
    }
}
