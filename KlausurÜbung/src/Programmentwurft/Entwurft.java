package Programmentwurft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Entwurft {

	public class Apfel extends Obst {
	}

	public class Birne extends Obst {
	}

	public class Obst implements Essbar {
	}

	public class Brot implements Essbar {
	}

	public interface Essbar {
	}

	public class Obstkorb {
		ArrayList<Obst> korb = new ArrayList<>();
	}
	
	@SuppressWarnings("hiding")
	public class Einkaufszettel<T extends Obst,Brot , V extends Number> {
		Map <T,V> anzahl = new HashMap<>();
	}
	abstract class BasisEinkaufszettel <T>{
		Map <T, Integer> Zettel = new HashMap<>();
	}
	
	public class Einkaufszettel2 extends BasisEinkaufszettel<Object>{
	
	}

}