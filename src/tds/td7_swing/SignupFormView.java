package tds.td7_swing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SignupFormView extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField usernamelField;
	private JTextField passwordField;
	private JButton submitButton;
	
	public SignupFormView() {
		setTitle("Signup Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		
		JLabel usernameLabel = new JLabel("Username: ");
		JLabel passwordLabel = new JLabel("Password: ");
		
		usernamelField = new JTextField(20);
		passwordField = new JTextField(20);
		submitButton = new JButton("Sign Up");
		
		// Set font size for labels
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);
        
        // Set font size and height for text fields
        Font textFieldFont = new Font("Arial", Font.PLAIN, 14);
        usernamelField.setFont(textFieldFont);
        passwordField.setFont(textFieldFont);
        usernamelField.setPreferredSize(new Dimension(usernamelField.getWidth(), 5));
        passwordField.setPreferredSize(new Dimension(passwordField.getWidth(), 5));

        // Set size for the button
        submitButton.setPreferredSize(new Dimension(120, 30));
        
		setLayout(new GridLayout(3, 2, 10, 10));
		
		add(usernameLabel);add(usernamelField);
		add(passwordLabel);add(passwordField);
		add(submitButton);
	}
	
	public void addListenner(ActionListener listener) {
		this.submitButton.addActionListener(listener);
	}
	
	public void displayMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Sign Up Successful", JOptionPane.INFORMATION_MESSAGE);
    }
	
	public String getUserName() {
		return usernamelField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
}
