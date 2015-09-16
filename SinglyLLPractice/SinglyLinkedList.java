import java.util.NoSuchElementException;

/**
 * Your implementation of a SinglyLinkedList
 *
 * @author Congyao Zheng
 * @version 1.0
 */
public class SinglyLinkedList<T> implements LinkedListInterface<T> {

    // Do not add new instance variables.
    private LinkedListNode<T> head;
    private int size;

    @Override
    public void addAtIndex(int index, T data) {
        LinkedListNode<T> newNode = new LinkedListNode<>(data);
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        } else if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        } else if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            size++;
        } else {
            LinkedListNode<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }

    }

    @Override
    public T get(int index) {
        LinkedListNode<T> current = head;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds");
        } else {
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        }
        return current.getData();
    }

    @Override
    public T removeAtIndex(int index) {
        LinkedListNode<T> current = getHead();
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of Bounds");
        }
        if (index == 0) {
            T data = head.getData();
            head = head.getNext();
            size--;
            return data;
        }
        for (int i = 0; i < index - 1; i++) {
            current = current.getNext();
        }
        T data = current.getNext().getData();
        current.setNext(current.getNext().getNext());
        size--;
        return data;
    }

    @Override
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        head = new LinkedListNode<T>(data, head);
        size++;
    }

    @Override
    public void addToBack(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        }
        LinkedListNode<T> newIndex = new LinkedListNode<T>(data);
        if (head == null) {
            head = newIndex;
            size++;
        } else {
            LinkedListNode<T> current = getHead();
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newIndex);
            size++;
        }
    }

    @Override
    public T removeFromFront() {
        if (isEmpty()) {
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        size--;
        return data;
    }

    @Override
    public T removeFromBack() {
        if (isEmpty()) {
            return null;
        }
        if (size == 1) {
            T dat = head.getData();
            head = null;
            size--;
            return dat;
        }
        LinkedListNode<T> current = getHead();
        for (int i = 0; i < size - 2; i++) {
            current = current.getNext();
        }
        T data = current.getNext().getData();
        current.setNext(null);
        size--;
        return data;
    }

    @Override
    public int removeFirstOccurrence(T data) {
        LinkedListNode<T> current = getHead();
        if (data == null) {
            throw new IllegalArgumentException("Illegal Argument Exception");
        }
        int count = 0;
       /* for (int i = 0; i < size; i++) {
            if (current.getData() == data){
                count++;
            }
            if (count == 0) {
                */
        for (int i = 0; i < size; i++) {
            if (current.getData() == data) {
                removeAtIndex(count);
                return count;
            }
            count++;
            current = current.getNext();
        }
        throw new NoSuchElementException("No Such Element Exception");
    }

    @Override
    public Object[] toArray() {
        LinkedListNode<T> current = getHead();
        Object[] nodeArray = new Object[size];
        for (int i = 0; i < size; i++) {
            if (current != null) {
                nodeArray[i] = current.getData();
                current = current.getNext();
            }
        }
        return nodeArray;
    }

    @Override
    public boolean isEmpty() {
        return head == null;

    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public LinkedListNode<T> getHead() {
        // DO NOT MODIFY!
        return head;
    }
}



