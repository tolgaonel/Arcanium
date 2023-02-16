package view;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import controller.ControllerGame;

public class ViewPanelOptions extends JPanel{

	private static final long serialVersionUID = 5104757773723808255L;
	private Border border = BorderFactory.createLineBorder(Color.white, 2);
	private boolean back = false;
	
	JButton backbutton;

	public ViewPanelOptions() {
		backbutton = new JButton("Back to Menu");
		backbutton.setContentAreaFilled(false);
		backbutton.setBorder(border);
		backbutton.setForeground(Color.WHITE);
		backbutton.setOpaque(false); 
		backbutton.setFocusable(false);
		add(backbutton);
	}

	public boolean isBack() {
		return back;
	}

	public void setBack(boolean back) {
		this.back = back;
	}
	
	public void registerListeners(ControllerGame gameController) {
		backbutton.addActionListener(gameController);
	}
	
	public JButton getBackButton() {
		return backbutton;
	}

}

