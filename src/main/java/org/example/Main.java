package org.example;

import java.util.HashMap;
import java.util.Map;


 class NumberFrequency {
    public static void main(String[] args) {
        int[] inputArray = {2, 1, 3, 2, 1, 7, 3, 6, 1,7, 2, 58,58, 66, 7};
        printNumberFrequency(inputArray);
    }

    private static void printNumberFrequency(int[] inputArray) {
        // Create a HashMap to store the frequency of each number
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each number in the array
        for (int num : inputArray) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Print the frequency of each number
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            System.out.println(number + " is repeated " + frequency + " times");
        }
    }
}
