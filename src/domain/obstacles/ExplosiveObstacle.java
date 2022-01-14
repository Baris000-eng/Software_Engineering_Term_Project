package domain.obstacles;


public class ExplosiveObstacle extends Obstacle{
	

	public ExplosiveObstacle(String obstacleName, int xLocation, int yLocation) {
		super(obstacleName, xLocation, yLocation);
	}


	public ExplosiveObstacle(int id, String obstacleName, int xLocation, int yLocation) {
		super(id, obstacleName, xLocation, yLocation);
	}

	
}
