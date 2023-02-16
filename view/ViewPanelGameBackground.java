package view;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Image;
import javax.swing.ImageIcon;


public class ViewPanelGameBackground extends JPanel{
	
	private static final long serialVersionUID = 6918068925577074234L;

	private Image backgroundImage;
	private ImageIcon myBackgroundIcon;
	
	private GridBagConstraints gbc = new GridBagConstraints();
	
	public ViewPanelGameBackground(String fileName, int x, int y,
			                       ViewPanelGameMenu gmp, ViewPanelGame gamePanel, ViewPanelLevelMenu lmp, ViewPanelPlayerDetails pdp, 
			                       ViewPanelScore    sp,  ViewPanelHelp hp,        ViewPanelOptions op) {
		
		setLayout(new GridBagLayout());
		//gbc.insets = new Insets(100,100,100,100);
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 0.5;
		gbc.weighty = 0.5;
		
	
		myBackgroundIcon = new ImageIcon(fileName);
		try {

			backgroundImage = myBackgroundIcon.getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		add(gmp, gbc);
		gmp.setOpaque(false);
		gmp.setVisible(true);
		
		add(lmp, gbc);
		lmp.setOpaque(false);
		lmp.setVisible(false);
		
		add(pdp, gbc);
		pdp.setOpaque(false);
		pdp.setVisible(false);
		
		add(hp,gbc);
		hp.setOpaque(false);
		hp.setVisible(false);
		
		add(op,gbc);
		op.setOpaque(false);
		op.setVisible(false); 
		
    	add(gamePanel, gbc);
		gamePanel.setOpaque(false);
		gamePanel.setVisible(false);
    	
    	add(sp,gbc);
    	sp.setOpaque(false);
    	sp.setVisible(false);
		
	}
	
    @Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, null);
	}

}


