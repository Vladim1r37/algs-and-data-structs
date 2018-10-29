package Lesson6;

import java.util.Random;


public class TreeBuilder {
    public static void main(String[] args) {
        Random rnd = new Random();
        TreeImpl[] treeArr = new TreeImpl[20];
        for (int i = 0; i < 20; i++) {
            treeArr[i] = new TreeImpl();
            for (int j = 0; j < 63; j++) {
                if (getTreeDepth(treeArr[i].getRoot(), 0) <= 4) {
                    int rndInt;
                    do {
                        rndInt = rnd.nextInt(41) - 20;
                    } while (treeArr[i].find(rndInt) != null);
                    treeArr[i].add(rndInt);
                    if (getTreeDepth(treeArr[i].getRoot(), 0) == 5) {
                        treeArr[i].remove(rndInt);
                        break;
                    }
                }

            }
        }

        int countOfBalanced = 0;

        for (TreeImpl tree : treeArr) {
            tree.display();
            System.out.println(isBalanced(tree.getRoot()));
            if (isBalanced(tree.getRoot()))
                countOfBalanced++;
        }

        System.out.println("Количество сбалансированных деревьев в массиве: "
                + countOfBalanced * 100 / treeArr.length + "%");


    }

    private static int getTreeDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        else return Math.max(getTreeDepth(root.getRightChild(), depth + 1), getTreeDepth(root.getLeftChild(), depth+1));
    }

    private static Boolean isBalanced(Node node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                isBalanced(node.getRightChild()) &&
                Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;

    }
    private static int height (Node node) {
        return node == null ? 0 : 1 + Math.max(height(node.getRightChild()), height(node.getLeftChild()));
    }
}