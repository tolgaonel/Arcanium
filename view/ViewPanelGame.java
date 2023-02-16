package view;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;

import model.ModelBall;
import model.ModelBrick;
import model.ModelLevel;
import model.ModelPaddle;
import model.ModelPlayer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ViewPanelGame extends JPanel{

	private static final long serialVersionUID = -7969969035819101516L;

	private JTextPane[][]JTextPaneMatrix;
	private Border       border            = BorderFactory.createLineBorder(Color.white, 1);
	private Border       bordertransparent = BorderFactory.createLineBorder(Color.BLACK, 0);
	
	private ModelLevel  level;
	private ModelBall   myBall;
	private ModelPlayer myPlayer;
	private ModelPaddle myPaddle;
	
	public ViewPanelGame(ModelLevel level, ModelBall myBall, ModelPlayer myPlayer, ModelPaddle myPaddle){
		
		this.level    = level;
		this.myBall   = myBall;
		this.myPlayer = myPlayer;
		this.myPaddle = myPaddle;
		
		int x = level.getX();
		int y = level.getY();
			
		JTextPaneMatrix = new JTextPane[y][x];
		
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx=0.5;
		gbc.weighty=0.5;
		gbc.insets = new Insets(7,10,7,10);

		for(int i=0 ; i < y; i++)
			for(int j=0; j< x; j++) {
				JTextPane textPane = new JTextPane();
				textPane.setEditable(false);
				JTextPaneMatrix[i][j]= textPane;
				gbc.gridx=i;
				gbc.gridy=j;
				JTextPaneMatrix[i][j].setOpaque(false);
				JTextPaneMatrix[i][j].setPreferredSize(new Dimension(45,30));
				JTextPaneMatrix[i][j].setSize(new Dimension(45,30));
				JTextPaneMatrix[i][j].setMinimumSize(new Dimension(45,30));
				JTextPaneMatrix[i][j].setMaximumSize(new Dimension(45,30));
				if(j == 0 || j == x-3) {
					gbc.insets = new Insets(0,0,0,0);
				}
				add(JTextPaneMatrix[i][j], gbc);
				gbc.insets = new Insets(7,10,7,10);
			}
		
	}

	public void setLabelBackground(int x, int y , Color color){
		JTextPaneMatrix[x][y].setBackground(color);
		JTextPaneMatrix[x][y].setOpaque(true);
		JTextPaneMatrix[x][y].setBorder(border);
	}

	public void setLabelText(int x, int y , String text){
		JTextPaneMatrix[x][y].setText(text);
	}

	public void setLabelBackgroundTransparent(int x, int y) {
		JTextPaneMatrix[x][y].setOpaque(false);
		JTextPaneMatrix[x][y].setBorder(bordertransparent);
	}

	public void drawBall() {
		if (level.getBrick(myBall.gety(), myBall.getx()).getHitLife() == 0) {
			JTextPaneMatrix[myBall.getx()][myBall.gety()].setAlignmentX(50);
			JTextPaneMatrix[myBall.getx()][myBall.gety()].insertIcon(new ImageIcon("ball.png"));
		}

	}
	
	public void deleteBall() {
		JTextPaneMatrix[myBall.getx()][myBall.gety()].setText("");
	}
	
	public void writeText(int x, int y, String text) {
		JTextPaneMatrix[x][y].setText(text);
		JTextPaneMatrix[x][y].setForeground(Color.white);
		JTextPaneMatrix[x][y].setFont(JTextPaneMatrix[x][y].getFont().deriveFont(10f));
	}

	public void drawPaddle() {
		int middle = myPaddle.getMiddlex();
		if(middle+1 < 12 && middle-1 >= 0) {
			setLabelBackground(middle-1, 27, Color.BLACK);
			setLabelBackground(middle  , 27, Color.BLACK);
			setLabelBackground(middle+1, 27, Color.BLACK); 
		}
	}
	
	public void deletePaddle() {
		for(int i=0; i<level.getY();i++)
			setLabelBackgroundTransparent(i,27);
	}
	
	public void drawHeader() {
		writeText(5, 0, "Level: " + level.getLevelnumber());
		writeText(0, 0, "Scores: "); 
		writeText(1, 0,""+myPlayer.getScore());
		writeText(11, 0," Lives: "+ myPlayer.getLives());
	}
	
	public void drawlevel() {
		for(ModelBrick i:level.getBrickList()) {
			switch (i.getHitLife()) {
			case 0:
				setLabelBackgroundTransparent(i.getyLocation(),i.getxLocation());
				break;
			case 1:
				setLabelBackground(i.getyLocation(),i.getxLocation(), Color.RED);
				break;
			case 2:
				setLabelBackground(i.getyLocation(),i.getxLocation(), Color.ORANGE);
				break;
			case 3:
				setLabelBackground(i.getyLocation(),i.getxLocation(), Color.BLACK);
				break;

			}
		}
	}
}
