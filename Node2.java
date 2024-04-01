/**
 * Node represents a node in a linked list.
 *
 * @author Java Foundations, mvail, Aris Vetter
 * @version 4.0
 */
public class Node2<E> {
	private Node2<E> next;
    private Node2<E> previous;
	private E element;

	/**
  	 * Creates an empty node.
  	 */
	public Node2() {
		next = null;
		element = null;
        previous = null;
	}

	/**
  	 * Creates a node storing the specified element.
 	 *
  	 * @param elem
  	 *            the element to be stored within the new node
  	 */
	public Node2(E elem) {
		next = null;
		element = elem;
        previous = null;
	}

	/**
 	 * Returns the node that follows this one.
  	 *
  	 * @return the node that follows the current one
  	 */
	public Node2<E> getNext() {
		return next;
	}

	/**
 	 * Sets the node that follows this one.
 	 *
 	 * @param node
 	 *            the node to be set to follow the current one
 	 */
	public void setNext(Node2<E> node) {
		next = node;
	}

	/**
 	 * Returns the element stored in this node.
 	 *
 	 * @return the element stored in this node
 	 */
	public E getElement() {
		return element;
	}

	/**
 	 * Sets the element stored in this node.
  	 *
  	 * @param elem
  	 *            the element to be stored in this node
  	 */
	public void setElement(E elem) {
		element = elem;
	}

    /**
 	 * Returns the node that follows this one.
  	 *
  	 * @return the node that follows the current one
  	 */
	public Node2<E> getPrevious() {
		return previous;
	}

	/**
 	 * Sets the node that is before this one.
 	 *
 	 * @param node
 	 *            the node to be set to before the current one
 	 */
	public void setPrevious(Node2<E> node) {
		previous = node;
	}

	@Override
	public String toString() {
		return "Element: " + element.toString() + " Has next: " + (next != null);
	}
}


