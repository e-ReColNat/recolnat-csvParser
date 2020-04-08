package fr.mnhn.recolnat.csvParser.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MainViewActionListener implements ActionListener {
	
	private JPanel panel;
	private JTextArea textFilePath;
	
	public MainViewActionListener(JPanel panel, JTextArea textFilePath) {
		this.panel = panel;
		this.textFilePath = textFilePath;
	}

	public void actionPerformed(ActionEvent ae) {
		String cmd = ae.getActionCommand();
		
		if (cmd.equals("Choose File")) {
			
			JFileChooser dialogue = new JFileChooser(new File("."));
			File file = null;
			
			if (dialogue.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
				    file = dialogue.getSelectedFile();
			}
			
			textFilePath.setText(file.getPath());
		}
	}
}
