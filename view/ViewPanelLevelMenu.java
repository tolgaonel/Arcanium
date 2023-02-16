package view;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ControllerGame;

public class ViewPanelLevelMenu extends JPanel{

	private static final long serialVersionUID = 850315195984426813L;

	private GridBagConstraints gbc = new GridBagConstraints();
	private JButton Level1,Level2,Level3;
	private Border border = BorderFactory.createLineBorder(Color.white, 2);

	public ViewPanelLevelMenu() {

		setLayout(new GridBagLayout());
		gbc.insets = new Insets(80,170,80,170);
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 3;
		Level1 = new JButton("Level 1");
		Level1.setContentAreaFilled(false);
		Level1.setBorder(border);
		Level1.setForeground(Color.WHITE); 
		Level1.setOpaque(false);
		Level1.setFocusable(false);
		add(Level1, gbc); 

		gbc.gridy = 5;
		Level2 = new JButton("Level 2");
		Level2.setContentAreaFilled(false);
		Level2.setBorder(border);
		Level2.setForeground(Color.WHITE);
		Level2.setOpaque(false);
		Level2.setFocusable(false);
		add(Level2, gbc);

		gbc.gridy = 7;
		Level3 = new JButton("Level3");
		Level3.setOpaque(false);
		Level3.setContentAreaFilled(false);
		Level3.setBorder(border);
		Level3.setForeground(Color.WHITE);
		Level3.setFocusable(false);
		add(Level3, gbc);

	}
	
	public void registerListeners(ControllerGame gameController) {
		Level1.addActionListener(gameController);
		Level2.addActionListener(gameController);
		Level3.addActionListener(gameController);		
	}
	
	public JButton getLevel1() {
		return Level1;
	}
	
	public JButton getLevel2() {
		return Level2;
	}
	public JButton getLevel3() {
		return Level3;
	}
	
}