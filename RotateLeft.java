import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateLeft {

    public static void main(String[] args) {
        Integer[] elements = {1, 2, 3, 4};
        int elementsSize = elements.length;
        List<Integer> elementList = Arrays.asList(elements);
        int maxElementListIndex = elementList.indexOf(Collections.max(elementList));

        //System.out.println("maxElementListIndex:: " + maxElementListIndex);

        int k = 10;
        int maxElement = elements[0];
        int maxElementIndex = 0;
        for (int i=0; i<elementsSize; i++) {
           if (elements[i] > maxElement) {
               maxElement = elements[i];
               maxElementIndex = i;
           }
        }

        //System.out.println("maxElementIndex:: " + maxElementIndex);

        List<Integer> maxElementIndices = new ArrayList<>();
        maxElementIndices.add(maxElementIndex);
        int maxElementIndexOnIterate = maxElementIndex - 1;
        for (int i=1;i<=k;i++) {
            if (maxElementIndexOnIterate < 0) {
                maxElementIndexOnIterate = elementsSize - 1;
            }
            maxElementIndices.add(maxElementIndexOnIterate);
            maxElementIndexOnIterate = maxElementIndexOnIterate - 1;
        }
        maxElementIndices.forEach(System.out::println);
    }
}
