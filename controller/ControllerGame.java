package controller;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingWorker;

import model.ModelBall;
import model.ModelBrick;
import model.ModelLevel;
import model.ModelPaddle;
import model.ModelPlayer;
import view.ViewFrameGame;
import view.ViewPanelGame;
import view.ViewPanelGameMenu;
import view.ViewPanelHelp;
import view.ViewPanelLevelMenu;
import view.ViewPanelOptions;
import view.ViewPanelPlayerDetails;
import view.ViewPanelScore;

import java.time.LocalDate;

public class ControllerGame  implements ActionListener{



	private ViewFrameGame           myFrame         = null;
	
	private ViewPanelGameMenu       gmp             = null;
	private ViewPanelGame           gamePanel       = null;
	private ViewPanelLevelMenu      lmp             = null; 
	private ViewPanelPlayerDetails  pdp             = null; 
	private ViewPanelScore          sp              = null;
	private ViewPanelHelp           hp              = null; 
	private ViewPanelOptions        op              = null;
	
	private ModelLevel              level           = null;
	private ModelPlayer             myPlayer        = null;
	private ModelBall               myBall          = null;
	private ModelPaddle             myPaddle        = null;
	
	private Action  				leftAction;
	private Action  				rightAction;
	private Action  				quitAction;
	private Mouse 					mymouse;
	
	

	public ControllerGame(ViewFrameGame myFrame, 
			              ViewPanelGameMenu       gmp,             ViewPanelGame     gamePanel,   ViewPanelLevelMenu lmp, 
			              ViewPanelPlayerDetails  pdp,             ViewPanelScore    sp,          ViewPanelHelp      hp,          ViewPanelOptions   op,
			              ModelLevel              level,           ModelPlayer       myPlayer,    ModelBall          myBall,      ModelPaddle        myPaddle) 
	{
		
		this.myFrame         = myFrame;
		
		this.gmp             = gmp;
		this.gamePanel       = gamePanel;
		this.lmp             = lmp; 
		this.pdp             = pdp; 
		this.sp              = sp;
		this.hp              = hp; 
		this.op              = op;
		
		this.level           = level;
		this.myPlayer        = myPlayer;
		this.myBall          = myBall;
		this.myPaddle        = myPaddle;
		
		leftAction = new LeftAction();
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "leftAction");
		gamePanel.getActionMap().put("leftAction", leftAction);

