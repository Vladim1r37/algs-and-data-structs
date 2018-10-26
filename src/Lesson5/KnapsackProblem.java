package Lesson5;


public class KnapsackProblem {

    public static void main(String[] args) {


        Item[] list = new Item[5];

        list[0] = new Item("Книга", 1, 600);
        list[1] = new Item("Бинокль", 2, 5000);
        list[2] = new Item("Аптечка", 4, 1500);
        list[3] = new Item("Ноутбук", 10, 40000);
        list[4] = new Item("Котелок", 1, 500);

        MaxCostFinder finder = new MaxCostFinder();
        Item[] maxCostSet = finder.findMaxCostSet(18, list);
        for (int i = 0; i < maxCostSet.length; i++) {
            System.out.println(maxCostSet[i]);
        }


    }
}
