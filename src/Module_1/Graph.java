package Module_1;

import java.util.*;

/*
 * Graph
 * Represents roads using adjacency list
 */
public class Graph {

    private Map<String, List<String>> adjList = new HashMap<>();

    // Add location
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }
