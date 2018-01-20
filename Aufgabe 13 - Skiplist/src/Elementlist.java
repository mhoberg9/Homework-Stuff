/**
 * This class is the primary list with all numbers. It contains the values and the position of his neighbour.
 * 
 * @author Malte
 *
 */
public class Elementlist {

	// untere Liste mit allen Werten

	int value;
	Elementlist next;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Elementlist getNext() {
		return next;
	}

	public void setNext(Elementlist next) {
		this.next = next;
	}

	/**
	 * COnstructor
	 * 
	 * @param value
	 */

	public Elementlist(int value) {
		this.value = value;
		this.next = null;

	}

	public void add(Elementlist newElement) {
		Elementlist temp = this; // zeigt auf das erste Object
		Elementlist temp2 = null; // zeigt auf nachbarn links daneben
		while (temp.getNext() != null && temp.getValue() <= newElement.getValue()) { // verschiebt
																						// sich
																						// solange
																						// bis
																						// der
																						// Wert
																						// kleiner
																						// als
																						// sein
																						// rechter
																						// nachbar
																						// ist
			temp2 = temp; // verweis auf linken nachbarn wird geändert zu
							// aktuellen verweis
			temp = temp.getNext(); // verweis von aktuellen verweis wird zu
									// verweis von rechten nachbarn nach links
		}
		temp2.setNext(newElement);
		newElement.setNext(temp);

	}
	
	
	// gehört zu skiplist getter methode 
	
	public Elementlist getElementlist(int i){
		if (i == 0){
			return this;
			
		// gehe ein schritt zurück und nehme den verweis auf den nöchsten wert als return
			
		}else {
			i--;
			return this.next.getElementlist(i);
		}
	}
	
	
}
