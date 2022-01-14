package domain.obstacles;


public class SimpleObstacle extends Obstacle  {

	

	public SimpleObstacle(String obstacleName, int xLocation, int yLocation) {
		super(obstacleName, xLocation, yLocation);
	}


	public SimpleObstacle(int id, String obstacleName, int xLocation, int yLocation) {
		super(id, obstacleName, xLocation, yLocation);
	}

}
