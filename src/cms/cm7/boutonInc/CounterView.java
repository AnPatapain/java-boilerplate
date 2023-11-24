package cms.cm7.boutonInc;

import java.awt.BorderLayout; // Code rajouté
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//View
class CounterView {
 private JFrame frame;
 private JLabel label;

 public CounterView() {
     frame = new JFrame("MVC Example");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     label = new JLabel("Counter: 0");
     JButton button = new JButton("Increment");

     /**
      * Problème : le controleur est défini dans la vue
      */
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