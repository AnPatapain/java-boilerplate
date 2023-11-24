package cms.cm7;

import java.awt.GridLayout;

import javax.swing.*;        

public class HelloWorldSwing {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {

        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // Attention : par défaut HIDE_ON_CLOSE
		//frame.setLayout(new GridLayout(1, 2));  // On peut discuter des autres Layouts
 
        JLabel label = new JLabel("Hello World");
        //JLabel label2 = new JLabel("Hello again");
        //frame.getContentPane().add(label); // à discuter
        frame.add(label);
        //frame.add(label2); 
        
        //Display the window.
        //frame.pack(); // Ou mettre frame.setSize(100,100);
        frame.setSize(100,100);
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}