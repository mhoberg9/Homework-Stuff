import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



public class ListIteratorDemo {
	public static void main(String[] args) {
		List<String> teilnehmer = new ArrayList<String>();
		teilnehmer.add("Rekkles");
		teilnehmer.add("Tabz");
		teilnehmer.add("Piglet");
		teilnehmer.add("Sneaky");
		
		String members = "";
		Iterator<String> it = teilnehmer.iterator();	
		while(it.hasNext()){
			members += it.next()+";";
		}
		members = members.substring(0, members.length()-1);
		System.out.println(members);
	}
}
