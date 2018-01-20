import javax.swing.plaf.synth.SynthScrollBarUI;

import Prog1Tools.IOTools;
public class aufgabe21 {
	public static void main(String [] args){
		
	int count = IOTools.readInt("Bitte Zahl eingeben ");
	int [] zahl = new int [count];
	
	for(int i = 0; i < count; i++)
		zahl[i] = IOTools.readInt(i+1 +" Zahl: ");
	
	for(int i = 0 ; i < count-1; i++){
		for(int j = 0; j < count-1; j++){
			if (zahl[j]>zahl[j+1]){
			 int k = zahl[j];
			 zahl[j]  = zahl[j+1];
			 zahl [j+1] = k;
		}}	
	for(i = 0; i < count; i++){	
	System.out.println(zahl[i] +" ");
	
		
	

	}
	
	}}}			
	


