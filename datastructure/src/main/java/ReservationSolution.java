import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'missingReservations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY firstReservationList
     *  2. 2D_INTEGER_ARRAY secondReservationList
     */

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        // Write your code here
        boolean foundSecond = false;
        Comparator<List<Integer>> compareByEpoch = Comparator.comparing((List<Integer> r) -> r.get(1));

        //Collections.sort(firstReservationList, compareByEpoch.reversed());
        //Collections.sort(secondReservationList, compareByEpoch.reversed());

        List<Integer> missingReservations = new ArrayList<>();

        //secondReservationList.stream().anyMatch();


        for (int i=0;i<secondReservationList.size();i++) {
            List<Integer> secondReservation = secondReservationList.get(i);

            firstReservationList.removeIf(n -> n.get(0).equals(secondReservation.get(0)));
        }
        Collections.sort(firstReservationList, compareByEpoch);
        /*for (List<Integer> secondReservation : secondReservationList) {
            for (List<Integer> firstReservation : firstReservationList) {
                if (secondReservation.get(0).equals(firstReservation.get(0))) {
                    foundSecond = true;
                }
            }

            if (!foundSecond) {
                missingReservations.add(secondReservation.get(0));
            }
            foundSecond = false;
        }*/

        return missingReservations;
    }

}

public class ReservationSolution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("solution_out.out"));

        int firstReservationListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int firstReservationListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> firstReservationList = new ArrayList<>();

        IntStream.range(0, firstReservationListRows).forEach(i -> {
            try {
                firstReservationList.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int secondReservationListRows = Integer.parseInt(bufferedReader.readLine().trim());
        int secondReservationListColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> secondReservationList = new ArrayList<>();

        IntStream.range(0, secondReservationListRows).forEach(i -> {
            try {
                secondReservationList.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.missingReservations(firstReservationList, secondReservationList);

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
