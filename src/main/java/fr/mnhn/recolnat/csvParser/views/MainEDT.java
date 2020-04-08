package fr.mnhn.recolnat.csvParser.views;

import javax.swing.SwingUtilities;

public class MainEDT {
	
	// appelle du thread EDT
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainView().display());
	}
}
