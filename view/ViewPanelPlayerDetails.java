package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import controller.ControllerGame;

public class ViewPanelPlayerDetails extends JPanel{

	private static final long serialVersionUID = -3539298574037795303L;

	private Border border = BorderFactory.createLineBorder(Color.white, 2);
	private GridBagConstraints gbc = new GridBagConstraints();
	private JLabel namelabel = new JLabel("Name");
	private JTextField nametext = new JTextField();
	private JLabel surnamelabel = new JLabel("Surname");
	private JTextField surnametext = new JTextField();
	private JButton button = new JButton("Save");

	public ViewPanelPlayerDetails(){

		setLayout(new GridBagLayout());
		gbc.insets = new Insets(125,60,125,60);
		gbc.fill = GridBagConstraints.BOTH;

		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 3;
		namelabel.setForeground(Color.WHITE); 
		add(namelabel,gbc);

		gbc.gridx = 3;
		nametext.setSize(new Dimension(30,10));
		nametext.setMinimumSize(new Dimension(30,10));
		nametext.setMaximumSize(new Dimension(30,10));
		add(nametext,gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		surnamelabel.setForeground(Color.WHITE); 
		add(surnamelabel,gbc);

		gbc.gridx = 3;
		surnametext.setSize(new Dimension(30,10));
		surnametext.setMinimumSize(new Dimension(30,10));
		surnametext.setMaximumSize(new Dimension(30,10));
		add(surnametext,gbc);

		gbc.gridx = 3;
		gbc.gridy = 7;
		button.setForeground(Color.WHITE); 
		button.setBorder(border);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setFocusable(false);
		add(button,gbc);
	}

	public void registerListeners(ControllerGame gameController) {
		button.addActionListener(gameController);
	}
	
	public JButton getButton() {
		return button;
	}
	public JTextField getnametext() {
		return nametext;
	} 
	public JTextField getsurnametext() {
		return surnametext;
	}
}
