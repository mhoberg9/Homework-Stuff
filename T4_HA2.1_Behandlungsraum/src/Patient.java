import java.util.concurrent.BlockingQueue;

public class Patient extends Thread {

	private BlockingQueue<String> behandlungsraum;

	public void run() {
		while (!(Thread.currentThread().isInterrupted())) {
			String c = behandlungsraum.poll();
			System.out.println("Verlässt:" + c);

			String s = "Patient 2";
			System.out.println("Betritt:" + s);
			behandlungsraum.add(s);

			try {
				Thread.currentThread();
				Thread.sleep(1000);
			} catch (Exception e) {
				this.interrupt();
				;
			}
		}
	}

	public void setQ(BlockingQueue<String> behandlungsraum) {
		this.behandlungsraum = behandlungsraum;
	}

}
