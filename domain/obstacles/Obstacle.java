package domain.obstacles;


public class Obstacle{ //superclass


	private String obstacleName;
	private int xLocation;
	private int yLocation;
	public boolean isHit= false;


	public Obstacle() {}
	/*public Obstacle(ImageIcon ic) {
		super(ic);
		/*this.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});*/
	//}*/

	public Obstacle(String text,String obstacleName, int xLocation, int yLocation) {
		//super(text);
		this.obstacleName=obstacleName;
		this.xLocation=xLocation;
		this.yLocation=yLocation;
	}


	public Obstacle(String obstacleName, int xLocation, int yLocation) {
		this.obstacleName=obstacleName;
		this.xLocation=xLocation;
		this.yLocation=yLocation;
	}

	public Obstacle(int text, String obstacleName, int xLocation, int yLocation) {
		this.obstacleName=obstacleName;
		this.xLocation=xLocation;
		this.yLocation=yLocation;
	}

	public String getObstacleName() {
		return obstacleName;
	}

	public int getxLocation() {
		return xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	public void isObstacleHit() {
		isHit= true;
	}

	@Override
	public String toString() {
		return "Obstacle " + obstacleName + " " + xLocation + " "
				+ yLocation;
	}
	public int getNumOfHitsRequired() {
		// TODO Auto-generated method stub
		return 1;
	}

}
