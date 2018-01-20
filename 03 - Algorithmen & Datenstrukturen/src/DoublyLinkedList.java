public class DoublyLinkedList {

	/** head of the list */
	private DoublyLinkedListEntry head;

	/**
	 * inserts a values at the end of the list
	 * 
	 * @param value
	 *            value which shall be added
	 */
	public void append(Object value) {
		if (head == null) {
			// insert at head
			head = new DoublyLinkedListEntry();
			head.value = value;
			return;
		}
		// find end
		DoublyLinkedListEntry current = head, last = head;
		while (current != null) {
			last = current;
			current = current.next;
		}
		current = new DoublyLinkedListEntry();
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
	public void insertAtHead(Object value) {
		if (head == null) {
			head = new DoublyLinkedListEntry();
			head.value = value;
			return;
		}
		DoublyLinkedListEntry newHead = new DoublyLinkedListEntry();
		newHead.value = value;
		newHead.next = head;
		head.prev = newHead;
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
	public void insertAfter(Object value, Object after) {
		if (head == null) {
			head = new DoublyLinkedListEntry();
			head.value = value;
			return;
		}
		DoublyLinkedListEntry newone = new DoublyLinkedListEntry();
		newone.value = value;
		DoublyLinkedListEntry current = head;
		while (current.next != null && current.value != after)
			current = current.next;
		DoublyLinkedListEntry temp = current.next;
		current.next = newone;
		newone.prev = current;
		newone.next = temp;
		if (current.next != null) {
			temp.prev = newone;
		}
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
		DoublyLinkedListEntry current = head;
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
	public void deleteValue(Object value) {
		if (head == null)
			return; // empty list
		DoublyLinkedListEntry current = head, last = head;
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
		if (current.next != null)
			current.next.prev = last;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		DoublyLinkedListEntry current = head;
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
