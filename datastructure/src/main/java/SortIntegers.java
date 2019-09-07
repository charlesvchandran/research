import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import static java.util.Comparator.*;

public class SortIntegers {

    public static void main(String... args) {
        //Input
        /*Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();*/
       // String[] s = {"12", "2", "-3", "0", "5", "7", "9", "2", "1"};
        //String[] s = {"123", "45", "766", "324324", ".324", "0.325", "-234", "4546", "100", "0", "000.000"};
        String[] s = {"-100", "50", "0", "56.6", "90", "0.12", ".12", "02.34", "000.000", null, null};

        //unsorted Output
        /*for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }*/


        Arrays.sort(s, Collections.reverseOrder(Comparator.nullsFirst(Comparator.comparing(BigDecimal::new))));




        /*Arrays.sort(s, Collections.reverseOrder(new Comparator<String>() {
            @Override
            public int compare(String a1, String a2) {
                BigDecimal a = new BigDecimal(a1);
                BigDecimal b = new BigDecimal(a2);
                return a.compareTo(b);
            }
        }));*/
        /*-100
        0
        000.000
        0.12
        .12
        02.34
        50
        56.6
        90*/

        /*Arrays.sort(s, (s1, s2) -> {
            if (s1 == null) return -1;
            else if (s2 == null) return 1;
            else return new BigDecimal(s2).compareTo(new BigDecimal(s1));

        });*/

       /*Arrays.sort(s, (s1,s2)->{
            if( s1 == null ) {
                return 1;
            }
            else if( s2 == null ) {
                return -1;
            }
            else {
                return new BigDecimal(s2).compareTo(new BigDecimal(s1));
            }
        });*/

        Arrays.stream(s).forEach(System.out::println);
        //Output
        /*for(int i=0;i<n;i++) {
            System.out.println(s[i]);
        }*/
    }
}
