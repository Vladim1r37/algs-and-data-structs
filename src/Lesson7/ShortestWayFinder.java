package Lesson7;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class ShortestWayFinder {
    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва", "Рязань");
        graph.addEdge("Москва", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Калуга", "Орел");
        graph.addEdge("Липецк", "Воронеж");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdge("Орел", "Курск");
        graph.addEdge("Саратов", "Воронеж");
        graph.addEdge("Курск", "Воронеж");

        graph.bfs("Москва");

        System.out.println();
        findShortestWay("Москва", "Воронеж", graph);
        System.out.println();
        findShortestWay("Тула", "Саратов", graph);
        System.out.println();
        findShortestWay("Орел", "Липецк", graph);


    }

    public static void findShortestWay(String from, String to, Graph graph) {
        // список из метода bfsf() содержит обход в ширину, разделенный на шаги
        ArrayList<ArrayList<Vertex>> bfsfArrays = graph.bfsf(from, to);
        Vertex startVertex = graph.findVertex(from);

        // вычисляю количество ребер начальной точки
        int startPointEdges = graph.countOfEdges(startVertex);

        // создаю список для хранения всех возможных путей между from и to
        ArrayList<ArrayDeque<Vertex>> ways = new ArrayList<>();

        // добавление в каждый из путей начальной точки
        for (int i = 0; i < startPointEdges; i++) {
            ways.add(new ArrayDeque<>());
            ways.get(i).add(startVertex);
        }
        Vertex currentVertex = startVertex;

        // обход каждого из путей
        for (ArrayDeque<Vertex> way : ways) {
            for (ArrayList<Vertex> step : bfsfArrays) {
                for (int i = 0; i < step.size(); i++) {

                    // если в шаге есть вершина, связанная с currentVertex, забираю ее в way
                    if (graph.isLinked(currentVertex, step.get(i))) {
                        way.add(step.remove(i));
                        currentVertex = way.getLast();
                        break;
                    }
                }
            }
            currentVertex = startVertex;
        }

        for (ArrayDeque<Vertex> way : ways) {
            if (way.getLast() == graph.findVertex(to)) {
                System.out.println("Кратчайший путь из " + from + " в " + to + ":");
                while (way.size() > 0) {
                    System.out.println(way.poll());
                }
            }
        }
    }
}
