/**
 * The Indexlist is the secondary list. It only contains a couple numbers from the primary list.
 * @author Malte
 *
 */
public class Indexlist {

	// obere Liste zum skippen, enthält nur 4 elemente

	int value;
	Indexlist next;
	Elementlist down;
	int abstand;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Indexlist getNext() {
		return next;
	}

	public void setNext(Indexlist next) {
		this.next = next;
	}

	public Elementlist getDown() {
		return down;
	}

	public void setDown(Elementlist down) {
		this.down = down;
	}

	public int getAbstand() {
		return abstand ;
	}

	public void setAbstand() {
		this.abstand = abstand ++;
	}

	public Indexlist() {

		this.value = 0;
		this.next = null;
		this.down = null;
		this.abstand = 1;

	}

	//füge neeues element in der liste hinzu
	public void add(Elementlist newElement) {
		if (down.getValue() > newElement.getValue()) {
			newElement.setNext(down);
			down = newElement;
			value = newElement.getValue();
		} else {
			down.add(newElement);
		}
	}
}