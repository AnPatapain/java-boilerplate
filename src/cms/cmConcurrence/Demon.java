package cms.cmConcurrence;


public class Demon {

	public static void main(String[] args) throws Exception{
		Thread daemonThread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						System.out.println("Execution demon");
					}
				} finally {
					System.out.println("Fin demon");
				}
			}
		}, "Demon");
		daemonThread.setDaemon(true);
		daemonThread.start();
		Thread.sleep(10);
	}
}