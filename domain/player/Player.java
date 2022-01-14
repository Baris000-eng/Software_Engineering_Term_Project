package domain.player;

import gui.RegisterPanel;

public class Player {
	
	private String username;
	//private char[] password;
	public double score;
	private int life;
	
	

	RegisterPanel rp= new RegisterPanel();
	
	public Player() {
		life=3;
		this.score = 0;
    }

	public Player(String username) {
		this.username=username;
		life=3;
		score=0;
	}
	


	public Player(String username, double score, int life) {
		this.username=username;
		this.score=score;
		this.life=life;
	}
	
	public void setUserName() {
		rp= new RegisterPanel();
		username= rp.getUserNameTextField().getText();
	}

	public void incrementScore() {
		score++;
	}

	public String getUsername() {
		return username;
	}


	public double getScore() {
		return score;
	}

	public int getLives() {
		return life;
	}


	@Override
	public String toString() {
		return "Player " + username + " " + score + " " + life;
	}

	public void setLives(int life) {
		this.life = life;
	}

	public void setScore(double score) {  
		// TODO Auto-generated method stub
		this.score=score;
	}





}
