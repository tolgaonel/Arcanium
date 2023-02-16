package model;

public class ModelBall {
	private int x=5;
	private int y=24;
	private int locationChangeX = 1;
	private int locationChangeY = 1;	
	private int xMax = 12;
	private int yMax = 30;
	//A number that x and y cannot ever take in this game so that we can initialize start

	public ModelBall(){}

	public void moveBall() {
		    
		if (x >= (xMax-1))
			locationChangeX = -1;
        if(x <= 0)
			locationChangeX =  1;
		if(y >= (yMax-1))
			locationChangeY = -1;
		if(y <= 1)			
			locationChangeY =  1;
		
		x+=locationChangeX;
		y+=locationChangeY;
		
	}

	public void PaddleBounceleft() {
		locationChangeY = -1;
		locationChangeX = -1;
	}

	public void PaddleBounceRight() {
		locationChangeY = -1;	
		locationChangeX = +1;
	}

	public void PaddleBounceMiddle() {
		locationChangeY = -1;	
		locationChangeX = 0;
	}

	public int getlocationchangeX() {
		return locationChangeX;
	}
	public void setlocationchangeX(int a) {
		locationChangeX = a;
	}
	public int getlocationchangeY() {
		return locationChangeY;
	}
	public void setlocationchangeY(int a) {
		locationChangeY = a;
	}

	public int gety() {
		return y;
	}

	public int getx() {
		return x;
	}

	public void sety(int a) {
		y = a;
	}

	public void setx(int b) {
		x = b;
	}

}