		rightAction = new RightAction();
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "rightAction");
		gamePanel.getActionMap().put("rightAction", rightAction);
		
		quitAction = new QuitAction();
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("control Q"),  "quitAction");
		gamePanel.getActionMap().put("quitAction", quitAction);
		
		mymouse = new Mouse();
		gamePanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		gamePanel.addMouseMotionListener(mymouse);
		
	}

	@Override
	public void actionPerformed(ActionEvent e){	
		//gmp
		if(e.getSource()            == gmp.getNewGameButton()){
			handleGmpNewGameButton();
		}else if(e.getSource()      == gmp.getOptionsButton()){
			handleGmpOptionsButton();
		}else if(e.getSource()      == gmp.getScoresButton()){
			handleGmpScoresButton();
		}else if(e.getSource()      == gmp.getHelpButton()){
			handleGmpHelpButton();
		}else if(e.getSource()      == gmp.getAboutButton()){
			handleGmpAboutButton();
		}else if(e.getSource()      == gmp.getExitButton()) {
			handleGmpExitButton();
		}
		
	    //hp	
		else if(e.getSource()       == hp.getBackButton()) {
			handleHpBackButton();
		}
		
		//lmp
		else if(e.getSource()       == lmp.getLevel1()) {
			handleLmpLevel1();
		}else if(e.getSource()      == lmp.getLevel2()) {
			handleLmpLevel2();
		}else if(e.getSource()      == lmp.getLevel3()) {
			handleLmpLevel3();
		}
		
		//op
		else if(e.getSource()       == op.getBackButton()) {
			handleOpBackButton();
		}
				
		//pdp
		else if(e.getSource()       == pdp.getButton()) {
			handlePdpButton();
		}
		
		//sp
		else if(e.getSource()       == sp.getbackbutton()) {
			handleSpBackButton();
		}
		
	} //action performed

	
	///// Gmp Handlers ///////////////////
	
	private void handleGmpNewGameButton() {
		gmp.setVisible(false);
		lmp.setVisible(true);
	}
	
	private void handleGmpOptionsButton() {
		gmp.setVisible(false);
		op.setVisible(true);
	}
	private void handleGmpScoresButton() {
		gmp.setVisible(false);
		sp.updateScorePanel();
		sp.setVisible(true);
	}
	private void handleGmpHelpButton() {
		gmp.setVisible(false);
		hp.setVisible(true);
	}
	private void handleGmpAboutButton() {
		JOptionPane.showMessageDialog (gmp,new JTextField("NAME : Ece SURNAME : Önel SCHOOL NUMBER : 20200702088 EMAIL : ece.onel@std.yeditepe.edu.tr",20).getText(),
				                        "About", JOptionPane.INFORMATION_MESSAGE);
	}
	private void handleGmpExitButton() {
		myFrame.dispose();
		System.exit(0);
	}
	
	//// Hp handlers /////////////
	private void handleHpBackButton() {
		hp.setVisible(false);
		gmp.setVisible(true);
	}
	
	//// Lpm handlers ////////////	
	private void handleLmpLevel1() {
		level.setLevelnumber(1);
		lmp.setVisible(false);
		gamePanel.setVisible(true);
		SwingWorker<Object, Object> sw1 =  new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				playGame();
				return null;
			}};
		sw1.execute();
	}
	
	private void handleLmpLevel2() {
		level.setLevelnumber(2);
		lmp.setVisible(false);
		gamePanel.setVisible(true);
		SwingWorker<Object, Object> sw1 =  new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				playGame();
				return null;
			}};
		sw1.execute();	}
	private void handleLmpLevel3() {
		level.setLevelnumber(3);
		lmp.setVisible(false);
		gamePanel.setVisible(true);
		SwingWorker<Object, Object> sw1 =  new SwingWorker<Object, Object>() {
			@Override
			protected Object doInBackground() throws Exception {
				playGame();
				return null;
			}};
		sw1.execute();	}
	
	//// Op handlers //////////////////
	private void handleOpBackButton() {
		op.setVisible(false);
		gmp.setVisible(true);	
	}
	
    /// Sp Handlers //////////////////	
	private void handleSpBackButton() {
		sp.setVisible(false);
		gmp.setVisible(true);
	}
	
	///// Pdp Handlers ///////////////////
	
	private void handlePdpButton() {
		int seconds = level.getTimepassed() % 60;
		int minutes = (level.getTimepassed()-seconds)/60;
		LocalDate date = java.time.LocalDate.now();
		
		FileWriter writer;
		try {
			writer = new FileWriter("Scores.txt",true);

			String scor ="Score: ";
			writer.write(scor);
			String tmp = String.valueOf(myPlayer.getScore());
			writer.write(tmp);
			String min = "\nMin: ";
			writer.write(min);
			String tmp2 = String.valueOf(minutes);
			writer.write(tmp2);
			String sec = " Sec: ";
			writer.write(sec);
			String tmp3 = String.valueOf(seconds);
			writer.write(tmp3);
			String d = "\nDate: ";
			writer.write(d);
			String tmp4 = String.valueOf(date);
			writer.write(tmp4);
					
			String n = "\nName: ";
			writer.write(n);
			String nt = pdp.getnametext().getText();
			writer.write(nt);
			
			String s = "\nSurname: ";
			writer.write(s);
			String st = pdp.getsurnametext().getText();
			writer.write(st);
			String b = "\n";
			writer.write(b);
			
			writer.close();
		} catch (IOException ex) {
			ex. printStackTrace();
		}
		pdp.setVisible(false);
		gmp.setVisible(true);
	}
		

	public class LeftAction extends AbstractAction{

		private static final long serialVersionUID = -7118447417222323915L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(myPaddle.getMiddlex()>1)
				myPaddle.setMiddlex(myPaddle.getMiddlex()-1);
		}

	}

	public class RightAction extends AbstractAction{

		private static final long serialVersionUID = -6412695092096486681L;

		@Override
		public void actionPerformed(ActionEvent e) {
			if(myPaddle.getMiddlex()<10)
				myPaddle.setMiddlex(myPaddle.getMiddlex()+1);
		}

	}
	
	public class QuitAction extends AbstractAction{

		private static final long serialVersionUID = 4281965455187278282L;

		@Override
		public void actionPerformed(ActionEvent e) {
			myFrame.dispose();
			System.exit(0);
		}

	}
	
	public class Mouse implements MouseMotionListener{
		
		@Override
		public void mouseDragged(MouseEvent e) {
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			int location = e.getX()/45;
			if(location <1) {
				location = 1;
			}
			if(location > 10) {
				location = 10;
			}
				myPaddle.setMiddlex(location);
				
		}
	}
	
	private void playGame() {
		myPlayer.setScore(0);
		myPlayer.setLives(3);
		myBall.setx(5);
		myBall.sety(15);
		Timer      myTimer;
		myTimer        = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				level.setTimepassed(level.getTimepassed()+1);
			}
		};
		myTimer.schedule(task, 1000, 1000);

		level.createLevelBricks();
		gamePanel.drawlevel();
		
		while (true) {
			gamePanel.drawHeader();		
			gamePanel.drawPaddle();
			gamePanel.drawBall();

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			gamePanel.deleteBall(); 
			gamePanel.deletePaddle();
			
			
//			Below functions checks which side of ball has a brick and what is bricks health then breaks or paints 
//          the block accordingly and also chooses which type of bounce that will be done.
			
			ModelBrick currentBrick            = level.getBrick(myBall.gety()                              , myBall.getx());
			
//			ModelBrick currentBrickLeft        = level.getBrick(myBall.gety()                              , myBall.getx() - 1);
//			ModelBrick currentBrickRight       = level.getBrick(myBall.gety()                              , myBall.getx() + 1);

			ModelBrick currentBrickRightOrLeft = level.getBrick(myBall.gety()                              , myBall.getx() + myBall.getlocationchangeX());
			ModelBrick currentBrickBottomOrUp  = level.getBrick(myBall.gety() + myBall.getlocationchangeY(), myBall.getx());
			ModelBrick currentBrickCross       = level.getBrick(myBall.gety() + myBall.getlocationchangeY(), myBall.getx() + myBall.getlocationchangeX());
			
			// current brick
			if(currentBrick != null && currentBrick.getHitLife() > 0) {
				switch(currentBrick.getHitLife()) {

				case 1:
					gamePanel.setLabelBackgroundTransparent(currentBrick.getyLocation(),currentBrick.getxLocation());

					break;
				case 2: 
					gamePanel.setLabelBackground(currentBrick.getyLocation(),currentBrick.getxLocation(),Color.RED);

					break;
				case 3: 
					gamePanel.setLabelBackground(currentBrick.getyLocation(),currentBrick.getxLocation(),Color.ORANGE);

					break;
				}
				
//				switch(currentBrickLeft.getHitLife()) {
//
//				case 1:
//					gamePanel.setLabelBackgroundTransparent(currentBrickLeft.getyLocation(),currentBrickLeft.getxLocation());
//
//					break;
//				case 2: 
//					gamePanel.setLabelBackground(currentBrickLeft.getyLocation(),currentBrickLeft.getxLocation(),Color.RED);
//
//					break;
//				case 3: 
//					gamePanel.setLabelBackground(currentBrickLeft.getyLocation(),currentBrickLeft.getxLocation(),Color.ORANGE);
//
//					break;
//				}
//				
//				switch(currentBrickRight.getHitLife()) {
//
//				case 1:
//					gamePanel.setLabelBackgroundTransparent(currentBrickRight.getyLocation(),currentBrickRight.getxLocation());
//
//					break;
//				case 2: 
//					gamePanel.setLabelBackground(currentBrickRight.getyLocation(),currentBrickRight.getxLocation(),Color.RED);
//
//					break;
//				case 3: 
//					gamePanel.setLabelBackground(currentBrickRight.getyLocation(),currentBrickRight.getxLocation(),Color.ORANGE);
//
//					break;
//				}
//				currentBrickLeft.decreaseHitLife();
//				currentBrickRight.decreaseHitLife();
				
				currentBrick.decreaseHitLife();
				
				myBall.setlocationchangeX(-myBall.getlocationchangeX());
				myBall.setlocationchangeY(-myBall.getlocationchangeY());
				
				myPlayer.setScore(myPlayer.getScore()+100);
			}
			
			//bottom or up
			else if(currentBrickBottomOrUp != null && currentBrickBottomOrUp.getHitLife() > 0) {
				switch(currentBrickBottomOrUp.getHitLife()) {

				case 1:
					gamePanel.setLabelBackgroundTransparent(currentBrickBottomOrUp.getyLocation(),currentBrickBottomOrUp.getxLocation());

					break;
				case 2: 
					gamePanel.setLabelBackground(currentBrickBottomOrUp.getyLocation(),currentBrickBottomOrUp.getxLocation(),Color.RED);

					break;
				case 3: 
					gamePanel.setLabelBackground(currentBrickBottomOrUp.getyLocation(),currentBrickBottomOrUp.getxLocation(),Color.ORANGE);

					break;
				}
				currentBrickBottomOrUp.decreaseHitLife();
				myBall.setlocationchangeY(-myBall.getlocationchangeY());
				myPlayer.setScore(myPlayer.getScore()+100);
			}

			//from Cross
			else if(currentBrickCross != null && currentBrickCross.getHitLife() > 0) {
				switch(currentBrickCross.getHitLife()) {
				case 1:
					gamePanel.setLabelBackgroundTransparent(currentBrickCross.getyLocation(),currentBrickCross.getxLocation());
					break;
				case 2: 
					gamePanel.setLabelBackground(currentBrickCross.getyLocation(),currentBrickCross.getxLocation(),Color.RED);	
					break;
				case 3: 
					gamePanel.setLabelBackground(currentBrickCross.getyLocation(),currentBrickCross.getxLocation(),Color.ORANGE);
					break;
				}
				currentBrickCross.decreaseHitLife();
				myBall.setlocationchangeX(-myBall.getlocationchangeX());
				myBall.setlocationchangeY(-myBall.getlocationchangeY());
				myPlayer.setScore(myPlayer.getScore()+100); 
			}
			
			//right or left
			else if(currentBrickRightOrLeft != null && currentBrickRightOrLeft.getHitLife() > 0) {
				switch(currentBrickRightOrLeft.getHitLife()) {
				case 1:
					gamePanel.setLabelBackgroundTransparent(currentBrickRightOrLeft.getyLocation(),currentBrickRightOrLeft.getxLocation());

					break;
				case 2:  
					gamePanel.setLabelBackground(currentBrickRightOrLeft.getyLocation(),currentBrickRightOrLeft.getxLocation(),Color.RED);

					break;
				case 3: 
					gamePanel.setLabelBackground(currentBrickRightOrLeft.getyLocation(),currentBrickRightOrLeft.getxLocation(),Color.ORANGE);
					break;
				}
				currentBrickRightOrLeft.decreaseHitLife();
				myBall.setlocationchangeX(-myBall.getlocationchangeX());
				myPlayer.setScore(myPlayer.getScore()+100);
			}
			
			//bounce from paddle
			if((myBall.getx()  == myPaddle.getMiddlex()-1 || myBall.getx()  == myPaddle.getMiddlex()-2 )  && (myBall.gety() == 26)) {
				   myBall.PaddleBounceleft();
			}
			if((myBall.getx()  == myPaddle.getMiddlex()  &&  myBall.gety()  == 26)) {
					myBall.PaddleBounceMiddle();
			}
			if((myBall.getx()  == myPaddle.getMiddlex()+1  || myBall.getx()  == myPaddle.getMiddlex()+2) && (myBall.gety() == 26)) {
					myBall.PaddleBounceRight();
			}

			//move the ball
			myBall.moveBall();
			//System.out.print("Ball X dX Y dY : ");
			//System.out.println(myBall.getx() + " " + myBall.getlocationchangeX() + " " + myBall.gety() + " " + myBall.getlocationchangeY());

			if(myBall.gety() >= 27) {
				myBall.setx(5);
				myBall.sety(15);
				myBall.setlocationchangeX(1);
				myBall.setlocationchangeY(1);
				myPlayer.decreseLive();
			}
		
			if(!level.hasBrick()) {
				level.setLevelnumber((level.getLevelnumber()+1));
				if(level.getLevelnumber()>3) {
					myTimer.cancel();
					gamePanel.setVisible(false);
					pdp.setVisible(true);
					break;
				}
				myBall.setx(5);
				myBall.sety(15);
				myBall.setlocationchangeX(1);
				myBall.setlocationchangeY(1);
				level.createLevelBricks();
				gamePanel.drawlevel();
			} 
			if(myPlayer.getLives() == 0){
				myTimer.cancel();
				gamePanel.setVisible(false);
				pdp.setVisible(true);
				break;
			}
		} //while (true)
	} // playgame()
	
	
}
