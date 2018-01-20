import java.util.HashSet;
import java.util.Set;


public class Pruefungsverwaltung {

	public static void main(String[] args) {
		
		Set quispos = new HashSet();
		quispos.add("Hai");
		quispos.add("Bjergsen");
		quispos.add("Hai"); // Duplikate werden nicht hinzugefügt.
		
		Set manuell = new HashSet();
		manuell.add("Saintvicious");
		manuell.add("Doublelift");
		
		Set angemeldet = new HashSet(quispos);
		angemeldet.addAll(manuell);
		System.out.println("Angemeldet: " + angemeldet);
		
		
		Set vorleistung = new HashSet();
		vorleistung.add("Hai");
		vorleistung.add("Bjergsen");
		vorleistung.add("Froggen");
		vorleistung.add("Doublelift");
		
		Set zugelassen = new HashSet(angemeldet);
		zugelassen.retainAll(vorleistung);
		System.out.println("Zugelassen: "+ zugelassen);
		

	}

}
