import java.util.AbstractCollection;
import java.util.Iterator;
import static java.lang.StrictMath.floorMod;

public class CircularArrayRing<E> extends AbstractCollection<E> implements Ring<E> {

    private int tail;
    private int count;
    private E[] array;

    /**
     * Default constructor
     */
    CircularArrayRing() {
        tail = count = 0;
        array = (E[]) new Object[10];
    }

    /**
     *
     * @param size
     */
    CircularArrayRing(int size) {
        tail = count = 0;
        array = (E[]) new Object[size];
    }

    @Override
    public boolean add(E e) {
        array[tail] = e;
        tail = floorMod((tail + 1), array.length);

        if (count < array.length) {
            count++;
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        try {
            if (count > 0 && index < count && index >= 0) {
                return array[floorMod((tail - (index + 1)), array.length)];
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public Iterator<E> iterator() {



        return null;

    }

    @Override
    public int size() {
        return count;
    }
}
