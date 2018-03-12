import java.util.NoSuchElementException;

public class CircularArrayQueue implements MyQueue {

    private int head;
    private int tail;
    private int count;
    private Integer[] array;

    /**
     * Default constructor
     */
    CircularArrayQueue() {
        array = new Integer[10];
        head = tail = count = 0;
    }

    int getCapacityLeft() {
        return array.length - count;
    }

    @Override
    public void enqueue(int element) {
        if (array.length == count) {
            resize();
        }
        array[tail] = element;
        tail = (tail + 1) % array.length;
        count++;
    }

    @Override
    public int dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        int element = array[head];
        array[head] = null;

        head = (head + 1) % array.length;
        count--;

        return element;
    }

    private void resize() {
        Integer[] newArray = new Integer[array.length * 2];

        for (int i = 0; i < count; i++) {
            newArray[i] = array[head];
            head = (head + 1) % array.length;
        }

        head = 0;
        tail = count;
        array = newArray;
    }

    @Override
    public int noItems() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }
}
