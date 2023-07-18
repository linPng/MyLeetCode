import java.util.Iterator;
import java.util.NoSuchElementException;

public class demo284 {
    //顶端迭代器
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer nextElement;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            if (iterator.hasNext()) {
                nextElement = iterator.next();
            }
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return nextElement;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Integer currentElement = nextElement;
            nextElement = iterator.hasNext() ? iterator.next() : null;
            return currentElement;
        }

        @Override
        public boolean hasNext() {
            return nextElement != null;
        }
    }
    public static void main(String[] args) {

    }
}
