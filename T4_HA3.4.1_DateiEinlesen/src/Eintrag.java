/**
 * This class is used to define all the attributes of an "Eintrag"-Object.
 * @author Malte
 *
 */
public class Eintrag {

	/**
	 * Attributes
	 */
	int bezirk;
	String bezname;
	int ortsteil;
	String ortsname;
	int geschlecht;
	String staatsangehörigkeit;
	String altergruppe;
	double haeufigkeit;

	/**
	 * Constructor
	 * @param bezirk
	 * @param bezname
	 * @param ortsteil
	 * @param ortsname
	 * @param geschlecht
	 * @param staatsangehörigkeit
	 * @param altergruppe
	 * @param haeufigkeit
	 */
	public Eintrag(int bezirk, String bezname, int ortsteil, String ortsname, int geschlecht,
			String staatsangehörigkeit, String altergruppe, double haeufigkeit) {
		this.bezirk = bezirk;
		this.bezname = bezname;
		this.ortsteil = ortsteil;
		this.ortsname = ortsname;
		this.geschlecht = geschlecht;
		this.staatsangehörigkeit = staatsangehörigkeit;
		this.altergruppe = altergruppe;
		this.haeufigkeit = haeufigkeit;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return "Eintrag [bezirk=" + bezirk + ", bezname=" + bezname + ", ortsteil=" + ortsteil + ", ortsname="
				+ ortsname + ", geschlecht=" + geschlecht + ", staatsangehörigkeit=" + staatsangehörigkeit
				+ ", altergruppe=" + altergruppe + ", haeufigkeit=" + haeufigkeit + "]";
	}
}
