import Prog1Tools.IOTools;
public class ceasarcipher {
	public static void main(String [] args){
		
		int arraylength = IOTools.readInt("Enter length of word: ");
		char [] array = readChars(arraylength);
		
		printmessage(array);
		
		while(true){
			
			int temp = getCommand();
			
			if(temp == 0) {
				shift(array, IOTools.readInt("Enter the offset"));	
			}
			if(temp == 1){
				
				System.out.println("Bye");
			
			}
			}
	
	}
	
	public static void printmessage (char [] array){
	
	//	for (char wert : array) {
	//		System.out.println(wert);
			
		for (int i=0; i<array.length; i++){
			System.out.println(i);
			
		}
	}	
	
	
	public static char [] readChars(int length){
		
		char [] array = new char [length];
		
		for (int i=0;i<array.length;i++ ){
			array[i] = IOTools.readChar("Enter first character: ");
			
		}
		return array;
	}
	
	public static void shift (char [] array, int shift){
		
		for (int i=0; i<array.length; i++){
			
			int unicode = (int)array[i] + shift;
			array[i] = (char)unicode;
			
		}
		
	}
	
	public static int getCommand(){
		
				
		while(true){
			String command = IOTools.readString("Enter command (shift or exit)");
			
			if(command.equals("shift")){
				return 0;
			if(command.equals("exit")){
				return 1;
				
			}
			}
			
			}
		}
			
		
	}

}
