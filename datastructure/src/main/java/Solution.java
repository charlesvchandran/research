import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    String highestValuePalindrome(String s, int n, int k) {
        int k1=0;
        char[] sArray = s.toCharArray();
        if (s.length() != n) return "-1";
        if (n==1 || n == k) {
            Arrays.fill(sArray, '9');
            return String.valueOf(sArray);
        }
        int i=0;
        for(;i<n/2;i++) {
            char forwardchar = s.charAt(i);
            char backwardchar = s.charAt(n-i-1);
            if (forwardchar != backwardchar) {
                if (forwardchar != '9') {
                    sArray[i] = '9';
                    k1++;
                }
                if(backwardchar != '9') {
                    sArray[n-i-1] = '9';
                    k1++;
                }
            }
        }
        String s1 = String.valueOf(sArray);
        int j=0;
        boolean breakloop = false;
        outer:
        while (k1 < k) {
            for(;j<n/2;j++) {
                char forwardchar = s1.charAt(j);
                char backwardchar = s1.charAt(n-j-1);

                if ((forwardchar == backwardchar) && k == 1 && forwardchar!=9) break outer;
                //{breakloop = true;break;}

                if (forwardchar == backwardchar) {
                    if (forwardchar != '9') {
                        sArray[j] = '9';
                        k1++;
                    }
                    if (backwardchar != '9') {
                        sArray[n - j - 1] = '9';
                        k1++;
                    }
                }
                if (k1 >= k) break;
            }
        }
        if (n%2 !=0 && k1 < k) {
            sArray[n/2] = '9';
            k1++;
        }
        System.out.println("resultant array :: " + String.valueOf(sArray));
        if (k1 > k) return "-1";
        return String.valueOf(sArray);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/charlesvc/highPalindrome.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = new Solution().highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
