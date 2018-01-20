
public class StackDemo {

	public static void main(String[] args) {
		System.out.println("ArrayStack Demo:");
		ArrayStack arrayStack = new ArrayStack();
		arrayStack.push(new String("Hallo"));
		arrayStack.push(new String("Es wurde gepusht!"));
		System.out.println(arrayStack.top());
		arrayStack.push(new String("Foo"));
		arrayStack.push(new String("Bar"));
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());
		System.out.println(arrayStack.pop());		
		System.out.println(arrayStack.pop());

		System.out.println("\n" + "ListStack Demo:");

		ListStack listStack = new ListStack();
		listStack.push(new String("Hallo"));
		listStack.push(new String("Es wurde gepusht!"));
		System.out.println(listStack.top());
		listStack.push(new String("Foo"));
		listStack.push(new String("Bar"));
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());
		System.out.println(listStack.pop());		
		System.out.println(listStack.pop());
		
	}

}
