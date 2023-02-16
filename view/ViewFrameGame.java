package view;
import javax.swing.JFrame;

public class ViewFrameGame extends JFrame{

	private static final long serialVersionUID = -4233842390976572424L;


	public ViewFrameGame(ViewPanelGameBackground backgroundPanel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// to make the program stop when we click exit
		setSize(550,900);
		setLocationRelativeTo(null);						//to create the frame in the middle
		setResizable(false);
		setTitle("Arkanoid");
		add(backgroundPanel);
		//pack();
	}
}