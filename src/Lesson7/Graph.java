package Lesson7;

import java.util.*;

import java.util.function.Function;

public class Graph {

    private List<Vertex> vertexes;
    private boolean[][] adjMatrix;

    private int size;

    public Graph(int maxSize) {
        vertexes = new ArrayList<>(maxSize);
        adjMatrix = new boolean[maxSize][maxSize];
        size = 0;
    }

    public void addVertex(String label) {
        Vertex vertex = new Vertex(label);
        vertexes.add(vertex);
        size++;
    }

    public boolean addEdge(String labelFrom, String labelTo) {
        Vertex vertexFrom = findVertex(labelFrom);
        Vertex vertexTo = findVertex(labelTo);
        if (vertexFrom == null || vertexTo == null)
            return false;

        addEdge(vertexFrom, vertexTo);
        return true;
    }

    public void display() {
        for (int i = 0; i < size; i++)
            System.out.println(vertexes.get(i));
    }

    private void addEdge(Vertex vertexFrom, Vertex vertexTo) {
        int indexFrom = vertexes.indexOf(vertexFrom);
        int indexTo = vertexes.indexOf(vertexTo);

        adjMatrix[indexFrom][indexTo] = true;
        adjMatrix[indexTo][indexFrom] = true;
    }

    public Vertex findVertex(String label) {
        for (Vertex vertex : vertexes) {
            if (vertex.getLabel().equals(label))
                return vertex;
        }
        return null;
    }

    public void dfs(String startLabel) {
        order(startLabel, new Stack<>(), Stack::peek);
    }

    public void bfs(String startLabel) {
        order(startLabel, new ArrayDeque<>(), Queue::peek);
    }


    public Vertex bfsf(String startLabel, String endLabel) {
        Vertex startVertex = findVertex(startLabel);
        Vertex endVertex = findVertex(endLabel);
        if (startVertex == null) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }
        if (endVertex == null) {
            throw new IllegalArgumentException("Invalid endLabel: " + endLabel);
        }

        Queue<Vertex> queue = new ArrayDeque();
        Vertex currentVertex = startVertex;

        visitVertex(currentVertex, queue);

        while (currentVertex != endVertex) {
            currentVertex = getAdjUnvisitedVertex(queue.peek());
            if (currentVertex == null) {
                queue.remove();
            }
            else {
                visitVertex(currentVertex, queue);
                currentVertex.setPrevious(queue.peek());
            }
        }

        clearVertexes();
        return currentVertex;
    }

    private <T extends Collection<Vertex>> void order(String startLabel,
                                                      T collection,
                                                      Function<T, Vertex> peeker) {
        Vertex vertex = findVertex(startLabel);
        if (vertex == null) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }


        visitVertex(vertex, collection);

        while (!collection.isEmpty()) {
            Vertex currentVertex = peeker.apply(collection);
            vertex = getAdjUnvisitedVertex(currentVertex);
            if (vertex == null) {
                collection.remove(currentVertex);
            }
            else {
                visitVertex(vertex, collection);
            }
        }

        clearVertexes();
    }

    private void clearVertexes() {
        for (int i = 0; i < size; i++) {
            vertexes.get(i).setWasVisited(false);
        }
    }

    private void visitVertex(Vertex vertex, Collection<Vertex> keeper) {
        vertex.setWasVisited(true);
        System.out.println(vertex);
        keeper.add(vertex);
    }


    private void visitVertex(Vertex vertex, Queue<Vertex> queue) {
        vertex.setWasVisited(true);
        queue.add(vertex);
    }

    private Vertex getAdjUnvisitedVertex(Vertex vertex) {
        int startIndex = vertexes.indexOf(vertex);
        for (int i = 0; i < size; i++) {
            if (adjMatrix[startIndex][i] && !vertexes.get(i).isWasVisited()) {
                return vertexes.get(i);
            }
        }
        return null;
    }

    public boolean isLinked(Vertex from, Vertex to) {
        int indexFrom = vertexes.indexOf(from);
        int indexTo = vertexes.indexOf(to);

        return adjMatrix[indexFrom][indexTo];
    }

    public int countOfEdges(Vertex vertex) {
        int index = vertexes.indexOf(vertex);
        int count = 0;
        for (boolean cell: adjMatrix[index]){
            if (cell == true) {
                count++;
            }
        }
        return count;
    }

    public void findShortestWay(String from, String to) {
        Vertex current = bfsf(from, to);
        Vertex startPoint = findVertex(from);
        Stack<Vertex> stack = new Stack<>();
        while (current != startPoint) {
            stack.push(current);
            current = current.getPrevious();
        }
        stack.push(current);
        System.out.println("Кратчайший путь из " + from + " в " + to + ":");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }
}
