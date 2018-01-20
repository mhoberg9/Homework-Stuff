import Prog1Tools.IOTools;

public class TaschenrechnerSwitch {
public static void main (String [] args){
	
	System.out.println("Willkommen im Taschenrechner");
	int operant1 = IOTools.readInt("Bitte ersten Operanten eingeben: ");
	char operator = IOTools.readChar("Bitte den Operator eingeben: ");
	int operant2 = IOTools.readInt("Bitten den zweiten Operanten eingeben: ");
	int ergebnis = 0;
	
	switch (operator){
	case '+' :
		ergebnis = operant1 + operant2;
		System.out.println(operant1 + "+" + operant2 +"=" + ergebnis);	
		break;
		
	case '-' :
		ergebnis = operant1 - operant2;
		System.out.println(operant1 + "-" + operant2 + "=" + ergebnis );
		break;
		
	case '*' :
		ergebnis = operant1 * operant2;
		System.out.println(operant1 + "*" + operant2 + "=" + ergebnis );
		break;
		
	case '/' :
		ergebnis = operant1 / operant2;
		System.out.println(operant1 + "/" + operant2 + "=" + ergebnis );
		break;
	
	case '%' :
		ergebnis = operant1 % operant2;
		System.out.println(operant1 + "%" + operant2 + "=" + ergebnis );
		break;
		
	default :
		System.out.println("Falscher Operator. Bitte geben sie einen verfügbaren Operator ein (+,#,*,/,%)");
		break;
	}
}
}
