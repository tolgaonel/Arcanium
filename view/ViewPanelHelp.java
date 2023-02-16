package view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import controller.ControllerGame;

public class ViewPanelHelp extends JPanel{
	
	private static final long serialVersionUID = 5647964693117394126L;
	private Border border = BorderFactory.createLineBorder(Color.white, 2);
	
	private JButton backbutton;
	
	public ViewPanelHelp() {
	

		JTextArea informationtext = new JTextArea();
		informationtext.setText("In this game your goal is to gather maximum amount of points by braking the bricks. \r\n"
				+ "There is 3 difficuly level and also there is 3 types of bricks the red bricks has \r\n"
				+ "1 orange ones has 2 and the black ones has 3 hit life every time that you hit a \r\n"
				+ "brick ypu will gain 100 points. You will be breaking the bricks by a ball that \r\n"
				+ "moves constantly you will have to prevent the ball to hit to ground else you will \r\n"
				+ "lose a life. You will start with 3 life so use them wisely try not to die to get \r\n"
				+ "better. In addition you will prevent the ball from hitting the ground by a paddle\r\n"
				+ "which moves keybor arrow keybindings and also clicking to the mouse right click, \r\n"
				+ "right arrow will let you move paddle right and left click, left arrow will let you\r\n"
				+ "move the paddle left. Thanks for playing my game!!!\r\n"
				+ "				\r\n"
				+ "				   !HAVE FUN!");
		informationtext.setOpaque(false);
		informationtext.setSize(400, 500);
		informationtext.setEditable(false);
		informationtext.setForeground(Color.white);
		add(informationtext);

		
		backbutton = new JButton("Back to Menu");
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(border);
		backbutton.setForeground(Color.WHITE);
		backbutton.setOpaque(false); 
		backbutton.setFocusable(false);
		add(backbutton);
	}
	
	public void registerListeners(ControllerGame gameController) {
		backbutton.addActionListener(gameController);
	}
	
	
	public JButton getBackButton() {
		return backbutton;
	}

}

