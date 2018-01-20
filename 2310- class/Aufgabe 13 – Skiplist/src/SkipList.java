import Prog1Tools.IOTools;

public class SkipList {
	/*
	 * Erster Schritt: 4 einsen oben in der kleinen Liste Zweiter Schritt: 1
	 * Eins unten in der Liste.
	 * 
	 * 
	 * Konstruktur für die kleine Liste: IndexListeKlein(IndexListeKlein next,
	 * IndexListeGroß down)
	 * 
	 * 
	 */
	private static IndexListeGroß anfang = new IndexListeGroß(1); // Lang ,
																	// ist quasi
																	// der head

	// Rekursive definition
	private static IndexListeKlein index4 = new IndexListeKlein(null, anfang, 1); // Kurz
	private static IndexListeKlein index3 = new IndexListeKlein(index4, anfang, 1);
	private static IndexListeKlein index2 = new IndexListeKlein(index3, anfang, 1);
	private static IndexListeKlein index1 = new IndexListeKlein(index2, anfang, 1);

	public static void main(String[] args) {

		System.out.println("Es wurde bereits eine Hauptliste [1,1,1,1] und eine Nebenliste [1] erschaffen.");
		System.out.println("Die beiden listen sind durch next und down miteinander verbunden.");

		int counter = 1;
		while (counter == 1) {
			String command = IOTools.readLine("Nennen Sie die auszuführende Methode (add, get, tostring, contains: ");
			switch (command) {
			case "add":
				add(IOTools.readInt("Geben Sie einen Wert an: "));
				break;
			case "get":
				int index = IOTools.readInt("Geben Sie einen Index an.");
				System.out.println(index + " contains " + get(index));
				break;
			case "contains":
				int contain = IOTools.readInt("Geben Sie einen Wert an: ");
				boolean containing = contains(contain);
				if (containing == true) {
					System.out.println(contain + " ist enthalten");
				} else if (containing == false) {
					System.out.println(contain + " ist NICHT enthalten");
				} else {

					System.out.println("error");

				}
				break;
			case "tostring":
				System.out.println(tostring());
				break;
			case "exit":
				counter = 0;
				break;
			}

		}
	}

	public static void add(int value) {

	// Neues Element der Großen Liste mit dem Wert erschaffen
    // Einsetzen an der richtigen Stelle. Was ist genau größer was ist kleiner? Add function aus der vorlesung

	if (größe(anfang)<= 4){	
		
	IndexListeGroß neuesElement = new IndexListeGroß(value);
	IndexListeGroß temp = anfang;
	while(temp.next!=null && temp.next.value <= neuesElement.value) temp = temp.next;
	temp.next = neuesElement;

	} else{
	// Suchen wieder in den Intervallen
		IndexListeKlein temp;
		if (value >= index1.getValue() && value < index2.getValue()){
			temp = index1 ;
		}
		if (value >= index2.getValue() && value < index3.getValue()){
			temp =  index2;
		}
		else if (value >= index3.getValue() && value < index4.getValue()){
			 temp = index3;
		}
		else{
			 temp = index4;
		}

		IndexListeGroß neuesElement = new IndexListeGroß(value);
		IndexListeGroß current = temp.getDown();
		while(current.next!=null && current.next.value <= neuesElement.value) current = current.next;
		current.next = neuesElement;
	}
	// Zuweisen eines neuen Index-Klein Wertes.
	update();

	
	}

	public static int get(int index) {
/*
 * 
 * • get(int index) – Gibt das Element vom Typ int an Stelle index zurück.
 * mit counter arbeiten?
 * 
 * Geht die Große Liste nach Index durch.
 * 
 * Hier gibt es zwei Arten: Erstens: Die Sekundärliste ist größer als die Hauptliste (IndexListeGroß =< 4)
 * Dann ist das Verfahren aus der Vorlesung schneller.
 * 
 * Zweitens: Die Sekundärliste ist kleiner als die Hauptliste (IndexListeGroß > 4)
 * Dann wird die Sekundärliste herangezogen zum Suchen.
 * 
 */

		// Erster Fall
		if (größe(anfang) <= 4){
			int counter = 0;
			IndexListeGroß current = anfang;
			while (current != null && index != counter++)
				current = current.next;
			if (current == null)
				return 0;
			else
				return current.value;
		
		} // FEHLER WENN MAN ÜBER 4 Elemente in der Liste hat, die ersten 4 können nicht gesucht werden.
		else {
			IndexListeKlein temp;
			// Hier kommt das eigentliche Verfahren zum tragen.
			// Zunächst: Suche in der SekundärListe
			// Danach: Suchen im Intervall.
			if (index>=index1.getId() && index < index2.getId()){
				temp = index1;
			}
			if (index>=index2.getId() && index < index3.getId()){
				temp = index2;
			}
			if (index>=index3.getId() && index < index4.getId()){
				temp = index3;
			}
			else {
				temp = index3;
			}
			// Jetzt runter in die Lange liste im Bestimmten Interval.
			int counter = 0;
			IndexListeGroß current = temp.getDown();
			counter = counter + temp.getDown().getId();
			while (current != null && index != counter++)
				current = current.next;
			if (current == null)
				return 0;
			else
				return current.value;
			
			
		}
		
	}

