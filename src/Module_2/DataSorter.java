package Module_2;

import java.util.*;

public class DataSorter {

    private static Scanner sc = new Scanner(System.in);
    private static int[] originalArray = null;

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        while (true) {
            System.out.println("\n===== DATA SORTER MODULE =====");
            System.out.println("1. Enter Numbers Manually");
            System.out.println("2. Generate Random Numbers");
            System.out.println("3. Run Sorting Algorithms");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: enterNumbers(); break;
                case 2: generateRandom(); break;
                case 3: runSorting(); break;
                case 4: System.out.println("Exiting program..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void enterNumbers() {
        System.out.print("How many numbers? ");
        int n = sc.nextInt();
        originalArray = new int[n];
        System.out.println("Enter the numbers:");
        for (int i = 0; i < n; i++) originalArray[i] = sc.nextInt();
    }

    private static void generateRandom() {
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        originalArray = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) originalArray[i] = r.nextInt(1000);
        System.out.println("Random array generated: " + Arrays.toString(originalArray));
    }

    private static void runSorting() {
        if (originalArray == null) {
            System.out.println("Enter or generate numbers first!"); return;
        }

        int[] bubbleArray = originalArray.clone();
        int[] mergeArray = originalArray.clone();
        int[] quickArray = originalArray.clone();

        long bubbleTime = PerformanceUtil.measure(() -> BubbleSort.sort(bubbleArray));
        long mergeTime = PerformanceUtil.measure(() -> MergeSort.sort(mergeArray, 0, mergeArray.length - 1));
        long quickTime = PerformanceUtil.measure(() -> QuickSort.sort(quickArray, 0, quickArray.length - 1));

        System.out.println("\nSorted Output (Quick Sort):");
        printArray(quickArray);

        printComparison(bubbleTime, mergeTime, quickTime);
    }

    private static void printComparison(long bubble, long merge, long quick) {
        System.out.println("\n===== PERFORMANCE COMPARISON =====");
        System.out.printf("%-12s %-12s %-12s%n", "Algorithm", "Time(ns)", "Time(ms)");
        System.out.printf("%-12s %-12d %-12.6f%n", "Bubble", bubble, bubble / 1_000_000.0);
        System.out.printf("%-12s %-12d %-12.6f%n", "Merge", merge, merge / 1_000_000.0);
        System.out.printf("%-12s %-12d %-12.6f%n", "Quick", quick, quick / 1_000_000.0);
    }

    private static void printArray(int[] arr) {
        for (int num : arr) System.out.print(num + " ");
        System.out.println();
    }
}

