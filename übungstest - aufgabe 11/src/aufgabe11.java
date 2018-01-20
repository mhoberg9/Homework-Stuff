import Prog1Tools.IOTools;
import java.math.*;
public class aufgabe11 {
	public static void main(String [] args){
		
		int i = IOTools.readInt("Zahl eingeben: ");
		int j = 0;
		while(j <= 10) {
			System.out.println(i * j + " while");
	
		j++;
		
		}
		for(j=0;j<=10;j++){
			System.out.println(j * i + " for");
		}
		int l = 0;
		do {
			System.out.println(l * i + " do");
			l++;
		} while (l <= 10);
		
		
	}	
		
}
	
	
	
	


