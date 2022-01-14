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
public class OpeningPanel extends JPanel {

	private JLabel userLabel;
	private JButton logInButton;
	private JButton registerButton;
	private JLabel welcome;
	private JLabel introImage;
	private JOptionPane guideMessage;
	private JButton guideButton;

	public OpeningPanel() {
		super();
		registerButton = new JButton("Register");
		logInButton = new JButton("Log In");
		guideButton = new JButton("Guide");
		welcome= new JLabel();
		welcome.setText("Welcome to Need For Spear!");
		ImageIcon imageIcon = new ImageIcon("intro.png"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(MainFrame.height*2/5, MainFrame.height*2/5,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		introImage= new JLabel(imageIcon);
		guideMessage= new JOptionPane();
		guideMessage.setToolTipText("You can find the game guidelines below:\n "
				+ "First, Enter your username and password to register to the game\n After you register, you can enter the game by pressing login button in the register screen and \n by entering your username & password in the login screen." +
				"Then; if you want to customize the game, please press the customize game button. \n"
				+ "When you press the customize button; sound change button,theme change button,\n guide button appears."
				+ "To change the game sound, you should press the sound change \n button and decrease or increase the game sound afterwards."
				+ "To see the game guidance, you should press the guide button.\n"
				+ "To load a specific game that you want, please press the load \ngame button after registering. \n"
				+ "To create a specific game, you should press the create game button after registering. \n"
				+ "Minimum obstacle numbers that needs to be specified by the player for each obstacle type are as follows: \n"
				+ "Minimum 75 simple obstacles\n"
				+ "Minimum 10 firm obstacles\n"
				+ "Minimum 5 explosive obstacles\n"
				+ "Minimum 10 gift obstacles\n"
				+ "To change the theme of the game, please press theme change button. \n"
				+ "In the running game; press save button to save the current game and play the current game later, \npress quit button to quit the game and return the login panel, \npress pause button to pause the game, \npress load button to load a specific game \n"
				+ "\n"
				+ "Game Objects: \n"
				+ "\n"
				+ "Noble Phantasm: \n"
				+ "It is moved by player. It can move horizontally. It can be rotated to 45 degrees or 135 degrees.\n"
				+ "Obstacles: \n"
				+ "Simple Obstacle: \n"
				+ "It requires only one hit to be broken. \n"
				+ "Firm Obstacle (Steins Gate):\n"
				+ "Harder to broke. Contains numbers on it. It shows the number of needed hits to break a firm obstacle.\n After each hit to the firm obstacle, the number on it decreases. \nIf this number becomes zero, this obstacle becomes broken.\n"
				+ "Explosive Obstacle (Pandora's Box):\n"
				+ "This obstacle has a circular shape. \n It explodes after one hit. It creates some remains and \n depending on the position of remains, the player loses a change."
				+ "Gift Obstacle (Gift of Uranus): \n"
				+ "This obstacle can be broken in one hit. After this obstacle is destroyed, a box falls down to the noble phantasm.\nIf the noble phantasm touches this box,the box opens.\n A magical ability comes out from this box and added to the current magical abillites that \nthe player can use."
				+ "The magical ability coming out of the box can either support the player or make the game-play of the second player harder.\n"
				+ "Useful Magical Abilities: \n"
				+ "Chance Giving Ability\n"
				+ "Increments the player chance by 1.\n"
				+ "Noble Phantasm Expansion:" + "\nThis magical ability doubles the noble phantasm length.\n"
				+ "It is activated by pressing the icon of it in the running game screen.\nIt lasts 30 seconds after activation. \n"
				+ "Magical Hex\n"
				+ "This magical ability adds two magical canons to the ends of the noble phantasm.\nThese canons fire the magical hexes which can hit the obstacles\n"
				+ "It can be activated by pressing its' icon on the running game screen or by pressing H. It lasts 30 seconds after the activation. \n"
				+ "Unstoppable Enchanted Sphere: \n"
				+ "This magical ability makes the enchanted sphere more powerful. \nIt makes enchanted sphere destroy any obstacle (regardless of its type) with just one hit\n"
				+ "It lasts 30 seconds after the activation.\n"
				+ "Enchanted Sphere:\n"
				+ "It is 16x16 pixels. \n It moves between the noble phantasm and the obstacles. \nIt has an effect on the obstacle depending on the hitted obstacle type \n and/or the magical abilities which are currently active.\n"
				+ "While the enchanted sphere is falling; if the enchanted sphere is not hit by the noble phantasm, \n the player looses a chance.\n"
				+ "Once all obstacles are destroyed and the Spear of Power is obtained by the player before the other player, \n this player wins the game\n.".trim());
		
		guideMessage.setFont(new Font("TimesNewRoman", Font.PLAIN, 15));
		
		welcome.setBounds(MainFrame.middleX-5,MainFrame.height*2/5+MainFrame.heightButton,250,MainFrame.heightButton);
		registerButton.setBounds(MainFrame.middleX,MainFrame.height*2/5+2*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		logInButton.setBounds(MainFrame.middleX,MainFrame.height*2/5+3*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		introImage.setBounds((MainFrame.width-MainFrame.height*2/5)/2,0,MainFrame.height*2/5,MainFrame.height*2/5);
		guideButton.setBounds(MainFrame.middleX,MainFrame.height*2/5+5*MainFrame.heightButton,MainFrame.widthButton,MainFrame.heightButton);
		
		this.add(introImage);
		this.add(registerButton);
		this.add(logInButton);
		this.add(welcome);
		this.add(guideButton);

		this.setBackground(Color.RED);
		this.setLayout(null);
	}


	public JLabel getIntroImage() {
		return introImage;
	}


	public void setIntroImage(JLabel introImage) {
		this.introImage = introImage;
	}


	public JLabel getUserLabel1() {
		return userLabel;
	}


	public JButton getLogInButton() {
		return logInButton;
	}


	public JButton getRegisterButton() {
		return registerButton;
	}

	public JButton getGuideButton() {
		return guideButton;
	}
	
	public JOptionPane getGuideMessage() {
		return guideMessage;
	}

	public JLabel getWelcome() {
		return welcome;
	}


	public void setUserLabel1(JLabel userLabel) {
		this.userLabel = userLabel;
	}


	public void setLogInButton(JButton logInButton) {
		this.logInButton = logInButton;
	}


	public void setRegisterButton(JButton registerButton) {
		this.registerButton = registerButton;
	}


	public void setWelcome(JLabel welcome) {
		this.welcome = welcome;
	}
	




}