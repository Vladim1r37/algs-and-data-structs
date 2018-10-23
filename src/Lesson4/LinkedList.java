package Lesson4;

public interface LinkedList extends Iterable<Link> {

    void add(int value);

    Link remove();

    boolean isEmpty();

    int getSize();

    Link search(int value);

    Link remove(int value);

    void display();

    Link getFirstElement();

    void setFirstElement(Link firstElement);
}
