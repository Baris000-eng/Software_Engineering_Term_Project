package domain.player;


import gui.RunningGamePanel;

public class NoblePhantasm{
	private double length;
	private double thickness;
	private double xLocation;
	
	//private double angle;
	private double speed;
	
	
	public NoblePhantasm(int xLocation) {
		this.xLocation = xLocation;
	}

	/*public NoblePhantasm(int xDimension,int yDimension,int speed,int angle,int thickness,int length,int xLocation) {
		this.xDimension=xDimension;
		this.yDimension=yDimension;
		this.length=length;
		this.xLocation=xLocation;
		this.speed=speed;
		this.thickness=thickness;
		this.angle=angle;
	}*/
	
	
	public void setLength() {
		RunningGamePanel rgp= new RunningGamePanel();
		length= rgp.getWidth()/10;
	}
	
	
	public double getLength() {
		return length;
	}
	
	public void addTwoCanons() {
		
	}
	public void fireEnchantedSphere() {
		
	}
	public void catchMagicalBox() {
		
	}
	public double getThickness() {
		return thickness;
	}
	
	
	
	public double getxLocation() {
		return xLocation;
	}
	public void setxLocation(int xLocation) {
		this.xLocation = xLocation;
	}
	
	/*public void setAngle(double angle) {
		this.angle = angle;
	}*/
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	

	

}
