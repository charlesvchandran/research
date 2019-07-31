import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String... args) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2,3,4,5);
        int odd  =  number.stream().filter(x -> x%2 != 0).reduce(0, (ans, i) -> ans+i);
        int even =  number.stream().filter(x -> x%2 == 0).reduce(0, (ans, i) -> ans+i);

        System.out.println("even -> "+ even + " :: odd -> " + odd);

        Integer[] empIds = { 1, 2, 3, 4 };

        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"),
                Arrays.asList("Mark", "Zuckerberg"));
        List<String> names = namesNested.stream().flatMap(Collection::stream)
                .peek(x -> x.replace("a", "p"))
                .distinct()
                //.peek(System.out::println)
                .collect(Collectors.toList());
        names.forEach(System.out::println);

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 0, 2);

        streamOfArrayFull.forEach(System.out::println);
        streamOfArrayPart.forEach(System.out::println);

        Stream<String> streamBuilder = Stream.<String>builder().add("start").add("middle").add("end").build();
        streamBuilder.forEach(System.out::println);

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(2);
        streamGenerated.forEach(System.out::println);

    }
}