	public static boolean contains(int value) {
		/*
		 * • contains(int number) – Gibt einen boolean Wert zurück,
		 * welcher anzeigt ob das übergebene Element in der Liste enthalten
		 * ist.
		 */
		IndexListeGroß current = anfang;
		boolean counter = false;
		while (current != null) {
			if (current.value == value) {
				counter = true;
			}
			current = current.next;
		}
		return counter;

	}

	public static String tostring() {
		/*
		 * toString() – Gibt eine Stringdarstellung der Listenelemente der
		 * Sekundär- und Primärliste zurück.
		 */

		IndexListeGroß current = anfang;
		if (current == null)
			return "[]";
		String res = "[";
		while (current != null && current.next != null) {
			res += current.value + ",";
			current = current.next;
		}
		res += current.value + "]";
		return "Hauptliste " + res + "\nNebenliste:  \n [1]: " + index1.getValue() + "\n [2]: " + index2.getValue()
				+ "\n [3]: " + index3.getValue() + "\n [4]: " + index4.getValue();

	}

	public static void update() {
		/* Code zum Updaten der kurzen Liste
		 * 
		 * Zu beachten: Intervall darf sich nicht um mehr als 1 verschieben:
		 * 
		 * 3/4/5 wird zu 4/4/4
		 * 
		 * int i ist die lägne der Liste
		 * int help ist i/4 bzw. i/4 +1 
		 * 
		 * 
		 * Die Große Liste muss zunächst 4 Elemente übersteigen, sonst bricht das Programm ab.
		*/
		IndexListeGroß current = anfang;
		if (größe(current) < 4) {
			return;
		} else {
		
			int offset;
			if (größe(current) % 4 <= 2) {
				offset = größe(current) / 4;
			} else {
				offset = (größe(current) / 4) + 1;
			
		
			}
	/*	Funktioniert nicht: Versuch mit Rekursiver Methode.
	 * while (current !=null){
		if (current.next == null){
		int i = current.getId();
		System.out.println("Die Länge der Liste ist: " + i);
		
		if (i % 4 <= 2){
		offset = i/4;	
		}else {
		offset = (i/4) + 1;
		}
		*/
		index1.setDown(anfang);
		index1.setValue(index1.getDown().getValue());
		index1.setNext(index2);
		index1.setId(index1.getDown().getId());
		// Das muss ja jetzt den wert von help + 1 (1 ist ja der anfang) sein.
		index2.setDown(findeElement(anfang, 1 + offset));
		index2.setValue(index2.getDown().getValue());
		index2.setNext(index3);
		index2.setId(index3.getDown().getId());
		index3.setDown(findeElement(anfang, 1+ offset + offset));
		index3.setValue(index3.getDown().getValue());
		index3.setId(index3.getDown().getId());
		index3.setNext(index4);
		index4.setDown(findeElement(anfang, 1+ offset + offset + offset));
		index4.setValue(index4.getDown().getValue());
		index4.setId(index4.getDown().getId());
		index4.setNext(null);

		}
		
		
		
	}

	/*
	 * FUNKTIONIERT NICHT WIE GEWOLLT: Neuer Versuch => Rekursiv // Soll eine
	 * Methode sein um eine Instanz der Großen Liste zu bekommen mit int index.
	 * public static IndexListeGroß findeElement(IndexListeGroß anfang, int
	 * index){ IndexListeGroß current = anfang; while(current != null){ if
	 * (current.getId() == index){ return current; } current = current.next; }
	 * 
	 * 
	 * 
	 * return null; }
	 */
	public static IndexListeGroß findeElement(IndexListeGroß anfang, int index) {
		// Wenn anfang.value == index ist, return anfang, sonst weitersuchen
		// (Index und Value sind ja hier gleich)
		if (anfang.getId() == index) {
			return anfang;
		} else {
			return findeElement(anfang.getNext(), index);
		}
	}

	private static int grö

	ße(IndexListeGroß liste) {
		if (liste.getNext() == null) {
			return liste.getId();
		} else {
			return größe(liste.getNext());
		}
	}

}
