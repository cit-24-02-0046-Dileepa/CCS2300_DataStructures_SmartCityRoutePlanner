package mainapp;

import Module_1.Graph;
import Module_1.LocationBST;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocationBST bst = new LocationBST();
        Graph graph = new Graph();
        int choice;

        do {
            System.out.println("\n===== MODULE 1: SMART CITY ROUTE PLANNER =====");
            System.out.println("1. Add Location");
            System.out.println("2. Add Road");
            System.out.println("3. Display Locations (Sorted - BST)");
            System.out.println("4. Display Road Connections");
            System.out.println("5. BFS Traversal");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String location = sc.nextLine();
                    bst.insert(location);
                    graph.addLocation(location);
                    System.out.println("Location added successfully!");
                    break;
                case 2:
                    System.out.print("Enter source location: ");
                    String source = sc.nextLine();
                    System.out.print("Enter destination location: ");
                    String dest = sc.nextLine();
                    graph.addRoad(source, dest);
                    break;
                case 3:
                    bst.displayInOrder();
                    break;
                case 4:
                    graph.displayConnections();
                    break;
                case 5:
                    System.out.print("Enter starting location: ");
                    String start = sc.nextLine();
                    graph.bfs(start);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }
}