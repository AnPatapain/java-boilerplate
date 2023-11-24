package cms.cm7;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HelloWorldJustFrame {
	
	public static void main(String[] args) {
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Attention : par défaut HIDE_ON_CLOSE
 
        JLabel label = new JLabel("Hello World");
        //frame.getContentPane().add(label); // à discuter
        frame.add(label);
 
        //Display the window.
        //frame.pack(); // Ou mettre frame.setSize(100,100);
        frame.setSize(100,100);
        frame.setVisible(true);
	}

}
