import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RotateLeft {

    public static void main(String[] args) {
        /*Integer[] elements = {1, 2, 3, 4};
        int elementsSize = elements.length;
        List<Integer> elementList = Arrays.asList(elements);

        System.out.println("index :: "+ elementsSize);
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
        maxElementIndices.forEach(System.out::println);*/

        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(3);

        /*2 4 3 1
            4 3 1 2
            3 1 2 4
            1 2 4 3*/


        //a.add(5);

        List<Integer> rotate = new ArrayList<>();
        //rotate.add(6);
        //rotate.add(9);
         //rotate.add(12);
        rotate.add(1);
        rotate.add(3);
        System.out.print("(");
        new RotateLeft().getMaxElementIndexes(a, rotate).stream().forEach( result -> System.out.printf(",%d", result));

        System.out.print(")");
    }

    private List<Integer> getMaxElementIndexes(List<Integer> a, List<Integer> rotate) {
        List<Integer> maxElementIndices = new ArrayList<>();
        int maxElement = Collections.max(a);
        int maxElementIndex = a.indexOf(maxElement);
        int asize = a.size();
        int modSize;
        for (Integer numRotate : rotate) {
            modSize = numRotate % asize;
            int maxElementIndexRotate = maxElementIndex - modSize;
            //System.out.println("maxElementIndex :: " + maxElementIndex);
            if (maxElementIndexRotate < 0) {
                maxElementIndexRotate = asize + maxElementIndexRotate;
            }
            //System.out.println("final maxElementIndex :: " + maxElementIndex);
            maxElementIndices.add(maxElementIndexRotate);
        }
        return maxElementIndices;
    }

    private List<Integer> getMaxElements(List<Integer> elements, List<Integer> rotates) {
        List<Integer> maxElements = new ArrayList<>();
        Integer elementsSize = elements.size();
        Integer maxElement = Collections.max(elements);
        Integer maxElementIndex = elements.indexOf(maxElement);
        for (Integer rotate : rotates) {
            Integer rotateMod = rotate%elementsSize;
            Integer maxElementRotateIndex = maxElementIndex - rotateMod;

            if (maxElementRotateIndex < 0) {
                maxElementRotateIndex = maxElementRotateIndex + elementsSize;
            }
            maxElements.add(maxElementRotateIndex);
        }
        return maxElements;
    }
}







































