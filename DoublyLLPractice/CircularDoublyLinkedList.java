import java.util.NoSuchElementException;

/**
 * Your implementation of a CircularDoublyLinkedList
 *
 * @author CONGYAO ZHENG
 * @version 1.0
 */
public class CircularDoublyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    /**
     * Creates an empty circular doubly-linked list.
     */
    public CircularDoublyLinkedList() {
        head = new LinkedListNode<>(null, head, head);
        size = 0;
    }

    /**
     * Creates a circular doubly-linked list with
     * {@code data} added to the list in order.
     * @param data The data to be added to the LinkedList.
     * @throws java.lang.IllegalArgumentException if {@code data} is null or any
     * item in {@code data} is null.
     */
    public CircularDoublyLinkedList(T[] data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        if (data[0] == null) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                throw new IllegalArgumentException("Illegal Argument");
            } else {
                addToBack(data[i]);
            }
        }
    }

    @Override
    public void addAtIndex(int index, T data) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument");
        }
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        } else if (index == 0) {
            addToFront(data);
        } else if (index == size) {
            addToBack(data);
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            LinkedListNode<T> prev = current.getPrevious();
            prev.setNext(newNode);
            current.setPrevious(newNode);
            newNode.setNext(current);
            newNode.setPrevious(prev);
            size++;
        }

    }

    @Override
    public T get(int index) {
        LinkedListNode<T> current = head;
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        } else if (index == 0) {
            current = head;
        } else if (index == size - 1) {
            current = head.getPrevious();
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        }
        return current.getData();
    }


    @Override
    public T removeAtIndex(int index) {
        LinkedListNode<T> current = head;
        LinkedListNode<T> tail = head.getPrevious();
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        } else if (index == 0) {
            T data = head.getData();
            removeFromFront();
            return data;
        } else if (index == size - 1) {
            T data = tail.getData();
            removeFromBack();
            return data;
        } else {
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            T data = current.getNext().getData();
            LinkedListNode<T> newNext = current.getNext().getNext();
            current.setNext(newNext);
            newNext.setPrevious(current);
            size--;
            return data;
        }
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(head);
            head.setPrevious(head);
            size++;
        } else if (size == 1) {
            head.setPrevious(newNode);
            head.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrevious(head);
            head = newNode;
            size++;
        } else {
            LinkedListNode<T> tail = head.getPrevious();
            head.setPrevious(newNode);
            tail.setNext(newNode);
            newNode.setNext(head);
            newNode.setPrevious(tail);
            head = newNode;
            size++;
        }
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument");
        }
        LinkedListNode<T> newNode = new LinkedListNode<T>(data);
        if (isEmpty()) {
            head = newNode;
            head.setNext(head);
            head.setPrevious(head);
            size++;
        } else if (size == 1) {
            head.setNext(newNode);
            head.setPrevious(newNode);
            newNode.setNext(head);
            newNode.setPrevious(head);
            size++;
        } else {
            LinkedListNode<T> tail = head.getPrevious();
            head.setPrevious(newNode);
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            newNode.setNext(head);
            size++;
        }
    }

    @Override
    public T removeFromFront() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = head.getData();
            head = null;
            size--;
            return data;
        } else {
            T data = head.getData();
            LinkedListNode<T> tail = head.getPrevious();
            LinkedListNode<T> trail = head.getNext();
            trail.setPrevious(tail);
            tail.setNext(trail);
            head = trail;
            size--;
            return data;
        }
    }

    @Override
    public T removeFromBack() {
        LinkedListNode<T> tail = head.getPrevious();
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T data = head.getData();
            size--;
            return data;
        } else {
            T data = tail.getData();
            head.setPrevious(tail.getPrevious());
            tail.getPrevious().setNext(head);
            size--;
            return data;
        }

    }

    @Override
    public int removeFirstOccurrence(T data) {
        LinkedListNode<T> current = head;
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument");
        }
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                if (i == 0) {
                    removeFromFront();
                } else if (i == size - 1) {
                    removeFromBack();
                } else {
                    LinkedListNode<T> newNext = current.getNext().getNext();
                    current.setNext(newNext);
                    newNext.setPrevious(current);
                    size--;
                }
                return i;
            }
            current = current.getNext();
        }
        throw new NoSuchElementException("No such element");
    }

    @Override
    public boolean removeAllOccurrences(T data) {
        LinkedListNode<T> current = head;
        Boolean r = false;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(data)) {
                if (i == 0) {
                    head = head.getNext();
                }
                current.getNext().setPrevious(current.getPrevious());
                current.getPrevious().setNext(current.getNext());
                size--;
                i--;
                r = true;
            }
            current = current.getNext();
        }
        return r;
    }

    @Override
    public Object[] toArray() {
        LinkedListNode<T> current = head;
        Object[] nodeArray = new Object[size];
        for (int i = 0; i < size; i++) {
            nodeArray[i] = current.getData();
            current = current.getNext();
        }
        return nodeArray;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;

    }

    /* DO NOT MODIFY THIS METHOD */
    @Override
    public LinkedListNode<T> getHead() {
        return head;
    }
}
