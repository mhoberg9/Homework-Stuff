import Prog1Tools.IOTools;

public class Zahlenraten {
	public static void main (String [] args){
		System.out.println("Willkommen beim Zahlenraten.");
		System.out.println("Ich denke mir eine natürliche Zahl zwischen 0 und 100 aus. Rate diese Zahl!");
		
		
		int i = 1; 
		int geheimZahl = (int)(99*Math.random() + 1);
		//System.out.println(geheimZahl);
		int rateZahl = 0;
		
		do{
			 rateZahl = IOTools.readInt("Geben Sie eine Zahl ein um die es sich handeln könnte: ");
			 if (rateZahl < geheimZahl){
				 System.out.println(i + ". Versuch: " + rateZahl + '\n' + "Meine Zahl ist größer!" + '\n');
			 i++;
			 }
			 if (rateZahl > geheimZahl){
				 System.out.println(i + ". Versuch: " + rateZahl + '\n' + "Meine Zahl ist kleiner!" + '\n');
			 i++;
			 }
			 if (rateZahl == geheimZahl){
				 System.out.println(i + ". Versuch: " + rateZahl + '\n' + "Du hast meine Zahl beim " + i + ". Versuch erraten. Sie lautet: " + geheimZahl + '\n');
			i++;	 
			 }
			 
		}while(rateZahl != geheimZahl);
		
	}
}
