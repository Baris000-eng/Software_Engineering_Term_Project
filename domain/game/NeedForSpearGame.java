package domain.game;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;

import domain.obstacles.Obstacle;
import domain.obstacles.ObstacleFactory;
import domain.obstacles.RemainingsOfExplosiveObstacle;

import domain.player.EnchantedSphere;
import domain.player.NoblePhantasm;
import domain.player.Player;
//import domain.saveLoad.DatabaseSaveLoadAdapter;  //Database works only locally for now. TXT works very well.
import domain.saveLoad.TxtSaveLoadAdapter;

public class NeedForSpearGame { //controller

	private TxtSaveLoadAdapter txtSaveLoadAdapter;

	public NeedForSpearGame(TxtSaveLoadAdapter txtSaveLoadAdapter) {
		this.txtSaveLoadAdapter=txtSaveLoadAdapter;
	}

	public NeedForSpearGame() {
		this.txtSaveLoadAdapter=new TxtSaveLoadAdapter();
	}

	public void addUser(String username, String password) {
		this.txtSaveLoadAdapter.addUser(username, password);
		//DatabaseConnection.addUser(username, password);
	}

	public void saveGame(String gameName) {
		txtSaveLoadAdapter.saveGame(gameName, Game.currentPlayer,Game.sphere, Game.obstacles);
	}

	public boolean userExist(String username, String password) {
		try {
			return txtSaveLoadAdapter.userExist(username, password);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}


	/*public boolean collisionOccursFromLeftTop(JLabel simpleObstacle, Obstacle obs2) {
		try {
			return Game.obsLeftUpCornerCollision(simpleObstacle, obs2);
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean collisionOccursFromRightTop(JLabel giftObstacle, Obstacle obs2) {
		try {
			return Game.obsRightUpCornerCollision(giftObstacle, obs2);
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean collisionOccursFromRightDown(JLabel giftObstacle, Obstacle obs2) {
		try {
			return Game.obsRightDownCornerCollision(giftObstacle, obs2);
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean collisionOccursFromLeftDown(JLabel giftObstacle, Obstacle obs2) {
		try {
			return Game.obsLeftDownCornerCollision(giftObstacle, obs2);
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}*/

	public boolean usernameExist(String username) {
		try {
			return txtSaveLoadAdapter.usernameExist(username);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Obstacle createObstacle(String typeOfObstacle, int locX, int locY) {
		Obstacle obs=ObstacleFactory.getInstance().getObstacle(typeOfObstacle, locX, locY);
		Game.obstacles.add(obs);
		return obs;
		//
	}

	public void removeObstacle(int locX, int locY) {

		for (Obstacle o:Game.obstacles){
			if (o.getxLocation()==locX && o.getyLocation()==locY) {
				Game.obstacles.remove(o);
				System.out.println("obstacle removed from arraylist.");
				break;
			}
		}
		//
	}


	/*public int[] createRandomObstacle(int id, String typeOfObstacle) {
		// TODO Auto-generated method stub
		Obstacle obs=ObstacleFactory.getInstance().getRandomObstacle(id,typeOfObstacle);
		Game.obstacles.add(obs);

		int arr[]= {obs.getxLocation(),obs.getyLocation()};
		return arr;
	}*/

	public void createEnchantedSphere(int x, int y) {
		
		if(Game.sphere==null) {
			Game.sphere=new EnchantedSphere(x, y);
		}
	}

	public void updateSphere(int x, int y) {
		
		Game.sphere.setxLocation(x);
		Game.sphere.setyLocation(y);
	}

	public void updatePhantasm(int x) {
		
		Game.phantasm.setxLocation(x);
	}

	public void setCurrentPlayerUsername(String username) {
		
		Game.currentPlayerUsername=username;
	}

	public ArrayList<ArrayList> loadGame() throws IOException {
		//System.out.println(Game.currentPlayer.getUsername());
		//System.out.println(txtSaveLoadAdapter.loadGame(Game.currentPlayer.getUsername()));
		return txtSaveLoadAdapter.loadGame(Game.currentPlayer.getUsername());
	}

	public Player createPlayer(String username) {
		return new Player(username);
	}

	public void setCurrentPlayer(Player player) {
		Game.currentPlayer=player;
	}

	public Player getCurrentPlayer() {
		return Game.currentPlayer;
	}

	public boolean collisionSphereFromDown(Obstacle o, EnchantedSphere sphere) {
		return Game.collisionSphereFromDown( o,  sphere);
	}

	public void removeObs(Obstacle o) {
		Game.obstacles.remove(o);
	}

	public void decrementLives() {
		getCurrentPlayer().setLives(getCurrentPlayer().getLives()-1);
	}

	public int getCurrentPlayerLives() {
		return getCurrentPlayer().getLives();
	}

	public double getCurrentPlayerScore() {
		return getCurrentPlayer().getScore();
	}

	public ArrayList<Obstacle> getObstacles() {
		return Game.obstacles;
	}

	public EnchantedSphere getSphere() {
		
		return Game.sphere;
	}

	public boolean collisionSphereFromUp(Obstacle o, EnchantedSphere sphere) {
		
		return Game.collisionSphereFromUp(o, sphere);
	}

	public boolean collisionSphereFromRight(Obstacle o, EnchantedSphere sphere) {
		
		return Game.collisionSphereFromRight(o, sphere);
	}

	public boolean collisionSphereFromLeft(Obstacle o, EnchantedSphere sphere) {
		
		return Game.collisionSphereFromLeft(o, sphere);
	}

	public NoblePhantasm getPhantasm() {
	
		return Game.phantasm;
	}

	public boolean collisionOfEnchantedSphereWithNoblePhantasm(NoblePhantasm phantasm, EnchantedSphere sphere) {
		
		return Game.collisionOfEnchantedSphereWithNoblePhantasm(phantasm, sphere);
	}

	/*public boolean collisionOfRemainingWithNoblePhantasm(NoblePhantasm phantasm, RemainingsOfExplosiveObstacle rem) {
		
		return Game.collisionOfRemainingWithNoblePhantasm(phantasm, rem);
	}*/

	public void resetObstacles() {
		
		Game.obstacles.removeAll(Game.obstacles);
	}

	public void updateScore() {   //TO DO (UPDATE SCORE ACCORDING TO TIME)
		
		getCurrentPlayer().setScore(getCurrentPlayer().getScore()+1);
		
	}



}

