package domain.game;

import java.util.ArrayList;
import domain.obstacles.Obstacle;
import domain.obstacles.RemainingsOfExplosiveObstacle;
import domain.player.EnchantedSphere;
import domain.player.NoblePhantasm;
import domain.player.Player;
import gui.MainFrame;


public class Game {
	public static Thread thread;
	public static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	public static Player currentPlayer=new Player();
	public static ArrayList<Player> players=new ArrayList<Player>();
	public static EnchantedSphere sphere = new EnchantedSphere(-1,-1);
	public static NoblePhantasm phantasm = new NoblePhantasm(-1);
	public static String currentPlayerUsername;



	public static boolean collisionOfEnchantedSphereWithNoblePhantasm(NoblePhantasm nob, EnchantedSphere esp) {
		if((nob.getxLocation()-16<esp.getxLocation() && esp.getxLocation()< nob.getxLocation()+ MainFrame.width/10) && esp.getyLocation()+16 > 8*MainFrame.height/10 && esp.getyLocation()<8*MainFrame.width/10+20) {
			return true;
		}
		return false;
	}

	/*public static boolean collisionOfRemainingWithNoblePhantasm(NoblePhantasm nob, RemainingsOfExplosiveObstacle rem) {

		if(nob.getxLocation()-15<rem.getxLocation() && rem.getxLocation()< nob.getxLocation()+ MainFrame.width/10 && rem.getyLocation()+20 >= 8*MainFrame.height/10 && rem.getyLocation()<8*MainFrame.width/10+20) {
			return true;
		}
		return false;
	}*/

	
	public static Boolean collisionSphereFromUp(Obstacle obs,EnchantedSphere esp) {
		if((obs.getxLocation()-16<=esp.getxLocation() && esp.getxLocation()<= obs.getxLocation()+(MainFrame.width/50)) && (obs.getyLocation()==esp.getyLocation()+16)) {
			return true;
		}
		return false;
	}

	public static Boolean collisionSphereFromDown(Obstacle obs,EnchantedSphere esp) {
		if((obs.getxLocation()-16<=esp.getxLocation() && esp.getxLocation()<= obs.getxLocation()+(MainFrame.width/50)) && (esp.getyLocation()==obs.getyLocation()+20)) {
			return true;
		}
		return false;
	}

	public static Boolean collisionSphereFromLeft(Obstacle obs,EnchantedSphere esp) {
		if((obs.getxLocation()==esp.getxLocation()+16) && (obs.getyLocation()-16<=esp.getyLocation() && esp.getyLocation()<=obs.getyLocation()+20)) {
			return true;
		}
		return false;
	}

	public static Boolean collisionSphereFromRight(Obstacle obs,EnchantedSphere esp) {
		if((esp.getxLocation()== obs.getxLocation()+(MainFrame.width/50)) && (obs.getyLocation()-16<=esp.getyLocation() && esp.getyLocation()<=obs.getyLocation()+20)) {
			return true;
		}
		return false;
	}

	//----------------------------------------------------------


	public static Boolean collisionObsFromRight(Obstacle obs1,Obstacle obs2) {
		if((obs2.getxLocation()== obs2.getxLocation()+(MainFrame.width/50)) && (obs2.getyLocation()-20<=obs2.getyLocation() && obs2.getyLocation()<=obs2.getyLocation()+20)) {
			return true;
		}
		return false;
	}
	public static Boolean collisionObsFromUp(Obstacle obs,Obstacle obs2) {
		if((obs.getxLocation()-MainFrame.width/50<=obs2.getxLocation() && obs2.getxLocation()<= obs.getxLocation()+(MainFrame.width/50)) && (obs.getyLocation()==obs2.getyLocation()+20)) {
			return true;
		}
		return false;
	}

	public static Boolean collisionObsFromDown(Obstacle obs,Obstacle obs2) {
		if((obs.getxLocation()-MainFrame.width/50<=obs2.getxLocation() && obs2.getxLocation()<= obs.getxLocation()+(MainFrame.width/50)) && (obs2.getyLocation()==obs.getyLocation()+20)) {
			return true;
		}
		return false;
	}

	public static Boolean collisionObsFromLeft(Obstacle obs,Obstacle obs2) {
		if((obs.getxLocation()==obs2.getxLocation()+MainFrame.width/50) && (obs.getyLocation()-20<=obs2.getyLocation() && obs2.getyLocation()<=obs.getyLocation()+20)) {
			return true;
		}
		return false;
	}


}

