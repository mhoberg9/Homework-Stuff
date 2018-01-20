package mmmm;


public class mm {
	
	
		public static void main(String[] args) {
		Apfel a = new Apfel();
		}
		}
		class Apfel extends Frucht {
		static Print mp = new Print("Boskop!");
		Print mp2 = new Print("Gala!");
		public Apfel() {
		System.out.print("Jonagold!");
		}
		}
		class Frucht extends Essbar {
		Print mp2 = new Print("Banane!");
		public Frucht() {
		System.out.print("Kirsche!");
		}
		}
		class Essbar {
		static Print mp = new Print("Essbar!");
		}
		class Print {
		public Print(String msg) {
		System.out.print(msg);
		}
		}

