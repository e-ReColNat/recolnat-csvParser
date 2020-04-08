package fr.mnhn.recolnat.csvParser.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.text.DefaultCaret;

public class MainView extends JFrame {
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	public MainView() {

			setBounds(50, 50, 600, 600);
			setTitle("Mise à jour du collection code");
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			setLayout(new GridLayout(3, 1));
			
			JLabel headerLabel = new JLabel(" Check collection code",JLabel.CENTER );
			headerLabel.setSize(50,100);
			JPanel mainPanel = new JPanel();
			JLabel footerLabel = new JLabel("e-recolnat",JLabel.CENTER);        
			footerLabel.setSize(350,100);
			
			GridLayout mainLayout = new GridLayout(3,2);
			mainLayout.setVgap(10);
			mainPanel.setLayout(mainLayout);
			Border margin = new EmptyBorder(10, 20, 5, 10);
			mainPanel.setBorder(margin);
			//mainPanel.size
			//GridLayout layoutChooseFile= new GridLayout(0, 2);
			
			JPanel panelChooseFile = new JPanel();
			JButton btnOpenDialogBox = new JButton("Choose File");
			btnOpenDialogBox.setAlignmentY(CENTER_ALIGNMENT);
			JTextArea txtFilePath = new JTextArea(2,35);
			
			//DefaultCaret caret = (DefaultCaret)txtFilePath.getCaret();
			//caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
			
			JScrollPane paneTextArea1 = new JScrollPane(txtFilePath,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			paneTextArea1.setAlignmentY(CENTER_ALIGNMENT);
			//paneTextArea1.setBounds(20, 30, 300, 20);
			
			btnOpenDialogBox.setPreferredSize(new Dimension(120,30));
			panelChooseFile.setPreferredSize(new Dimension(400,40));
			
			MainViewActionListener al = new MainViewActionListener(panelChooseFile, txtFilePath);
			btnOpenDialogBox.addActionListener(al);
			
			panelChooseFile.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelChooseFile.add(btnOpenDialogBox);
			panelChooseFile.add(paneTextArea1);
			panelChooseFile.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			
			mainPanel.add(panelChooseFile);
			
		    // check button
			
			JPanel panelCheckCsvButton = new JPanel();
			JButton btnCheckCsv = new JButton("Check file");
			panelCheckCsvButton.add(btnCheckCsv);
			panelCheckCsvButton.setLayout(new FlowLayout(FlowLayout.LEFT));
			panelCheckCsvButton.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			mainPanel.add(panelCheckCsvButton);
		    
		    // end check button
			
			// panel info
			
		    JPanel panelCollInfo1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    //panelCollInfo.setBackground(Color.darkGray);
		   
		    panelCollInfo1.setPreferredSize(new Dimension(200,25));
		    
		    
		    JLabel colNameLbl = new JLabel("Nom collection", JLabel.LEFT);
		    JTextArea colNameTxt = new JTextArea("");
		    //colNameTxt.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		    panelCollInfo1.add(colNameLbl);
		    panelCollInfo1.add(colNameTxt);
		    
		    colNameLbl.setPreferredSize(new Dimension(150 , 20));
		    colNameTxt.setPreferredSize(new Dimension(50 , 20));
		    
		    JPanel panelCollInfo2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		    
		    //panelCollInfo2.setBorder(margin);
		    
		    panelCollInfo2.setPreferredSize(new Dimension(200 , 25));
		    
		    JLabel specimensNbLbl = new JLabel("Specimen nb", JLabel.LEFT);
		    JTextArea specimensNbTxt = new JTextArea("");
		    
		    specimensNbLbl.setPreferredSize(new Dimension(150 , 20));
		    specimensNbTxt.setPreferredSize(new Dimension(50 , 20));
		    
		    panelCollInfo2.add(specimensNbLbl);
		    panelCollInfo2.add(specimensNbTxt);
		    
		    JPanel panelColl = new JPanel(new GridLayout(2,1));
		    panelColl.add(panelCollInfo1);
		    panelColl.add(panelCollInfo2);
		    panelColl.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
		    
		    mainPanel.add(panelColl);

			
			// instance de classe anonyme pour gerer les events
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
					}
				}
			);
			
			this.getContentPane().add(headerLabel);
			this.getContentPane().add(mainPanel);
			this.getContentPane().add(footerLabel);
			
			//this.pack();
	}
	public void display() {
		this.setVisible(true);
	}
}
