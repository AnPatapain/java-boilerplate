package tds.td7_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class SignupController {
	private SignupFormView view;
	private User user;
	
	public SignupController(SignupFormView signupFormView, User user) {
		this.view = signupFormView;
		this.user = user;
		this.view.addListenner(new SignupListener());
	}
	
	private class SignupListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			user.setUsername(view.getUserName());
			user.setPassword(view.getPassword());
			view.displayMessage(view.getUserName() + " " + view.getPassword() + " register successfully");
		}
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			User model = new User();
			SignupFormView signupFormView = new SignupFormView();
			signupFormView.setVisible(true);
			
			SignupController controller = new SignupController(signupFormView, model);
		});
	}
}
