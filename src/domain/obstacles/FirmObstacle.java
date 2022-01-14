package domain.obstacles;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FirmObstacle extends Obstacle{

	private static int numOfHitsRequired;
	Random random = new Random();
	public FirmObstacle(String text,String obstacleName, int xLocation, int yLocation) {
		super( text, obstacleName,  xLocation,  yLocation);
		numOfHitsRequired=Integer.parseInt(text);
		
	}
	
	List<NumOfHitsListener> listeners = new ArrayList<>();

	/*public void setTime() {
		publishHitEvent();

	}*/
	
	public void setNumOfHitsRequired(int numOfHitsRequired){
		publishHitEvent();
		this.numOfHitsRequired=numOfHitsRequired;

	}

	public void addHitListener(NumOfHitsListener lis) {
		listeners.add(lis);
	}


	public void publishHitEvent() {
		for(NumOfHitsListener l: listeners)
			l.onHitEvent();
	}
	public int getNumOfHitsRequired(){
		return numOfHitsRequired;

	}

	//public FirmObstacle(ImageIcon ic) {
	//	super(ic);
	//	numOfHitsRequired=random.nextInt(8)+2;
	//}

	public FirmObstacle(String obstacleName, int xLocation, int yLocation) {
		super(obstacleName, xLocation, yLocation);
		numOfHitsRequired=random.nextInt(8)+2;
		// TODO Auto-generated constructor stub
	}

	public FirmObstacle(int numHits, String obstacleName, int xLocation, int yLocation) {
		super(numHits, obstacleName, xLocation, yLocation);
		numOfHitsRequired=numHits;
		// TODO Auto-generated constructor stub
	}

	public FirmObstacle(String obstacleName, int xLocation, int yLocation,int numOfHitsRequired) {
		super(obstacleName, xLocation, yLocation);
		this.numOfHitsRequired = numOfHitsRequired;
	}



}
