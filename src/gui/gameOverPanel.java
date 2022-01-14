package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class gameOverPanel extends JPanel {  //THIS CLASS IS NOT USED YET.

	/*private JLabel gameOverLabel;
	
	private JButton playAgainButton;
	
	private JButton goMainPageButton;
	
	private JLabel gameOverImage;
	


	public gameOverPanel() {
		super();
		goMainPageButton = new JButton("Go to Main Page");
		playAgainButton = new JButton("Play Again");
	
		ImageIcon img = new ImageIcon("gameover.png"); // load 
		Image image = img.getImage(); // transform it 
		Image scaleImg = image.getScaledInstance(MainFrame.height*2/5, MainFrame.height*2/5,  java.awt.Image.SCALE_SMOOTH); // scale   
		img = new ImageIcon(scaleImg);  // transform 
		gameOverImage= new JLabel(img);
		
		
		goMainPageButton.setBounds(MainFrame.middleX,MainFrame.height*2/5+2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		playAgainButton.setBounds(MainFrame.middleX,MainFrame.height*2/5+3*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
	
		
		this.add(goMainPageButton);
		this.add(playAgainButton);
		

		this.setBackground(Color.BLUE);
		this.setLayout(null);
	}



	public JLabel getGameOverLabel() {
		return gameOverLabel;
	}



	public void setGameOverLabel(JLabel gameOverLabel) {
		this.gameOverLabel = gameOverLabel;
	}



	public JButton getPlayAgainButton() {
		return playAgainButton;
	}



	public void setPlayAgainButton(JButton playAgainButton) {
		this.playAgainButton = playAgainButton;
	}



	public JButton getGoMainPageButton() {
		return goMainPageButton;
	}



	public void setGoMainPageButton(JButton goMainPageButton) {
		this.goMainPageButton = goMainPageButton;
	}



	public JLabel getGameOverImage() {
		return gameOverImage;
	}



	public void setGameOverImage(JLabel gameOverImage) {
		this.gameOverImage = gameOverImage;
	}*/




}