package tds.td7_swing_;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{
	private JButton chooseFileButton;
	private JTextArea showFileArea;
	private JFileChooser fileChooser;
	private JButton countButton;
	private JLabel letterLabel;
	private JTextField letterInputField;
	private JLabel result;
	
	public View() {
		this.chooseFileButton = new JButton("choose files");
		this.showFileArea = new JTextArea();
		this.countButton = new JButton("Count");
		this.letterLabel = new JLabel("letter");
		this.letterInputField = new JTextField();
		this.result = new JLabel("result");
		
		setTitle("count letter");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 6));
		setSize(900, 200);
		setVisible(true);
		
		add(chooseFileButton);add(showFileArea);add(countButton);add(letterLabel);add(letterInputField);add(result);
	}
	
	public void addActionListener(ActionListener actionListener) {
		this.chooseFileButton.addActionListener(actionListener);
		this.countButton.addActionListener(actionListener);
	}
	
	public int showFileChooser(JFrame frame) {
		fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        return fileChooser.showOpenDialog(frame);
	}
	
	public JFileChooser getFileChooser() {
		return fileChooser;
	}
	
	public JTextArea getShowFileArea() {
		return showFileArea;
	}
	
	public JTextField getLetterInputField() {
		return letterInputField;
	}
	
	public void setResult(String text) {
		this.result.setText(text);
	}
	
	public void setActionCommandFileButton(String action) {
		this.chooseFileButton.setActionCommand(action);
	}
	
	public void setActionCommandCountButton(String action) {
		this.countButton.setActionCommand(action);
	}
}
