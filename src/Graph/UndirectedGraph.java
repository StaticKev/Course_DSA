package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
//    int[][] adjMatrix;
    LinkedList<Integer>[] adjList;

    public Graph(int nodes) {
//        this.adjMatrix = new int[nodes][nodes];
        this.adjList = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            this.adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v1, int v2) {
//        this.adjMatrix[v1][v2] = 1;
//        this.adjMatrix[v2][v1] = 1;
        this.adjList[v1].add(v2);
        this.adjList[v2].add(v1);
    }

    // Ini litereli level order traversal
    public void bfs(int vertice) {
        boolean[] visited = new boolean[adjList.length]; // Ditambahin ini soalnya undirected graph
        Queue<Integer> queue = new LinkedList<>();
        visited[vertice] = true;
        queue.offer(vertice);
        while (!queue.isEmpty()) {
            int currVertice = queue.poll();
            System.out.println(currVertice + " ");
            for (int visitedVertice : adjList[currVertice]) {
                if (!visited[visitedVertice]) {
                    visited[visitedVertice] = true;
                    queue.offer(visitedVertice);
                }
            }
        }
    }

    // Iterative
//    public void dfs(int vertice) {
//        boolean[] visited = new boolean[adjList.length];
//        Stack<Integer> stack = new Stack<>();
//        stack.push(vertice);
//        while (!stack.isEmpty()) {
//            int v1 = stack.pop();
//            if (!visited[v1]) {
//                visited[v1] = true;
//                System.out.println(v1 + " ");
//                for (int v2 : adjList[v1]) {
//                    stack.push(v2);
//                }
//            }
//        }
//    }

    // Recursive
    public void dfs(int vertice) {
        boolean[] visited = new boolean[adjList.length];
        for (int v = 0; v < adjList.length; v++) {
            if (!visited[v]) {
                dfs(v, visited);
            }
        }
    }

    public void dfs(int vertice, boolean[] visited) {
        visited[vertice] = true;
        System.out.println(vertice + " ");
        for (int w : adjList[vertice]) {
            if (!visited[w]) {
                dfs(w, visited);
            }
        }
    }

}

public class UndirectedGraph {

    public static void main(String[] args) {
        Graph g = new Graph(5);

        System.out.println(g);

        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(3, 4);
        g.addEdge(4, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 0);

        g.dfs(0);
    }

}
