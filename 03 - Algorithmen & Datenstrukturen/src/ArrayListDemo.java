import java.util.ArrayList;
import java.util.List;



public class ArrayListDemo {
	public static void main(String[] args) {
		List<String> teilnehmer = new ArrayList<String>();
		teilnehmer.add("Rekkles");
		teilnehmer.add("Tabz");
		teilnehmer.add("Piglet");
		teilnehmer.add("Sneaky");
		
		String members = "";
		for(String t:teilnehmer){
			members += t+";";
		}
		members = members.substring(0, members.length()-1);
		System.out.println(members);
	}
}
