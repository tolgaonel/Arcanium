package model;
import java.util.ArrayList;
import java.util.Iterator;

public class ModelLevel {
	private int[][] level1;
	private int[][] level2;
	private int[][] level3;
	private int[][] returnedLevel;
	
	private int x;
	private int y;
	private int levelnumber;
	
	private int timepassed       = 0;

	private ArrayList<ModelBrick> BrickList = new ArrayList<ModelBrick>();


	public ModelLevel(int x, int y) {
		this.setX(x);
		this.setY(y);
	
		level1 = new int[x][y];
		for(int i = 0; i < x; i++)
			for(int j = 2; j < y-2; j++) {
				if((i>3)&&(i<8))
					level1[i][j] = 1;
				else
					level1[i][j] = 0;
			}
		
		level2 = new int[x][y];
		for(int i = 0; i < x; i++)
			for(int j = 2; j < y-2; j++) {
				if((i>3)&&(i<5))
					level2[i][j] = 1;
				else if((i>4)&&(i<7))
					level2[i][j] = 2;
				else if((i>6)&&(i<8))
					level2[i][j] = 1;
				else
					level2[i][j] = 0;
			}
		
		level3 = new int[x][y];
		for(int i = 0; i < x; i++)
			for(int j = 2; j < y-2; j++) {
				if((i>6)&&(i<8))
					level3[i][j] = 1;
				else if((i>3)&&(i<6))
					level3[i][j] = 3;
				else if((i>5)&&(i<7))
					level3[i][j] = 2;
				else
					level3[i][j] = 0;
			}
	}
	
	public void createLevelBricks() {
		BrickList.clear();
		for(int i = 0 ; i < getX() ; i++)
			for(int j = 0 ; j < getY(); j++) {
				if(getLevel(levelnumber)[i][j] == 1) {
					BrickList.add(new ModelBrick(i,j,1));
				}else if (getLevel(levelnumber)[i][j] == 0) {
					BrickList.add(new ModelBrick(i,j,0));
				}else if (getLevel(levelnumber)[i][j] == 2) {
					BrickList.add(new ModelBrick(i,j,2));
				}else if (getLevel(levelnumber)[i][j] == 3) {
					BrickList.add(new ModelBrick(i,j,3));
				}
			}
	}

	public int[][] getLevel(int Levelnumber){
		switch(Levelnumber) {
		case 1:
			returnedLevel = this.level1;
			break;
		case 2:
			returnedLevel = this.level2;
			break;
		case 3:
			returnedLevel =this.level3;
			break;
		}
		return returnedLevel; 

	}
	
	public ModelBrick getBrick(int x, int y) {
		if (x > this.getX() || y > this.getY())
			return null;
		Iterator<ModelBrick> iterator = BrickList.iterator();
		while(iterator.hasNext()) {
			ModelBrick currentBrick = iterator.next();
			if ((currentBrick.getxLocation() == x) && (currentBrick.getyLocation() == y))
				return currentBrick;
		}
		return null;
	}

	public boolean hasBrick() {
		Iterator<ModelBrick> iterator = BrickList.iterator();
		while(iterator.hasNext()) {
			ModelBrick currentBrick = iterator.next();
			if (currentBrick.getHitLife() > 0)
				return true;
		}
		return false;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLevelnumber() {
		return levelnumber;
	}

	public void setLevelnumber(int levelnumber) {
		this.levelnumber = levelnumber;
	}
	
	public ArrayList<ModelBrick> getBrickList(){
		return BrickList;
	}
	
	public int getTimepassed() {
		return timepassed;
	}

	public void setTimepassed(int timepassed) {
		this.timepassed = timepassed;
	}

}
