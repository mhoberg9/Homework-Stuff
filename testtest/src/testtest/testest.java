package testtest;

public class testest {
	
			static void bar(int a, double b) {
			System.out.print("ID ");
			}
			static void bar(int a, int b) {
			System.out.print("II ");
			}
			static void bar(double a, long b) {
			System.out.print("DL ");
			}
			static void bar(float... a) {
			System.out.print("FS ");
			}
			static void bar(int a, byte b){
			System.out.print("IB ");
			}
			static void bar(double a, double b){
			System.out.print("DD ");
			}
			public static void main(String[] args) {
			int i=0;
			long l =0;
			float f=0;
			double d=0;
			char c='0';
			bar(i,f);
			bar(d,i);
			bar(i,c,i);
			bar(i,c);
			bar(l,c);
			}
		}