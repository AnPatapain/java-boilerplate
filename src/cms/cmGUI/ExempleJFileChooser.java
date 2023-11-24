package cms.cmGUI;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ExempleJFileChooser {

    private static void showFileChooser(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int result = fileChooser.showOpenDialog(frame);

        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles();
            for(File f : selectedFiles) {
            	System.out.println("Selected file: " + f.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(frame, "No file selected.");
        }
    }
    
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("File Chooser Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openButton = new JButton("Open File Chooser");
        Font labelFont = new Font("Arial", Font.PLAIN, 30);
        openButton.setFont(labelFont);

        /**
         * Ici on met une classe anonyme comme controler
         */
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFileChooser(frame);
            }
        });

        frame.getContentPane().add(openButton);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
}
