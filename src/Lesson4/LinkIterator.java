package Lesson4;

import java.util.Iterator;

public class LinkIterator implements Iterator<Link> {

    private Link current;
    private Link previous;
    private LinkedList list;
    private boolean firstIterate = true;

    public LinkIterator(LinkedList list) {
        this.list = list;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(int value) {
        Link newLink = new Link(value);
        if (list.isEmpty()) {
            list.setFirstElement(newLink);
            current = newLink;
        }
        else {
            newLink.setNext(current.getNext());
            current.setNext(newLink);
            next();
        }
    }

    public void reset(){
        firstIterate = false;
        current = list.getFirstElement();
        previous = null;
    }

    public void insertBefore(int value) {
        Link newLink = new Link(value);
        if (previous == null) {
            newLink.setNext(list.getFirstElement());
            list.setFirstElement(newLink);
            reset();
        }
        else {
            newLink.setNext(previous.getNext());
            previous.setNext(newLink);
            current = newLink;
        }
    }

    public int deleteCurrent() {
        int value = current.getData();
        if (previous == null) {
            list.setFirstElement(current.getNext());
            reset();
        }
        else {
            previous.setNext(current.getNext());
            if (!hasNext())
                reset();
            else
                current = current.getNext();
        }

        return value;
    }

    @Override
    public boolean hasNext() {
        if (firstIterate) {
            firstIterate = false;
            return list.getFirstElement() != null;
        }
        else
            return current.getNext() != null;
    }

    @Override
    public Link next() {
        if (current == null)
            current = list.getFirstElement();
        else {
            previous = current;
            current = current.getNext();
        }
        return current;
    }
}
