package cms.cm7.boutonInc;

/**
 * Prompt : write me an MVC program in java to represent a button 
 * which I can click on to increment a variable i that is printed 
 * 
 * Instructions de ChatGPT : 
 * 
 * Save this code in a file named MVCExample.java. 
 * Compile and run it using the following commands:
 * javac MVCExample.java
 * java MVCExample
 */

/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Model
class CounterModel {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }
}

// View
class CounterView {
    private JFrame frame;
    private JLabel label;

    public CounterView() {
        frame = new JFrame("MVC Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Counter: 0");
        JButton button = new JButton("Increment");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Notify the controller that the button is clicked
                Controller.handleButtonClick();
            }
        });

        frame.getContentPane().add(BorderLayout.CENTER, label);
        frame.getContentPane().add(BorderLayout.SOUTH, button);

        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    public void updateCounter(int count) {
        label.setText("Counter: " + count);
    }
}

// Controller
class Controller {
    private static CounterModel model;
    private static CounterView view;

    public static void main(String[] args) {
        model = new CounterModel();
        view = new CounterView();
    }

    public static void handleButtonClick() {
        // Update the model
        model.incrementCounter();

        // Update the view
        view.updateCounter(model.getCounter());
    }
}

public class MVCExample {
    public static void main(String[] args) {
        // Run the program by instantiating the Controller
        Controller.main(args);
    }
}
*/