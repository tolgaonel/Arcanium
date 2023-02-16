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

public class ViewPanelGameMenu extends JPanel{
	private static final long serialVersionUID = 7758624654868289747L;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	private JButton NewGameButton,OptionsButton,ScoresButton,HelpButton,ExitButton,AboutButton;
	private Border border = BorderFactory.createLineBorder(Color.white, 2);
	
	
	public ViewPanelGameMenu() {
		
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(30,170,30,170); 
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		gbc.gridx = 1;
		gbc.gridy = 1;
		NewGameButton = new JButton("New Game");
		NewGameButton.setContentAreaFilled(false);
		NewGameButton.setBorder(border);
		NewGameButton.setForeground(Color.WHITE);
		NewGameButton.setOpaque(false); 
		NewGameButton.setFocusable(false);
		add(NewGameButton,gbc);
		
		gbc.gridy = 3;
		OptionsButton = new JButton("Options");
		OptionsButton.setContentAreaFilled(false);
		OptionsButton.setBorder(border);
		OptionsButton.setForeground(Color.WHITE);
		OptionsButton.setOpaque(false);
		OptionsButton.setFocusable(false);
		add(OptionsButton, gbc);
		
		gbc.gridy = 5;
		ScoresButton = new JButton("Scores");
		ScoresButton.setOpaque(false);
		ScoresButton.setContentAreaFilled(false);
		ScoresButton.setBorder(border);
		ScoresButton.setForeground(Color.WHITE);
		ScoresButton.setFocusable(false);
		add(ScoresButton, gbc);
		
		gbc.gridy = 7;
		HelpButton = new JButton("Help");
		HelpButton.setOpaque(false);
		HelpButton.setContentAreaFilled(false);
		HelpButton.setBorder(border);
		HelpButton.setForeground(Color.WHITE);
		HelpButton.setFocusable(false);
		add(HelpButton, gbc);
		
		gbc.gridy = 9;
		AboutButton = new JButton("About");
		AboutButton.setOpaque(false);
		AboutButton.setContentAreaFilled(false);
		AboutButton.setBorder(border);
		AboutButton.setForeground(Color.WHITE);
		AboutButton.setFocusable(false);
		add(AboutButton, gbc);
		
		gbc.gridy = 11;
		ExitButton = new JButton("Exit");
		ExitButton.setOpaque(false);
		ExitButton.setContentAreaFilled(false);
		ExitButton.setBorder(border);
		ExitButton.setForeground(Color.WHITE);
		ExitButton.setFocusable(false);
		add(ExitButton, gbc);

	}
	
	public void registerListeners(ControllerGame gameControler) {
		NewGameButton.addActionListener(gameControler);
		OptionsButton.addActionListener(gameControler);
		ScoresButton.addActionListener(gameControler);
		HelpButton.addActionListener(gameControler);
		AboutButton.addActionListener(gameControler);
		ExitButton.addActionListener(gameControler);

	}

	public JButton getNewGameButton() {
		return NewGameButton;
	}
	
	public JButton getOptionsButton() {
		return OptionsButton;
	}
	public JButton getScoresButton() {
		return ScoresButton;
	}
	public JButton getHelpButton() {
		return HelpButton;
	}
	public JButton getExitButton() {
		return ExitButton;
	}
	public JButton getAboutButton() {
		return AboutButton;
	}
	
}
