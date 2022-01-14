package domain.player;


public class EnchantedSphere{

	
	private int xLocation;
	private int yLocation;


	public EnchantedSphere(int x, int y) {
		xLocation=x;
		yLocation=y;
	}


	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}

	public void setyLocation(int yLocation) {
		this.yLocation = yLocation;
	}

	
	public int getxLocation() {
		return xLocation;
	}

	public int getyLocation() {
		return yLocation;
	}

	@Override
	public String toString() {
		return "EnchantedSphere " + xLocation + " " + yLocation;
	}


}
