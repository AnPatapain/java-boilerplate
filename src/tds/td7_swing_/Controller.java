package tds.td7_swing_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import tds.td6_threads.MyRunnable;

public class Controller {
	private View view;
	private Model model;
	private static String CHARGER = "charger";
	private static String COUNT = "count";
	
	public Controller(View view, Model model) {
		this.model = model;
		this.view = view;
		
		this.view.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getActionCommand().equals(Controller.CHARGER)) {
					int result = view.showFileChooser(view);
					if (result == JFileChooser.APPROVE_OPTION) {
			            File[] selectedFiles = view.getFileChooser().getSelectedFiles();
			            for(File f : selectedFiles) {
			            	view.getShowFileArea().append(f.getAbsolutePath() + "\n");
			            }
			            model.setFiles(Arrays.asList(selectedFiles));
			        } else {
			            JOptionPane.showMessageDialog(view, "No file selected.");
			        }
				}
				else if(arg0.getActionCommand().equals(Controller.COUNT)) {
					if(view.getLetterInputField().getText().equals("")) {
						JOptionPane.showMessageDialog(view, "Input your letter");
					}else {
						CompteTask compteTask = new CompteTask(view, model);
						compteTask.execute();
					}
				}
			}
		});
	}

	
	public static void main(String[] args) {
		View view = new View();
		view.setActionCommandFileButton(Controller.CHARGER);
		view.setActionCommandCountButton(Controller.COUNT);
		Model model = new Model();
		Controller controller = new Controller(view, model);
	}
}
