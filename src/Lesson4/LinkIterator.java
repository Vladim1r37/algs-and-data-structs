package Lesson4;

import java.util.Iterator;

public class LinkIterator implements Iterator {

    private Link current;
    private Link previous;
    private SimpleLinkedListImpl list;

    public LinkIterator(SimpleLinkedListImpl list) {
        this.list = list;
        this.reset();
    }

    private void reset() {
        current = list.getFirstElement();
        previous = null;
    }

    public boolean atEnd() {
        return current.getNext() == null;
    }

    public void nextLink() {
        previous = current;
        current = current.getNext();
    }

    public Link getCurrent() {
        Link temp = current;
        current = current.getNext();
        return temp;
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
            nextLink();
        }
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
            if (atEnd())
                reset();
            else
                current = current.getNext();
        }

        return value;
    }

    @Override
    public boolean hasNext() {
        return current.getNext() != null;
    }

    @Override
    public Object next() {
        return null;
    }
}
