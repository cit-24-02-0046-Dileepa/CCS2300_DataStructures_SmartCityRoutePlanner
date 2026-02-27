package Module_3;

import Module_2.SortAlgorithms; // Reusing the sorting algorithm
import java.util.Random;

public class PerformanceAnalyzer {

    public static void start() {
        System.out.println("\n====== ALGORITHM PERFORMANCE ANALYZER ======");
        
        // Run algorithms on different input sizes
        int[] sizes = {100, 500, 1000}; 
        
        // Display results in a tabular format
        System.out.printf("%-15s %-20s %-20s%n", "Input Size", "Quick Sort(ns)", "Binary Search(ns)");
        System.out.println("-------------------------------------------------------");

        Random rand = new Random();

        for (int size : sizes) {
            int[] arr = new int[size];
            
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }

            // Measure execution time using System.nanoTime()
            int[] sortArr = arr.clone();
            long startSort = System.nanoTime();
            SortAlgorithms.quickSort(sortArr, 0, sortArr.length - 1);
            long endSort = System.nanoTime();
            long sortTime = (endSort - startSort);

            // Binary search requires a sorted array
            int target = sortArr[rand.nextInt(size)]; 
            
            long startSearch = System.nanoTime();
            SearchAlgorithms.binarySearch(sortArr, target);
            long endSearch = System.nanoTime();
            long searchTime = (endSearch - startSearch);

            System.out.printf("%-15d %-20d %-20d%n", size, sortTime, searchTime);
        }
        System.out.println("-------------------------------------------------------");
    }
}