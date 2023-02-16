package view;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controller.ControllerGame;
import model.ModelPlayer;

public class ViewPanelScore extends JPanel{

	private static final long serialVersionUID = 6900206487428960817L;

	private int n = 0;
	private String name,surname,score,time,date = null;
	private ArrayList<ModelPlayer> Playerlist = new ArrayList<ModelPlayer>();
	private GridBagConstraints gbc = new GridBagConstraints();
	private Border border = BorderFactory.createLineBorder(Color.white, 2);
	private JButton backbutton;
	private JTextArea[][] JTextAreaMatrix;

	
	public ViewPanelScore() {
		
		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.BOTH;
	
		gbc.gridy=1;
		gbc.gridx=4;
		JLabel toplabel = new JLabel("ScoreTable");
		toplabel.setForeground(Color.white);
		add(toplabel,gbc);
		
		gbc.gridy=1;
		gbc.gridx=6;
		backbutton = new JButton("Back to Menu");
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(border);
		backbutton.setForeground(Color.WHITE);
		backbutton.setOpaque(false); 
		backbutton.setFocusable(false);
		add(backbutton, gbc);
		JTextAreaMatrix = new JTextArea[6][12];
		for (int rows=0; rows<12; rows++)
			for(int columns=0; columns<6; columns++) {
				gbc.gridy=rows+2;
				gbc.gridx=columns+1;
				JTextAreaMatrix[columns][rows] = new JTextArea();
				add(JTextAreaMatrix[columns][rows],gbc);
			}
	}
	
	public void updateScorePanel() {		
		Playerlist.clear();
		for (int rows=0; rows<12; rows++)
			for(int columns=0; columns<6; columns++) {
				JTextAreaMatrix[columns][rows].setEditable(false);
				JTextAreaMatrix[columns][rows].setOpaque(false);
				JTextAreaMatrix[columns][rows].setText("");
			}
		try  
		{  	File file=new File("Scores.txt");    
			FileReader fr=new FileReader(file);   
			BufferedReader br=new BufferedReader(fr); 
			StringBuffer sb=new StringBuffer();   
			String line;  
			while((line=br.readLine())!=null)  
			{ 
				n++;
				switch(n%5) {
				case 0: surname = line;
				break;
				case 1: score = line;
				break;
				case 2: time = line;
				break;
				case 3: date = line;
				break;
				case 4: name =line;
				break;
				} 
				sb.append("\n");     //line feed

				if(surname != null && name != null && score != null && time != null && date != null) {
					Playerlist.add(new ModelPlayer(name, surname, score, time, date));
					surname = null;
					name = null;
					score = null;
					time = null;
					date = null;
				} 
			}  
			fr.close(); 
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  

		Collections.sort(Playerlist);
		Collections.reverse(Playerlist);

		int row = 0;
		for(ModelPlayer p : Playerlist) {
			if(row < 12) {
				int column = 0;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(String.valueOf(row+1)+")");

				column++;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(p.getName()+" ");
		
				column++;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(p.getSurname()+" ");
			
				column++;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(p.getdispayscore()+" ");
		
				column++;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(p.getTime()+" ");
				
				column++;
				JTextAreaMatrix[column][row].setForeground(Color.WHITE);
				JTextAreaMatrix[column][row].setText(p.getDate()+"  ");
				row ++;
			}
		}
	}

	public void registerListeners(ControllerGame gameController) {	
		backbutton.addActionListener(gameController);
	}
	
	public JButton getbackbutton() {
		return backbutton;
	}

}

