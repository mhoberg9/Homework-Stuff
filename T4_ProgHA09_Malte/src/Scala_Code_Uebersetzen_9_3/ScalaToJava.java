package Scala_Code_Uebersetzen_9_3;

/**
 * Scala-Code to Java
 * 
 * @author Malte
 *
 */
public class ScalaToJava {

	/**
	 * 1 class Hello
	 * 
	 *
	 */
	public class Hello {

	}

	/**
	 * 1 object World
	 */
	public World;

	/**
	 * 1 class User(n: String) { 2 val name: String = n 3 def greet: String =
	 * s"Hello from $name" 4 override def toString = s"User($name)" 5 }
	 *
	 */
	public class User {
		private final String n;// ????
		private final String name ;
		
		

		public String greet() {

			return "Hello from" + name;
		}

		@Override
		public String toString() {
			return "User" + name;
		}
	}

	/**
	 * 1 class Person { 2 var name = "" 3 private var age = 0 4 5 def this(name:
	 * String) = { 6 this() 7 this.name = name 8 } 9 10 def this(name: String,
	 * age: Int) { 11 this(name) 12 this.age = age 13 } 14 }
	 *
	 * 
	 */
	public class Person {

		private String name = "";
		private int age = 0;

		public Person(String name) {
			this.name = name;
		}

		public Person(String name, int age) {
			this(name);
			this.age = age;
		}
	}

	/**
	 * 1 class Person(val name: String, age: Int)
	 *
	 */
	public class Personn {
		private final String name;
		int age;
	}
}
