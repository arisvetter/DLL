import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IUDoubleLinkedList<T> implements IndexedUnsortedList<T> {
    private Node2<T> head, tail;
    private int size;
    private int modCount;

    public IUDoubleLinkedList() {
        size = 0;
        modCount = 0;
        head = null;
        tail = null;
    }

    @Override
    public void addToFront(T element) {
        ListIterator<T> lit = listIterator();
        lit.add(element);
    }

    @Override
    public void addToRear(T element) {

        add(size, element);

        /*
         * HAD HIGHER NUMBER TESTS PASSING
         * Node2<T> newNode = new Node2<T>(element);
         * if (isEmpty()) {
         * tail = newNode;
         * } else {
         * tail.setNext(newNode);
         * Node2<T> prevNode = new Node2<T>(tail.getElement());
         * tail = newNode;
         * tail.setPrevious(prevNode);
         * }
         * size++;
         * modCount++;
         */
    }

    @Override
    public void add(T element) {
        add(size, element);
    }

    @Override
    public void addAfter(T element, T target) {

        ListIterator<T> lit = listIterator();
        boolean found = false;
        while (lit.hasNext() && !found) {
            if (lit.next().equals(target)) {
                found = true;
                lit.add(element);
            }
        }

        if (!found) {
            throw new NoSuchElementException();
        }
        /*
         * slightly higher
         * boolean found = false;
         * Node2<T> current = head;
         * while (current != null && !found) {
         * if (target.equals(current.getElement())) {
         * found = true;
         * } else {
         * current = current.getNext();
         * }
         * }
         * if (!found) {
         * throw new NoSuchElementException();
         * } else if (current != tail) {
         * Node2<T> afterNode = current.getNext();
         * 
         * Node2<T> newNode = new Node2<T>(element);
         * afterNode.setPrevious(newNode);
         * newNode.setNext(afterNode);
         * current.setNext(newNode);
         * newNode.setPrevious(current);
         * } else {
         * Node2<T> newNode = new Node2<T>(element);
         * tail.setNext(newNode);
         * newNode.setPrevious(tail);
         * tail = newNode;
         * }
         * 
         * size++;
         * modCount++;
         */
    }

    @Override
    public void add(int index, T element) {

        ListIterator<T> lit = listIterator(index);
        lit.add(element);
    }

    @Override
    public T removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListIterator<T> lit = listIterator();
        T retVal = lit.next();
        lit.remove();
        return retVal;

    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return remove(size - 1);
        /*ListIterator<T> lit = listIterator(size);
        T retNode = lit.previous();
        lit.remove();
        return retNode;*/
    }

    @Override
    public T remove(T element) {

        ListIterator<T> lit = listIterator();
        boolean foundIt = false;
        T retVal = null;
        while (lit.hasNext() && !foundIt) {
            retVal = lit.next();
            if (retVal.equals(element)) {
                foundIt = true;
                lit.remove();
            }
        }

        if (!foundIt) {
            throw new NoSuchElementException();
        }
        return retVal;
    }

    @Override
    public T remove(int index) {
        
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        ListIterator<T> lit = listIterator(index);
        T retNode = lit.next();
        lit.remove();
        return retNode;
    }

    @Override
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        ListIterator<T> lit = listIterator(index);
        lit.next();
        lit.set(element);
    }

    @Override
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        ListIterator<T> lit = listIterator(index);
        return lit.next();
    }

    @Override
    public int indexOf(T element) {

        /* 
        ListIterator<T> lit = listIterator();
        boolean foundIt = false;
        int indexCount = 0;
        T current = null;
        while (lit.hasNext() && !foundIt) {
            current = lit.next();
            indexCount++;
            if (current.equals(element)) {
                foundIt = true;
            }
        }
        return indexCount;*/
        
        
        boolean found = false;
        Node2<T> current = head;
        int i = 0;
        while (current != null && !found) {
            if (element.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
                i++;
            }
        }

        // if element is never found
        if (!found) {
            return -1;
        }
        return i;
    }

    @Override
    public T first() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return head.getElement();
    }

    @Override
    public T last() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return tail.getElement();
    }

    @Override
    public boolean contains(T target) {
        boolean found = false;
        Node2<T> current = head;
        while (current != null && !found) {
            if (target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }
        }
        return found;
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
    public Iterator<T> iterator() {
        return new DLLIterator();
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DLLIterator();
    }

    @Override
    public ListIterator<T> listIterator(int startingIndex) {
        // TODO Auto-generated method stub
        return new DLLIterator(startingIndex);

    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[");
        Node2<T> current = head;
        while (current != null) {
            str.append(current.getElement().toString());
            str.append(", ");
            current = current.getNext();
        }
        if (!isEmpty()) {
            str.delete(str.length() - 2, str.length());
        }
        str.append("]");
        return str.toString();
    }

    /** Acts as both a basic Iterator and a ListIterator for IUDLL. */
    private class DLLIterator implements ListIterator<T> {

        private int nextIndex;
        private int iterModCount;
        private Node2<T> nextNode;
        private Node2<T> prevReturnedNode;

        public DLLIterator() {
            this(0);
        }

        public DLLIterator(int startingIndex) {
            if ((startingIndex < 0) || (startingIndex > size)) {
                throw new IndexOutOfBoundsException();
            }

            //to keep track of iterator concurrency
            iterModCount = modCount;

            if ((size / 2) < startingIndex) {
                nextNode = tail;
                for (int i = size; i > startingIndex - 1; i--) {
                    nextNode = nextNode.getPrevious();
                }

            } else {
                nextNode = head;
                for (nextIndex = 0; nextIndex < startingIndex; nextIndex++) {
                    nextNode = nextNode.getNext();
                }
            }
            nextIndex = startingIndex;

            prevReturnedNode = null;
        }

        @Override
        public boolean hasNext() {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (nextNode != null);
        }

        @Override
        public T next() {
            //if the iterator is at the end of the list
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            prevReturnedNode = nextNode;
            nextNode = nextNode.getNext();
            nextIndex++;
            return prevReturnedNode.getElement();
        }

        @Override
        public void remove() {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }

            //if not following next, previous, or set
            if (prevReturnedNode == null) {
                throw new IllegalStateException();
            }

            if (size == 1){
                head = tail = null;
            } else if (prevReturnedNode == head){
                head = prevReturnedNode.getNext();
                head.setPrevious(null);
            } else if (prevReturnedNode == tail){
                tail = prevReturnedNode.getPrevious();
                tail.setNext(null);
            } else {
                prevReturnedNode.getPrevious().setNext(prevReturnedNode.getNext());
                prevReturnedNode.getNext().setPrevious(prevReturnedNode.getPrevious());
            }


            // if last call was to next, removing node to the left
            if (prevReturnedNode != nextNode) {
                nextIndex--;
            } else {
                nextNode = nextNode.getNext();
            }

            //updates the modCounts, index, size, and ensures remove/set cannot be called next
            modCount++;
            iterModCount++;
            size--;
            prevReturnedNode = null;
        }

        @Override
        public boolean hasPrevious() {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (nextNode != head);
        }

        @Override
        public T previous() {
            //this eliminates the iterator being before the first node
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }

            //if the iterator is after the tail, previous will be the tail
            if (nextNode == null) {
                nextNode = tail;
            } else {
                nextNode = nextNode.getPrevious();
            }

            //update the nextIndex
            nextIndex--;

            //so that the iterator can remove/set following previous
            prevReturnedNode = nextNode;
            return nextNode.getElement();

        }

        @Override
        public int nextIndex() {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return nextIndex;
        }

        @Override
        public int previousIndex() {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return nextIndex - 1;
        }

        @Override
        public void set(T e) {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            
            if (prevReturnedNode == null) {
                throw new IllegalStateException();
            }

            prevReturnedNode.setElement(e);

            //updates the mod count, and no need to set prevReturnedNode to null
            iterModCount++;
            modCount++;
        }

        @Override
        public void add(T e) {
            if (iterModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            Node2<T> newNode = new Node2<T>(e);

            //if the list has no elements
            if (isEmpty()) {
                head = tail = newNode;

            //if the iterator is at the end
            } else if (nextNode == null){
                tail.setNext(newNode);
                newNode.setPrevious(tail);
                tail = newNode;

            //if adding to the beginning
            } else if (nextNode == head){
                newNode.setNext(head);
                head.setPrevious(newNode);
                head = newNode;

            //all other cases
            } else {
                newNode.setPrevious(nextNode.getPrevious());
                nextNode.getPrevious().setNext(newNode);
                newNode.setNext(nextNode);
                nextNode.setPrevious(newNode);

            }
            
            //updates the modCounts, index, size, and ensures remove/set cannot be called next
            nextIndex++;
            iterModCount++;
            modCount++;
            size++;
            prevReturnedNode = null;
        }
    }

}
