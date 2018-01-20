package de.tuberlin.snet.prog2.ue07.closures;

public class Scala {

	public class HelloWorld {

		HelloWorld o;

		private HelloWorld() {
		}

		public HelloWorld getInstance() {
			if (o == null) {
				return new HelloWorld();
			} else {
				return this.o;
			}
		}
	}

	final int x = 10;
	final int s = (x > 0) ? 1 : (-1);

	public void test (){
	final int status = 500;
	final String message;
	
	switch (status){
	case 200: message = "ok";
					break;
	//case 400: message = 
	
	
	}
	

	}
	
	public void test2 (){
		
		final String days = "Days";
		
		
		
	}
}

