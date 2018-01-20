public class GenericDoublyLinkedList<T> {

	/** head of the list */
	private GenericDoublyLinkedListEntry<T> head;

	/**
	 * inserts a values at the end of the list
	 * 
	 * @param value
	 *            value which shall be added
	 */
	public void append(T value) {
		if (head == null) {
			// insert at head
			head = new GenericDoublyLinkedListEntry<T>();
			head.value = value;
			return;
		}
		// find end
		GenericDoublyLinkedListEntry<T> current = head, last = head;
		while (current != null) {
			last = current;
			current = current.next;
		}
		current = new GenericDoublyLinkedListEntry<T>();
		current.value = value;
		current.prev = last;
		last.next = current;
	}

	/**
	 * inserts a value at the head of the list
	 * 
	 * @param value
	 *            value which shall be added
	 */
	public void insertAtHead(T value) {
		if (head == null) {
			head = new GenericDoublyLinkedListEntry<T>();
			head.value = value;
			return;
		}
		GenericDoublyLinkedListEntry<T> newHead = new GenericDoublyLinkedListEntry<T>();
		newHead.value = value;
		newHead.next = head;
		head.prev= newHead;
		head = newHead;
	}

	/**
	 * inserts a value after the entry with the value "after" or at the end of
	 * the list if the value is not contained
	 * 
	 * @param value
	 *            value which shall be added
	 * @param after
	 *            desired predecessor for value
	 */
	public void insertAfter(T value, T after) {
		if (head == null) {
			head = new GenericDoublyLinkedListEntry<T>();
			head.value = value;
			return;
		}
		GenericDoublyLinkedListEntry<T> newone = new GenericDoublyLinkedListEntry<T>();
		newone.value = value;
		GenericDoublyLinkedListEntry<T> current = head;
		while (current.next != null && current.value != after)
			current = current.next;
		GenericDoublyLinkedListEntry<T> temp = current.next;
		current.next = newone;
		newone.prev = current;
		newone.next = temp;
	}

	/**
	 * 
	 * 
	 * @param position
	 * @return the value at position "position" or null if the list has less
	 *         entries
	 */
	public Object getValue(int position) {
		int counter = 0;
		GenericDoublyLinkedListEntry<T> current = head;
		while (current != null && position != counter++)
			current = current.next;
		if (current == null)
			return null;
		else
			return current.value;
	}

	/**
	 * deletes the specified value if contained in this list. Note: this method
	 * uses reference comparison, not equals()!
	 * 
	 * @param value
	 */
	public void deleteValue(T value) {
		if (head == null)
			return; // empty list
		GenericDoublyLinkedListEntry<T> current = head, last = head;
		if (current.value == value) {
			// it's the head element
			head = head.next;
			return;
		}
		while (current.next != null && current.value != value) {
			last = current;
			current = current.next;
		}
		if (current.value != value)
			return; // not in this list
		last.next = current.next;
		if (current.next!=null)
		current.next.prev= last;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		GenericDoublyLinkedListEntry<T> current = head;
		if (current == null)
			return "[]";
		String res = "[";
		while (current != null && current.next != null) {
			res += current.value + ",";
			current = current.next;
		}
		res += current.value + "]";
		return res;
	}
	
}
