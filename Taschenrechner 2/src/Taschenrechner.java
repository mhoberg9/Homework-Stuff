import Prog1Tools.IOTools;

public class Taschenrechner {
	public static void main(String[] args) {

		int operant1;
		int operant2;
		char operator;
		int ergebnis = 0;

		System.out.println("Willkommen im Taschenrechner");
		operant1 = IOTools.readInt("Bitte geben Sie ihren ersten Operatnen ein: ");
		operant2 = IOTools.readInt("Bitte geben Sie ihren zweiten Operanten ein: ");
		operator = IOTools.readChar("Bitte geben Sie einen Operator ein (+,-,*,/,%): ");
		if (operator == '+') {
			ergebnis = operant1 + operant2;
			System.out.println(operant1 + "+" + operant2 + "=" + ergebnis);
		} else if (operator == '-') {
			ergebnis = operant1 - operant2;
			System.out.println(operant1 + "-" + operant2 + "=" + ergebnis);
		} else if (operator == '*') {
			ergebnis = operant1 * operant2;
			System.out.println(operant1 + "*" + operant2 + "=" + ergebnis);
		} else if (operator == '/') {
			ergebnis = operant1 / operant2;
			System.out.println(operant1 + "/" + operant2 + "=" + ergebnis);
		} else if (operator == '%') {
			ergebnis = operant1 % operant2;
			System.out.println(operant1 + "%" + operant2 + "=" + ergebnis);
		} else {
			System.out.println("Falscher Operator. Bitte wählen Sie zwischen '+,-,*,/,%");
		}
	}
}
