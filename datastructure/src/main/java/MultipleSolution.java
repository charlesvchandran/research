import java.util.ArrayList;
import java.util.List;


import java.io.*;

import static java.util.stream.Collectors.joining;

public class MultipleSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("solution_out.out"));

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        int y = Integer.parseInt(bufferedReader.readLine().trim());

        int z = Integer.parseInt(bufferedReader.readLine().trim());

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = MultipleResult.multiple(x, y, z, n);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

class MultipleResult {

    /*
     * Complete the 'multiple' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER x
     *  2. INTEGER y
     *  3. INTEGER z
     *  4. INTEGER n
     */

    public static List<Integer> multiple(int x, int y, int z, int n) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<=n;i++) {
            if ((x>0 && y>0 && z>0) && (i%x==0 || i%y ==0) && i%z !=0) {
                result.add(i);
            }
        }
        return result;
    }

}
