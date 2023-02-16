package main;

import controller.ControllerGame;
import model.ModelBall;
import model.ModelLevel;
import model.ModelPaddle;
import model.ModelPlayer;
import view.ViewFrameGame;
import view.ViewPanelGame;
import view.ViewPanelGameBackground;
import view.ViewPanelGameMenu;
import view.ViewPanelHelp;
import view.ViewPanelLevelMenu;
import view.ViewPanelOptions;
import view.ViewPanelPlayerDetails;
import view.ViewPanelScore;

class MainClass {
	public static void main(String[] args) {
		
		int x                    = 30;
		int y                    = 12;
		int middlePaddleLocation = 5;
		
		//Model (Data)
		ModelLevel  level    = new ModelLevel(x, y);
		ModelBall   myBall   = new ModelBall();
		ModelPlayer myPlayer = new ModelPlayer();
		ModelPaddle myPaddle = new ModelPaddle(middlePaddleLocation);

		
		//View (User Interface)
		ViewPanelGameMenu      gmp       = new ViewPanelGameMenu();
		ViewPanelGame          gamePanel = new ViewPanelGame(level, myBall, myPlayer, myPaddle);
		ViewPanelLevelMenu     lmp       = new ViewPanelLevelMenu();
		ViewPanelPlayerDetails pdp       = new ViewPanelPlayerDetails();
		ViewPanelScore         sp        = new ViewPanelScore();	
		ViewPanelHelp          hp        = new ViewPanelHelp();
		ViewPanelOptions       op        = new ViewPanelOptions();
		
		ViewPanelGameBackground backgroundPanel = new ViewPanelGameBackground("Spaceinexamle.jpg",x,y,
				                                                               gmp, gamePanel, lmp, pdp, sp, hp, op);
		
		ViewFrameGame myFrame = new ViewFrameGame(backgroundPanel);
		
		//Controller 
		ControllerGame myGameController = new ControllerGame(myFrame,
				                                             gmp,             gamePanel, lmp,
				                                             pdp,             sp,        hp,        op,
														     level,           myPlayer,  myBall,    myPaddle);
		
		//register listeners
		gmp.registerListeners(myGameController);
		hp.registerListeners(myGameController);
		lmp.registerListeners(myGameController);
		op.registerListeners(myGameController);
		pdp.registerListeners(myGameController);
		sp.registerListeners(myGameController);
		
		myFrame.setVisible(true);		
	}
}