package Lesson8;

public class Main8 {
    public static void main(String[] args) {
        HashTable table = new HashTable(10);

        Item item1 = new Item(3);
        Item item2 = new Item(23);
        Item item3 = new Item(17);
        Item item4 = new Item(37);
        Item item5 = new Item(15);

        table.insert(item1);
        table.insert(item2);
        table.insert(item3);
        table.insert(item4);
        table.insert(item5);


        table.display();

        System.out.println("Find 15: " + table.find(15));
        System.out.println("Find 23: " + table.find(23));
        System.out.println("Find 50: " + table.find(50));

        table.remove(23);
        System.out.println();

        table.display();

    }
}
