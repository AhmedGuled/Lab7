class Main {
  public static void main(String[] args) {
    String[] vertices = {
        "Liberal Arts",
        "Student Services",
        "Health Careers & Sciences",
        "Health Technologies Center",
        "Recreation Center",
        "Technology Learning Center",
        "Business & Technology",
        "Theatre"
    };

    int[][] edges = {
        {0, 1},
        {1, 2},
        {2, 3},
        {3, 4},
        {4, 6},
        {6, 5},
        {5, 2},
        {7, 6},
        {1, 4}
    };

    Graph<String> graph = new UnweightedGraph<>(vertices, edges);
    UnweightedGraph<String>.SearchTree dfs = graph.dfs(graph.getIndex("Business & Technology"));

    java.util.List<Integer> searchOrders = dfs.getSearchOrder();
    System.out.println(dfs.getNumberOfVerticesFound() + " vertices are searched in this DFS order:");
    for (int i = 0; i < searchOrders.size(); i++)
      System.out.print(graph.getVertex(searchOrders.get(i)) + " ");
    System.out.println();

    for (int i = 0; i < searchOrders.size(); i++)
      if (dfs.getParent(i) != -1)
        System.out.println("parent of " + graph.getVertex(i) +
          " is " + graph.getVertex(dfs.getParent(i)));

    System.out.println();
    dfs.printPath(graph.getIndex("Health Technologies Center"));
    System.out.println();
    dfs.printPath(graph.getIndex("Student Services"));
    System.out.println();
    dfs.printPath(graph.getIndex("Recreation Center"));

    System.out.println();
    dfs.printTree();
  }
}
