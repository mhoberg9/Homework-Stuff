import java.util.HashSet;
import java.util.Set;


public class PruefungsverwaltungTypisiert {

	public static void main(String[] args) {
		
		Set<String> quispos = new HashSet<String>();
		quispos.add("Hai");
		quispos.add("Bjergsen");
		quispos.add("Hai"); // Duplikate werden nicht hinzugefügt.
		
		Set<String> manuell = new HashSet<String>();
		manuell.add("Saintvicious");
		manuell.add("Doublelift");
		
		Set<String> angemeldet = new HashSet<String>(quispos);
		angemeldet.addAll(manuell);
		System.out.println("Angemeldet: " + angemeldet);
		
		
		Set<String> vorleistung = new HashSet<String>();
		vorleistung.add("Hai");
		vorleistung.add("Bjergsen");
		vorleistung.add("Froggen");
		vorleistung.add("Doublelift");
		
		Set<String> zugelassen = new HashSet<String>(angemeldet);
		zugelassen.retainAll(vorleistung);
		System.out.println("Zugelassen: "+ zugelassen);
		

	}

}
