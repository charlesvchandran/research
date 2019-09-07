import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class ShortHash {
    public static void execute() {
        HashSet s = new HashSet();
        List<Object> l = new ArrayList<>();
        System.out.println("set size :: " + s.size() + " :: list size :: " + l.size());
        for (short i=0;i<100;i++) {
            s.add(i);
            boolean removedfromset = s.remove(i-1);
            l.add(i);
            System.out.println("i :: " + i + " :: set size :: " + l.size());
            /*Object removedfromlist = null;
            if (i >0) {
                try {
                    System.out.println("List size :: " + l.size());
                    removedfromlist =  l.remove(i - 1);
                } catch (Exception e) {
                    System.out.println("indexOutOfBounds Exception :: " + e.getMessage());

                }
            }
            System.out.println("removedfromset:: "+ removedfromset + " :: removedfromlist:: "+ removedfromlist);*/

            /*if (i > 0)
                l.remove(i-1);*/
        }
        System.out.println("item:: " + s.iterator().next().toString());
        System.out.println(" set size :: " + s.size() + " list size :: " + l.size());
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
