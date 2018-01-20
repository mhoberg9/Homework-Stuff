import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Behandlungsraum {

	public static void main(String[] args) {
		BlockingQueue <String> behandlungsraum = new LinkedBlockingQueue<>(1);
		
		Patient p = new Patient();
		p.setQ(behandlungsraum);
		p.start();
		
		Patient1 p1 = new Patient1();
		p1.setQ(behandlungsraum);
		p1.start();
		
		
		
	}

}
