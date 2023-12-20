package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


class UniqueElementsFilter {
    public static void main(String[] args) {
        String[] inputArray = {"A", "B", "C", "A", "D", "B", "Z", "Y", "R", "Z"};
        String[] uniqueElements = filterUniqueElements(inputArray);

        // Print the unique elements
        System.out.println(Arrays.toString(uniqueElements));
    }

    private static String[] filterUniqueElements(String[] inputArray) {
        // Create a HashSet to store unique elements
        Set<String> uniqueSet = new HashSet<>(Arrays.asList(inputArray));

        // Convert the HashSet back to an array
        return uniqueSet.toArray(new String[0]);
    }
}
