package mainapp;

import Module_1.Graph;
import Module_1.LocationBST;
import Module_2.DataSorter;
import Module_3.PerformanceAnalyzer;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocationBST bst = new LocationBST();
        Graph graph = new Graph();
        int choice;

        do {
            System.out.println("\n===== FULL PROJECT MAIN MENU =====");
            System.out.println("1. Module 1: Smart City Route Planner");
            System.out.println("2. Module 2: Data Sorter");
            System.out.println("3. Module 3: Algorithm Performance Analyzer");
            System.out.println("0. Exit Application");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    runModule1(sc, bst, graph);
                    break;
                case 2:
                    DataSorter.start();
                    break;
                case 3:
                    PerformanceAnalyzer.start();
                    break;
                case 0:
                    System.out.println("Exiting Application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        sc.close();
    }

    private static void runModule1(Scanner sc, LocationBST bst, Graph graph) {
        int c;
        do {
            System.out.println("\n--- ROUTE PLANNER ---");
            System.out.println("1. Add Location | 2. Add Road | 3. Display Sorted | 4. Connections | 5. BFS | 0. Back");
            System.out.print("Enter choice: ");
            c = sc.nextInt();
            sc.nextLine();

            if (c == 1) {
                System.out.print("Enter location: ");
                String loc = sc.nextLine();
                bst.insert(loc);
                graph.addLocation(loc);
            } else if (c == 2) {
                System.out.print("Source: "); String s = sc.nextLine();
                System.out.print("Dest: "); String d = sc.nextLine();
                graph.addRoad(s, d);
            } else if (c == 3) {
                bst.displayInOrder();
            } else if (c == 4) {
                graph.displayConnections();
            } else if (c == 5) {
                System.out.print("Start node: "); String start = sc.nextLine();
                graph.bfs(start);
            }
        } while (c != 0);
    }
}