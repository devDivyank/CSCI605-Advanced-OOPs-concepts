public class Runner implements Runnable {
	private final int id;
	private static int runnerTurn = 1;
	private int teamSize;
	static final Object lock = new Object();

	public Runner(int id) {
		this.id = id;
	}

	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}

	@Override
	public void run() {
		synchronized (lock) {
			while (this.id != runnerTurn) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
				}
			}
			System.out.println("\tBaton is handed to runner " + this.id);
			Runner.runnerTurn++;
			lock.notifyAll();
			if (this.id == this.teamSize) {
				runnerTurn = 1;
			}
		}
	}
}
