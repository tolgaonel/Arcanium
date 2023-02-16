package model;

public class ModelBrick {

	private int hitLife;
	private int xLocation;
	private int yLocation;


	public ModelBrick(int x, int y,int a) {
		hitLife = a;
		xLocation = x;
		yLocation = y;
	}

	public void decreaseHitLife() {
		hitLife--;
	}

	public int getHitLife() {
		return hitLife;
	}


	public int getxLocation() {
		return xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

}
