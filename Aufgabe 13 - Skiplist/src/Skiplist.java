import Prog1Tools.IOTools;

/**
 * Skiplist contains methods to build a list. It contains the start and the end of the Skiplist as well as the lenght.
 * @author Malte 03/01/2015
 */

public class Skiplist {

	// gesamte Liste

	//länge & kopf der liste
	int laenge;
	Indexlist key;

	/**
	 * getters & setters
	 * 
	 */

	int maximal = 1;

	public int getLaenge() {
		return laenge;
	}

	public void setLaenge(int laenge) {
		this.laenge = laenge;
	}

	public Indexlist getKey() {
		return key;
	}

	public void setKey(Indexlist key) {
		this.key = key;
	}

	/**
	 * Constructor for Skiplist
	 */

	public Skiplist() {

		// Alle Objecte für die erste Liste erstellt

		laenge = 0;
		Indexlist p1 = new Indexlist();
		Indexlist p2 = new Indexlist();
		Indexlist p3 = new Indexlist();
		Indexlist p4 = new Indexlist();

		// Verbindung zwischen den Elementen

		key = p1;
		p1.setNext(p2);
		p2.setNext(p3);
		p3.setNext(p4);
		p4.setNext(null);
	}

	/**
	 * The method add is used to add new numbers to the list.
	 * @param number
	 */
	
	public void add(int number) {

		Elementlist newElement = new Elementlist(number);
		if (laenge == 0) {

			// setzte verweis auf neues elemnt in elementlist
			key.setDown(newElement);
			key.getNext().setDown(newElement);
			key.getNext().getNext().setDown(newElement);
			key.getNext().getNext().getNext().setDown(newElement);

			
			//setzte alle value von index auf das value vom element
			key.setValue(number);
			key.getNext().setValue(number);
			key.getNext().getNext().setValue(number);
			key.getNext().getNext().getNext().setValue(number);

			laenge++;

		} else if (laenge == 1) {
			
			key.setDown(newElement);
			key.getNext().setDown(key.getDown().getNext());
			key.getNext().getNext().setDown(key.getDown().getNext());
			key.getNext().getNext().getNext().setDown(key.getDown().getNext());

			key.setValue(number);
			key.getNext().setValue(key.getDown().getNext().getValue());
			key.getNext().getNext().setValue(key.getDown().getNext().getValue());
			key.getNext().getNext().getNext().setValue(key.getDown().getNext().getValue());
			laenge++;
		} else if (laenge == 2) {
			key.setDown(newElement);
			key.getNext().setDown(key.getDown().getNext().getNext());
			key.getNext().getNext().setDown(key.getDown().getNext().getNext());
			key.getNext().getNext().getNext().setDown(key.getDown().getNext().getNext());

			key.setValue(number);
			key.getNext().setValue(key.getDown().getNext().getNext().getValue());
			key.getNext().getNext().setValue(key.getDown().getNext().getNext().getValue());
			key.getNext().getNext().getNext().setValue(key.getDown().getNext().getNext().getValue());
			laenge++;
		} else if (laenge == 3) {
			key.setDown(newElement);
			key.getNext().setDown(key.getDown().getNext().getNext().getNext());
			key.getNext().getNext().setDown(key.getDown().getNext().getNext().getNext());
			key.getNext().getNext().getNext().setDown(key.getDown().getNext().getNext().getNext());

			key.setValue(number);
			key.getNext().setValue(key.getDown().getNext().getNext().getNext().getValue());
			key.getNext().getNext().setValue(key.getDown().getNext().getNext().getNext().getValue());
			key.getNext().getNext().getNext().setValue(key.getDown().getNext().getNext().getNext().getValue());
			laenge++;
		} else {
			
			// füge neues element am ende der liste hinzu sofern neue nummer größer is als der rest 
		}
			if (number > key.getNext().getNext().getNext().getValue()) {
				key.getNext().getNext().getNext().getNext().add(newElement);
				key.getNext().getNext().getNext().setAbstand();
				
				//sofern der abstand größer ist als das maximal wird der abstand von allen felder geupdated sodass der abstand wieder gleichmäßig ist.
				if (key.getNext().getNext().getNext().setAbstand() > maximal) {
					update();
				}
			} else if (number > key.getNext().getNext().getValue()) {
				key.getNext().getNext().add(newElement);
				key.getNext().getNext().setAbstand();
				if ( key.getNext().getNext().setAbstand() > maximal){
					update();
				}
			} else if (number > key.getNext().getValue()) {
				key.getNext().add(newElement);
				key.getNext().setAbstand();
				if ( key.getNext().setAbstand() > maximal ) {
					update ();
				}
			} else if (number > key.getValue()) {
				key.add(newElement);
				key.setAbstand();
				if (key.setAbstand() > maximal) {
					update ();
				}
			
			}
			laenge++;
		} if (laenge % 4 == 0){
			maximal++;
		}

	// cast zu int damit keine komma zahlen entstehen
	public void update ()  {
		int u = (int) laenge /4;
		key.getNext().setDown(get(u +1));
		key.getNext().getNext().setDown(get(2*u +1));
		key.getNext().getNext().getNext().setAbstand(get(3*u +1);
		
		
	}
	 /**
	  * This method is used to get searched values in the list.
	  * @param i
	  * @return
	  */
	
	// gibt die stelle der gesuchten zahl wieder
	private Elementlist get(int i) {
		int helper1= key.getNext().getNext().getNext().getAbstand();
		int helper2 = key.getNext().getNext().getAbstand();
		int helper3 = key.getNext().getAbstand();
		
		//
	if (i >= laenge-helper1){
		return key.getNext().getNext().getNext().getDown().getElementlist(i-laenge-helper1);
	}if (i >= laenge - helper1- helper2){
		return key.getNext().getNext().getDown().getElementlist(i - laenge - helper1 - helper2);
	}if (i >= laenge - helper1 - helper2- helper3){7
		return key.getNext().getDown().getElementlist(i- laenge - helper1 - helper2 - helper3);
	}else {
		return key.getDown().getElementlist(i);
	}

	//checkt ob nummer in der liste enthalten ist 
	// contains = start und arbeitet sich durch die lsite und check jeded value obs dem gesuchten entspricht
	
	public static boolean contains(int valuesearch) {

		Indexlist contains = key;
		boolean zaehler = false;
		while (contains != null) {
			if (contains.value == valuesearch) {
				zaehler = true;
			}
			contains = contains.next;
		}
		return zaehler;
	}

	@Override
	public String toString() {
		return "Skiplist [laenge=" + laenge + ", key=" + key + ", maximal=" + maximal + "]";
	}

	
	// easy
	public static void main(String[] args) {

			String command = IOTools.readLine("Was moechten sie tun? Bitte geben sie ein der folgenden Befehle ein: add,contains, get, tostring");
			switch (command) {
			case "add":
				
				break;
			case "get":
				
				break;
			case "contains":
				
				break;
			case "tostring":
				
				break;
			case "exit":
			
				break;
			}
}