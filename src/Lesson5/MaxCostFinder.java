package Lesson5;

import java.util.LinkedList;

public class MaxCostFinder {

    int currentWeight;
    int currentCost;
    int maxWeight;
    int maxCost;
    Item[] maxCostSet;
    LinkedList<Item> currentSet;


    public MaxCostFinder() {
        this.currentSet = new LinkedList<>();
    }

    public Item[] findMaxCostSet(int maxWeight, Item[] list) {
        this.maxWeight = maxWeight;
        maxCostSet(list);
        return maxCostSet;
    }

    public   void maxCostSet(Item[] list) {
        for (int i = 0; i < list.length; i++){
            if (list[i].getWeight() + currentWeight <= maxWeight) {
                currentSet.push(list[i]);
                currentWeight += list[i].getWeight();
                currentCost += list[i].getCost();
                maxCostSet(list);
                currentSet.pop();
                currentWeight -= list[i].getWeight();
                currentCost -= list[i].getCost();
            }
        }
        if (currentCost > maxCost) {
            maxCost = currentCost;
            maxCostSet = new Item[currentSet.size()];
            currentSet.toArray(maxCostSet);
        }
    }

}