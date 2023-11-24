package cms.cm7;

public class HelloWorldRunner {
	
	public static void main(String[] args) {
		Thread t = new Thread (new HelloWorldWindow());
		t.start();
		javax.swing.SwingUtilities.invokeLater(new HelloWorldWindow()); // Le lance dans le dispatcher AWT
	}

}
