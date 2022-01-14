package domain.saveLoad;

import java.io.IOException;
import java.util.List;

import domain.obstacles.Obstacle;

public interface ISaveLoadAdapter {   //WE CREATED THIS CLASS BUT DID NOT APPLY ADAPTER PATTERN YET.

	public void saveGame(List<Obstacle> obstacles);
	public void addUser(String username, String password);
	public Boolean userExist(String username,String password) throws IOException ;
	public Boolean usernameExist(String username) throws IOException;
	public String listGames(String username);
	
}
