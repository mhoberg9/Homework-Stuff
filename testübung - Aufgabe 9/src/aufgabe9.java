import Prog1Tools.IOTools;
public class aufgabe9 {
	public static void main(String [] args){
	int n = IOTools.readInt("Wert eingeben: ");	
	int schleife = IOTools.readInt("Welche Schleife? 1 - for, 2 - while, 3 - dowhile ");
	
	switch (schleife){
	
	case 1:
	for (int i=0;i<2*n;i++){
	System.out.println(i + " for");
	System.out.println(3.14/(2*i-1) + " for");	
	}
	break;
	
	case 2:		
	int i = 3;
	while (i < 2*n){
			System.out.println(i + " while");
			System.out.println(3.14/(2*i-1) + " while");
			i++;	
	}
	break;
	
	case 3:
	i = 3;	
	
	do{
		System.out.println(i + " do");
		System.out.println(3.14/(2*i-1) + " do");
		i++;
	}while(i < (2 * n));
	break;
	}
	}	
}
	



