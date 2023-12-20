package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



class ArrayCompression {
    public static void main(String[] args) {
        int[] inputArray = {4, 3, 1, 1, 3, 5, 5, 8, 8, 8, 9,10,10,10};
        int[] compressedArray = compressArray(inputArray);

        // Print the compressed array
        for (int element : compressedArray) {
            System.out.print(element + " ");
        }
    }

    private static int[] compressArray(int[] inputArray) {
        Set<Integer> uniqueElements = new HashSet<>();
        List<Integer> compressedList = new ArrayList<>();

        for (int element : inputArray) {
            // Add the element to the compressed list if it's not already present
            if (uniqueElements.add(element)) {
                compressedList.add(element);
            }
        }

        // Convert the List to an array
        return compressedList.stream().mapToInt(Integer::intValue).toArray();
    }
}
